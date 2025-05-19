package Backend;

import java.util.List;

public class FileController implements Controlador {

    private final String dataPath;

    public FileController(String dataPath) {
        this.dataPath = dataPath;
    }

    public void carregarContactes() {
        // Lógica para cargar desde archivo
    }

    @Override
    public Contacte nouContacte(String nom, String cognoms, String telefon, String email) {

        return null;
    }

    @Override
    public Contacte getContactePerId(int id) {

        return null;
    }

    @Override
    public void esborrarContacte(int ID) {
    }

    @Override
    public Contacte actualitzarContacte(int ID, String nom, String cognoms, String telefon, String email) {

        return null;
    }

    @Override
    public List<Contacte> getContactes() {

        return List.of();
    }

    @Override
    public List<Contacte> getContactesPerNom(String nom) {
        return List.of();
    }

    @Override
    public List<Contacte> getContactesPerCognoms(String cognoms) {
        return List.of();
    }

    @Override
    public List<Contacte> getContactesPerTelefon(String telefon) {
        return List.of();
    }

    @Override
    public List<Contacte> getContactesPerEmail(String email) {
        return List.of();
    }
}