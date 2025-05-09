package Backend;

import Models.Contacte;

import java.util.ArrayList;
import java.util.List;

public abstract class Controlador {

    protected int lastContactId;    //contador para id único
    protected List<Contacte> contactes;

    public Controlador() {
        this.lastContactId = 0;
        this.contactes = new ArrayList<>();
    }

//M abstractos p la subclases
  public Contacte nouContacte(String nom, String cognoms, String telefon, String email) {
    Contacte nouContacte = new Contacte(++lastContactId, nom, cognoms, telefon, email);
    contactes.add(nouContacte);
    System.out.println("Contacte afegit exitosament.");
    return nouContacte;
}



        public  Contacte actualitzarContacte(int id, String nom, String cognoms, String telefon, String email){
            Contacte c = cercarContactePerId(id);
            if(c!=null){
                c.setNom(nom);
                c.setCognoms(cognoms);
                c.setTelefon(telefon);
                c.setEmail(email);

            }
            return c;        };





    public  void esborrarContacte(int id){
        Contacte c = cercarContactePerId(id);
        if(c!=null){
            contactes.remove(c);
        }
    };





    // Buscar contacto por ID
    public Contacte cercarContactePerId(int id) {
        for (int i = 0; i < contactes.size(); i++) {
            Contacte contacte = contactes.get(i);

            if (contacte.getId() == id) {

                return contacte;

            }

        }

        //des de recorrer array

        System.out.println("No se ha trobat cap contacte en aquest Id.");

        return null;

    }


    // Buscar contacto por nombre.  //no deja añadir símbolo "<"

    public List<Contacte> cercarContactePerNom(String nom) {
        List<Contacte> resultats = new ArrayList<>();
        for (int i = 0; i < contactes.size(); i++) {
            Contacte contacte = contactes.get(i);
            if (contacte.getNom().equalsIgnoreCase(nom)) {
                resultats.add(contacte);
            }

        }
        if (resultats.isEmpty()) {
            System.out.println("No s'ha trobat cap contacte amb aquest nom.");
        }
        return resultats;

    }


    // Buscar contacto por apellidos
    public List<Contacte> cercarContactePerCognoms(String cognoms) {
        List<Contacte> resultat1 = new ArrayList<>();
        for (int i = 0; i < contactes.size(); i++) {
            Contacte contacte = contactes.get(i);
            if (contacte.getCognoms().equalsIgnoreCase(cognoms)) {
                resultat1.add(contacte);
            }

        }

        if (resultat1.isEmpty()) {
            System.out.println("No s'ha trobat cap contacte amb aquest cognom.");
        }

        return resultat1;
    }

    // Buscar contacto por teléfono
    public List<Contacte> cercarContactePerTelefon(String telefon) {
        List<Contacte> phoneNumber = new ArrayList<>();
        for (int i = 0; i < contactes.size(); i++) {
            Contacte contacte = contactes.get(i);
            if (contacte.getTelefon().equalsIgnoreCase(telefon)) {

                phoneNumber.add(contacte);
            }

        }
        if (phoneNumber.isEmpty()) {
            System.out.println("No s'ha trobat cap contacte amb aquest cognom.");

        }
        return phoneNumber;

    }

    // Buscar contacto por email
    public List<Contacte> cercarContactePerEmail(String email) {
        List<Contacte> listaEmail =  new ArrayList<>();
        for (int i = 0; i < contactes.size(); i++) {
            Contacte contacte = contactes.get(i);
            if (contacte.getEmail().equalsIgnoreCase(email)) {
                listaEmail.add(contacte);
            }

        }
        if (listaEmail.isEmpty()) {
            System.out.println("No s'ha trobat cap contacte amb aquest email.");
        }

        return listaEmail;


    }

    //creamos el m. mostrarTotsElsContacte  q recorre el ArrayList

    public void mostrarTotsElsContactes(){

        if(contactes.isEmpty()){

            System.out.println("No hi ha cap contactes per guardat.");

        }else{
            System.out.println("Llistat de contactes: ");
        }

        for (int i = 0; i < contactes.size(); i++) {

            Contacte contacte = contactes.get(i);

            System.out.println(contacte);




        }
    }




}