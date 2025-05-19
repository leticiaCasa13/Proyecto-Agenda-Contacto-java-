package Backend;

import java.util.List;

public interface Controlador {

    Contacte nouContacte(String nom, String cognoms, String telefon, String email);

    Contacte getContactePerId(int ID);

    void esborrarContacte(int ID);
    Contacte actualitzarContacte(int ID, String nom, String cognoms, String telefon, String email);

    List<Contacte> getContactes();
    List<Contacte> getContactesPerNom(String nom);
    List<Contacte> getContactesPerCognoms(String cognoms);
    List<Contacte> getContactesPerTelefon(String telefon);
    List<Contacte> getContactesPerEmail(String email);
}