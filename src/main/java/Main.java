import Frontend.GUI;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
    /*
        TUI tui = new TUI(System.in);
         Controlador controlador = new MemoryController();
         //Controlador controlador = new FileController("data");
        //((FileController) controlador).carregarContactes();
        // Controlador controlador = new DataBaseController();

     */

        //Interface Gráfica

        GUI g = new GUI();


      /*
        //  Prueba rápida de conexión y creación
        try (DataBaseController controlador1 = new DataBaseController()) {
            List<Contacte> contactes = controlador1.getContactes();  // Ahora sí debería funcionar
            for (Contacte c : contactes) {
                System.out.println(c.toString());
            }
        } catch (Exception e) {
            System.err.println(" Error al guardar contacto de prueba");
            e.printStackTrace();
        }





        int opcio = tui.mostrarMenuPrincipal();  //pide la opción al usuario

           while (opcio !=5){       //mientras no sea 5

              switch (opcio) {
                   case 1: crearContacte(tui, controlador);
                       break;

                   case 2: cercarContacte(tui, controlador,sc);
                       break;

                   case 3: actualitzarContacte(tui, controlador);
                       break;

                   case 4: esborrarContacte(tui, controlador);
                      break;

                   case 5:
                       tui.println("Sortin del programa.");
                       break;
                   case 6:
                       List<Contacte> contactes = controlador.getContactes();
                      for (Contacte contacte : contactes) {
                           tui.println(contacte.toString());
                       }
                       break;
                   default:
                      tui.println("");
                       break;
               }

               opcio= tui.mostrarMenuPrincipal();  // empieza de nuevo, pregunta nuevamente al usuario..(evita el bucle infinito).
           }

        tui.println("Sortin del progama");  //cuando la opcio es == a 5..sale


    }


    private static void crearContacte(TUI tui, Controlador controlador) throws IOException {
        String[] camp = tui.demanarDadesNouContacte(); //llam m.TUI
        controlador.nouContacte(camp[0], camp[1], camp[2], camp[3]); // creamos contacto
    }

    public static void cercarContacte(TUI tui, Controlador controlador, Scanner sc) {
        int opcioCerca = tui.mostrarMenuCerca();  // Muestra el menú y recibe la opción y la guarda

        String camp;    //guarda el campo
        String[] valor;  //guarda los valores introd por el usuario

        if (opcioCerca == 1) { // ID
            tui.print("Introdueix l'ID a cercar: ");
            int id = sc.nextInt();
            Contacte contacte = controlador.getContactePerId(id);  //si el id existe el m. devuelve el objeto contacte

            if (contacte != null) {
                tui.println(contacte);
            } else {
                tui.println("No s'ha trobat cap contacte amb aquest ID.");
            }

        } else {
            switch (opcioCerca) {
                case 2: // Nom
                    camp = "nom";
                    valor = tui.demanarDadaCercaContacte(camp);
                    List<Contacte> Nom = controlador.getContactesPerNom(valor[0]);
                    for (int i = 0; i < Nom.size(); i++) {
                        Contacte cont =Nom.get(i);
                        tui.println(cont);
                    }
                    break;

                case 3: // Cognoms
                    camp = "cognoms";
                    valor = tui.demanarDadaCercaContacte(camp);
                    List<Contacte>  Cognoms= controlador.getContactesPerCognoms(valor[0]);
                    for (int i = 0; i < Cognoms.size(); i++) {
                        Contacte cont =Cognoms.get(i);
                        tui.println(cont);
                    }
                    break;

                case 4: // Telèfon
                    camp = "telefon";
                    valor = tui.demanarDadaCercaContacte(camp);
                    List<Contacte>  Telefon= controlador.getContactesPerTelefon(valor[0]);
                    for (int i = 0; i < Telefon.size(); i++) {
                        Contacte cont =Telefon.get(i);
                        tui.println(cont);
                    }
                    break;

                case 5: // Email
                    camp = "email";
                    valor = tui.demanarDadaCercaContacte(camp);
                    List<Contacte>  Email= controlador.getContactesPerEmail(valor[0]);
                    for (int i = 0; i < Email.size(); i++) {
                        Contacte cont =Email.get(i);
                        tui.println(cont);
                    }
                    break;

                default:
                    tui.println("Opció de cerca no vàlida.");
            }
        }
    }



    public static void esborrarContacte(TUI tui, Controlador controlador) {

            int id = tui.demanarIdEsborrarContacte();  // Pedimos el id al usuario
            controlador.esborrarContacte(id);           // Borramos el contacto con ese id
    }





    public static void actualitzarContacte(TUI tui, Controlador controlador) {
            Scanner sc = new Scanner(System.in);
            tui.println("Id del contacte a actualitzar: ");
            int id = sc.nextInt();
            String [] nouDades = tui.demanarDadesActualitzarContacte(); // datos

        controlador.actualitzarContacte(id,nouDades[0], nouDades[1], nouDades[2], nouDades[3]);
    }
   */




    }
}


