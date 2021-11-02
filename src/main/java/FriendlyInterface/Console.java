package FriendlyInterface;

import Domain.AutomatFinit;
import Service.SomeMethods;
import jdk.swing.interop.SwingInterOpUtils;

public class Console {
    protected AutomatFinit automatFinit = new AutomatFinit();
    protected SomeMethods someMethods = new SomeMethods();

    protected void consoleMenu() {
        System.out.println("1. Afiseaza Automat Finit.");
        System.out.println("2. Returneaza multimea starilor.");
        System.out.println("3. Returneaza alfabetul.");
        System.out.println("4. Returneaza tranzitiile.");
        System.out.println("5. Returneaza multimea starilor finale.");
        System.out.println("6. Verifica acceptarea unei secvente.");
        System.out.println("7. Pentru o anumita stare si un simbol de pe banda de intrare returneaza starea in care se ajunge");
        System.out.println("8. Exit.");
        System.out.println("\n");
    }

    public void runConsole() {
        while( true ) {
            this.consoleMenu();
            int option = this.someMethods.readInteger("Alege optiune de mai sus: ");

            if( option == 1 ){
                automatFinit.afisAutomatFinit();
            }
            else if( option == 2 ){
                for(String string : automatFinit.getQ() )
                    System.out.println( string );
                System.out.println();
            }
            else if( option == 3 ){
                System.out.println( automatFinit.getAlfabet() + "\n" );
            }
            else if( option == 4 ){
                for(String string : automatFinit.getTranzitii() )
                    System.out.println( string );
                System.out.println();
            }
            else if( option == 5 ){
                System.out.println( automatFinit.getF() + "\n" );
            }
            else if( option == 6 ){
                if( automatFinit.verifAcceptSecventa() )
                    System.out.println("Se accepta aceasta secventa.\n");
                else System.out.println("Nu se accepta aceasta secventa.\n");
            }
            else if( option == 7 ){
                String stare = this.someMethods.readString("Pentru starea: ");
                String simbol = this.someMethods.readString("si simbolul: ");
                System.out.println( this.automatFinit.returnStareaUrmatoare(stare, simbol) );
            }
            else if( option == 8 ){
                break;
            }
        }
    }
}
