package Backend;

import Models.Contacte;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.logging.Level;

public class DataBaseController implements Controlador, AutoCloseable {

    private final SessionFactory factory;
    private final Session session;
    private final CriteriaBuilder criteriaBuilder;

    public DataBaseController() {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        this.factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        this.session = this.factory.openSession();
        this.criteriaBuilder = this.factory.getCriteriaBuilder();
    }

    @Override
    public void close() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    @Override
    public Contacte nouContacte(String nom, String cognoms, String telefon, String email) {
        Contacte contacte = new Contacte();

        contacte.setNom(nom);
        contacte.setCognoms(cognoms);
        contacte.setTelefon(telefon);
        contacte.setEmail(email);

        Transaction transaction = this.session.beginTransaction();
        this.session.persist(contacte);
        transaction.commit();

        return contacte;
    }

    @Override
    public Contacte getContactePerId(int ID) {
        return session.find(Contacte.class, ID);
    }

    @Override
    public void esborrarContacte(int ID) {
        Contacte contacte = session.find(Contacte.class, ID);

        Transaction transaction= session.beginTransaction();
        session.remove(contacte);
        transaction.commit();
    }

    @Override
    public Contacte actualitzarContacte(int ID, String nom, String cognoms, String telefon, String email) {
        Contacte contacte = session.find(Contacte.class, ID);

        Transaction transaction = session.beginTransaction();
        contacte.setNom(nom);
        contacte.setCognoms(cognoms);
        contacte.setTelefon(telefon);
        contacte.setEmail(email);
        session.merge(contacte);
        transaction.commit();

        return contacte;
    }

    @Override
    public List<Contacte> getContactes() {
        CriteriaQuery<Contacte> cr = criteriaBuilder.createQuery(Contacte.class);
        Root<Contacte> root = cr.from(Contacte.class);
        cr.select(root);
        return session.createQuery(cr).getResultList();
    }

    @Override
    public List<Contacte> getContactesPerNom(String nom) {
        return getContactesPerCamp("nom", nom);
    }

    @Override
    public List<Contacte> getContactesPerCognoms(String cognoms) {
        return getContactesPerCamp("cognoms", cognoms);
    }

    @Override
    public List<Contacte> getContactesPerTelefon(String telefon) {
        return getContactesPerCamp("telefon", telefon);
    }

    @Override
    public List<Contacte> getContactesPerEmail(String email) {
        return getContactesPerCamp("email", email);
    }

    private List<Contacte> getContactesPerCamp(String campo, String valor) {
        CriteriaQuery<Contacte> cr = criteriaBuilder.createQuery(Contacte.class);
        Root<Contacte> root = cr.from(Contacte.class);
        cr.select(root).where(criteriaBuilder.like(root.get(campo), "%" + valor + "%"));
        return session.createQuery(cr).getResultList();
    }
}