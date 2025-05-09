package Backend;

import java.io.File;
import java.io.IOException;

import Models.Contacte;
import java.io.*;


    public class FileController extends Controlador {

        private File dataFolder;     // carpeta base: data/
        private File contactFolder;  // subcarpeta: data/contacts/


        public FileController(String dataPath) throws IOException {
            super(); // llama al constructor de Controlador

            // inicializa y crea carpetas
            dataFolder = new File(dataPath);
            if (!dataFolder.exists()) {
                dataFolder.mkdirs();
            }

            contactFolder = new File(dataFolder, "contacts");
            if (!contactFolder.exists()) {
                contactFolder.mkdirs();
            }

            // carga los contactos que ya existan
            carregarContactes();
        }

        @Override
        public Contacte nouContacte(String nom, String cognoms, String telefon, String email) {
            Contacte contacte = super.nouContacte(nom, cognoms, telefon, email);

            if (contacte != null) {
                File f = new File(contactFolder, contacte.getId() + ".txt");
                try {
                    // Crea el fichero
                    if (f.createNewFile()) {
                        FileWriter w = new FileWriter(f);
                        w.write(contacte.getNom()     + "\n");
                        w.write(contacte.getCognoms() + "\n");
                        w.write(contacte.getTelefon() + "\n");
                        w.write(contacte.getEmail()   + "\n");
                        w.close();
                    } else {
                        System.err.println("El fitxer del contacte ja existeix i no s'ha pogut crear.");
                    }
                } catch (IOException e) {
                    System.err.println(" No s'ha pogut guardar el contacte al disc: " + e.getMessage());
                    // El contacte es queda a la memòria igualment
                }
            }

            return contacte;
        }



        @Override
        public Contacte actualitzarContacte(int id, String nom, String cognoms, String telefon, String email) {
            Contacte c = super.actualitzarContacte(id, nom, cognoms, telefon, email);
            if (c != null) {
                File f = new File(contactFolder, c.getId() + ".txt");
                try {
                    // sobreescribe el fichero
                    FileWriter w = new FileWriter(f, false);
                    w.write(c.getNom()     + "\n");
                    w.write(c.getCognoms() + "\n");
                    w.write(c.getTelefon() + "\n");
                    w.write(c.getEmail()   + "\n");
                    w.close();
                } catch (IOException ex) {
                    System.err.println("Error actualizando fichero ID=" + id);
                }
            }
            return c;
        }

        private void guardarContacte(Contacte contacte) throws IOException {
            File fitxerContacte = new File(contactFolder, contacte.getId() + ".txt");
            try (FileWriter writer = new FileWriter(fitxerContacte, false)) {
                writer.write(contacte.getNom() + "\n");
                writer.write(contacte.getCognoms() + "\n");
                writer.write(contacte.getTelefon() + "\n");
                writer.write(contacte.getEmail() + "\n");
            }
        }


        @Override
        public void esborrarContacte(int id) {
            // primero borra en memoria
            super.esborrarContacte(id);
            // luego borra el fichero
            File f = new File(contactFolder, id + ".txt");
            if (f.exists()) {
                if (f.delete()) {
                    System.out.println("Fitxer del contacte " + id + "eliminat correctament.");

                } else {
                    System.out.println("No s'ha pogut eliminar el fitxer del contacte " + id + ".");
                }
            } else {
                System.out.println("El fitxer del contacte " + id + "no existeix.");
            }

        }

        private void carregarContactes() {
            File[] fitxers = contactFolder.listFiles();

            if (fitxers != null) {
                for (File f : fitxers) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                        int id = Integer.parseInt(f.getName().replace(".txt", ""));

                        String nom     = reader.readLine();
                        String cognoms = reader.readLine();
                        String telefon = reader.readLine();
                        String email   = reader.readLine();

                        Contacte contacte = new Contacte(id, nom, cognoms, telefon, email);
                        super.contactes.add(contacte);

                    } catch (IOException | NumberFormatException e) {
                        System.err.println("Error carregant contacte de fitxer " + f.getName() + ": " + e.getMessage());
                    }
                }
            }
        }










    }



