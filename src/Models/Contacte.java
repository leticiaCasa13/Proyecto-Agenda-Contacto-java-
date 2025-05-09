package Models;

public class Contacte {

    private int id;
    private String nom;
    private String cognoms;
    private String telefon;
    private String email;

    public Contacte(int id, String nom, String cognoms, String telefon, String email) {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
        this.telefon = telefon;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


       //sobrescribimos p que devuelva una descripción más útil del objeto Contacte

    @Override  public String toString() {
        return "Contacte{id=" + id + ", nom= " + nom + ", cognoms=" + cognoms + ", telefon=" + telefon + ", email=" + email + "}";


    }
}
