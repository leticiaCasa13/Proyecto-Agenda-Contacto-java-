package Backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryControllerTest {

    @Test
    void esborrarContacte() {
        // creamos un contacto
        MemoryController controlador = new MemoryController();
        Contacte c = controlador.nouContacte("Elena", "Suarez", "123456789", "elena@example.com");
        int id = c.getId();

        Contacte resultat = controlador.getContactePerId(id);
        assertNotNull(resultat, "El contacte existeix");

        // borra el contacto
        controlador.esborrarContacte(id);

        // se verifica si el contacto existe! Comprueba q el m. getContactePerId de vuelve null si el contacto fue eliminado
        resultat = controlador.getContactePerId(id);
        assertNull(resultat, "El contacte hauria d'estar esborrat");
    }

    @Test
    void nouContacte() {

    }

    @Test
    void actualitzarContacte() {

    }

    @Test
    void cercarContactePerId() {}

    @Test
    void cercarContactePerNom() {}

    @Test
    void cercarContactePerCognoms() {}

    @Test
    void cercarContactePerTelefon() {}

    @Test
    void cercarContactePerEmail() {}
}
