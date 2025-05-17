package Frontend;

import java.io.InputStream;
import java.util.Scanner;

public class TUI {
    private InputStream inputStream;   //InputStrem es una clase de java

    public TUI(InputStream inputStream) {
        this.inputStream = inputStream;
    }


    public int mostrarMenuPrincipal() {   // Devuelve la opción escogida.

        Scanner sc = new Scanner(this.inputStream);

        System.out.println("Benvingut a l'agenda, si us plau, tria una opció:");
        System.out.println("1. Crear un nou contacte.");
        System.out.println("2. Cercar contactes existents.");
        System.out.println("3. Actualitzar un contacte existent.");
        System.out.println("4. Eliminar un contacte existent.");
        System.out.println("5. Sortir.");
        System.out.println("6. Mostrar tots els contactes: ");

        System.out.print("Opció: ");

        int opcion = sc.nextInt();

        return opcion;
    }


    public int mostrarMenuCerca() {
        Scanner sc = new Scanner(this.inputStream);

        System.out.println("Menu Cerca: ");
        System.out.println("1. Cercar per ID. ");
        System.out.println("2. Cercar per Nom. ");
        System.out.println("3. Cercar per Congnoms. ");
        System.out.println("4. Telefon: ");
        System.out.println("5. Email: ");
        System.out.println("6. Mostrar tots els contactes: ");

        System.out.println("Opció: ");
        int opcion = sc.nextInt();

        return opcion;
    }

    public String[] demanarDadesNouContacte() {

        Scanner sc = new Scanner(this.inputStream);
        String[]  campo = new String[4];


        //  mostrar mensajes
        System.out.print("Nom del contacte: ");
        campo[0] = sc.nextLine();
        System.out.print("Cognoms del contacte: ");
        campo[1] = sc.nextLine();
        System.out.print("Telefon del contacte: ");
        campo[2] = sc.nextLine();
        System.out.print("Email del contacte: ");
        campo[3] = sc.nextLine();

      return campo;
    }


    public String[] demanarDadaCercaContacte(String camp) {
        Scanner sc = new Scanner(this.inputStream);


        System.out.print("Introdueix el " + camp + " a cercar: ");
        return new String[]{sc.nextLine()};
    }


    public String[] demanarDadesActualitzarContacte() {
        Scanner sc = new Scanner(this.inputStream);


        System.out.println("Introdueix les noves dades del contacte:");

        System.out.print("Nom: ");
        String nom = sc.nextLine();

        System.out.print("Cognoms: ");
        String cognoms = sc.nextLine();

        System.out.print("Telèfon: ");
        String telefon = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        return new String[]{nom, cognoms, telefon, email};
    }


    public void mostrarLinia(Object dades) {    //mostrar datos en consola

        System.out.println(dades);
    }




    public void mostrarLinia(Object[] dades) {     //sobrecarga

        if (dades == null || dades.length == 0) {

            System.out.println("No hi ha dades per mostrar");
        } else {

            System.out.println("Mostrar dades");
            for (Object dada : dades) {
                mostrarLinia(new Object[]{dada});

            }
        }

    }

        public int demanarIdEsborrarContacte(){
        Scanner sc = new Scanner(this.inputStream);

                System.out.print("Introdueix l'id del contacte a esborrar: ");
                return sc.nextInt();

        }

        public void println(Object o){
            System.out.println(o);
        }

        public void print(Object o){
            System.out.print(o);
        }





}

