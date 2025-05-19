package Backend;

import java.lang.reflect.Field;
import java.util.*;

public class MemoryController implements Controlador {

    private int lastContactId;
    private HashMap<Integer, Contacte> contactes;

    public MemoryController() {
        this.lastContactId = 0;
        this.contactes = new HashMap<>();
    }


    protected void setContactID(Contacte c, int id) {
        try {
            Field idField = c.getClass().getDeclaredField("id"); // Cambia "ID" por "id" si tu campo es minúscula
            idField.setAccessible(true);
            idField.setInt(c, id);
            idField.setAccessible(false);
        } catch (Exception e) {
            throw new RuntimeException("Error al asignar el ID al contacto", e);
        }
    }

    @Override
    public Contacte nouContacte(String nom, String cognoms, String telefon, String email) {
        Contacte nouContacte = new Contacte(++lastContactId, nom, cognoms, telefon, email);
        contactes.put(nouContacte.getId(), nouContacte);
        System.out.println("Contacte afegit exitosament.");
        return nouContacte;
    }

    @Override
    public Contacte actualitzarContacte(int id, String nom, String cognoms, String telefon, String email) {
        Contacte c = getContactePerId(id);
        if (c != null) {
            c.setNom(nom);
            c.setCognoms(cognoms);
            c.setTelefon(telefon);
            c.setEmail(email);
        }
        return c;
    }

    @Override
    public void esborrarContacte(int id) {
        contactes.remove(id);
    }

    @Override
    public Contacte getContactePerId(int id) {
        Contacte contacte = contactes.get(id);
        if (contacte != null) {
            return contacte;
        }
        System.out.println("No s'ha trobat cap contacte amb aquest ID.");
        return null;
    }



    @Override
    public List<Contacte> getContactes() {
        return new ArrayList<>(contactes.values());
    }


    @Override
    public List<Contacte> getContactesPerNom(String nom) {
        List<Contacte> resultats = new ArrayList<>();
        for (Contacte contacte : contactes.values()) {
            if (contacte.getNom().equalsIgnoreCase(nom)) {
                resultats.add(contacte);
            }
        }
        if (resultats.isEmpty()) {
            System.out.println("No s'ha trobat cap contacte amb aquest nom.");
        }
        return resultats;
    }

    @Override
    public List<Contacte> getContactesPerCognoms(String cognoms) {
        List<Contacte> resultats = new ArrayList<>();
        for (Contacte contacte : contactes.values()) {
            if (contacte.getCognoms().equalsIgnoreCase(cognoms)) {
                resultats.add(contacte);
            }
        }
        if (resultats.isEmpty()) {
            System.out.println("No s'ha trobat cap contacte amb aquest cognom.");
        }
        return resultats;
    }

    @Override
    public List<Contacte> getContactesPerTelefon(String telefon) {
        List<Contacte> resultats = new ArrayList<>();
        for (Contacte contacte : contactes.values()) {
            if (contacte.getTelefon().equalsIgnoreCase(telefon)) {
                resultats.add(contacte);
            }
        }
        if (resultats.isEmpty()) {
            System.out.println("No s'ha trobat cap contacte amb aquest telèfon.");
        }
        return resultats;
    }

    @Override
    public List<Contacte> getContactesPerEmail(String email) {
        List<Contacte> resultats = new ArrayList<>();
        for (Contacte contacte : contactes.values()) {
            if (contacte.getEmail().equalsIgnoreCase(email)) {
                resultats.add(contacte);
            }
        }
        if (resultats.isEmpty()) {
            System.out.println("No s'ha trobat cap contacte amb aquest email.");
        }
        return resultats;
    }


}
