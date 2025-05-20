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
        MemoryController controlador= new MemoryController();
        Contacte c1 = controlador.nouContacte("Miguel", "Rodriguez", "239765490", "miguel@example.com");

        //verifico si se creó

        assertNotNull(c1, "El contacte no hauria de ser null");
        assertEquals("Miguel", c1.getNom(), "Nom incorrecte");
        assertEquals("Rodriguez", c1.getCognoms(), "Cognoms incorrectes");
        assertEquals("239765490", c1.getTelefon(), "Telefon incorrecte");
        assertEquals("miguel@example.com", c1.getEmail(), "Email incorrecte");
    }




    @Test
    void actualitzarContacte() {
        MemoryController controlador = new MemoryController();
        Contacte c = controlador.nouContacte("Elena", "Suarez", "123456789", "elena@example.como");
        int id = c.getId();

        Contacte actualitzat = controlador.actualitzarContacte(id, "Elena", "López", "987654321", "elena.lopez@example.com");

       //verificamos q el contactos se ha actualizado

        assertNotNull(actualitzat, "El contacte hauria d'existir");
        assertEquals("Elena", actualitzat.getNom(), "Nom no actualitzat correctament");
        assertEquals("López", actualitzat.getCognoms(), "Cognoms no actualitzat correctament");
        assertEquals("987654321", actualitzat.getTelefon(), "Telèfon no actualitzat correctament");
        assertEquals("elena.lopez@example.com", actualitzat.getEmail(), "Email no actualitzat correctament");


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
