package Models;

import jakarta.persistence.*; // O import javax.persistence.* si usas Java EE

@Entity
@Table(name = "contacte") // Nombre de la tabla en la BBDD
public class Contacte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "cognoms")
    private String cognoms;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "email")
    private String email;

    // Constructor vacío necesario para Hibernate
    public Contacte() {}

    // Constructor normal (para usar desde tu código)
    public Contacte(int id, String nom, String cognoms, String telefon, String email) {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
        this.telefon = telefon;
        this.email = email;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    // toString()
    @Override
    public String toString() {
        return "Contacte{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", cognoms='" + cognoms + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}