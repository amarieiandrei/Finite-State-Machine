package Domain;


import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AutomatFinit {
    //state (fields)
    public String automatFinitTxt = "";

    //behavior (methods)

    protected String createAutomatFinitTxt(){
        String string = "";
        try {
            File file = new File("X:\\Projects\\IntelliJProjectJava\\Lab3LFTC\\AutomatFinit.txt");
            Scanner scan = new Scanner(file);

            while( scan.hasNextLine() )
                string = string.concat( scan.nextLine() );
        }
        catch (Exception e){
            System.out.println("Eroare!");
        }
        return string;
    }

    public void afisAutomatFinit() {
        this.automatFinitTxt = this.createAutomatFinitTxt();
        String[] afis = this.automatFinitTxt.split(";");
        for( String line : afis )
            System.out.println( line );
        System.out.println();
    }

    public String[] getQ() {
        this.automatFinitTxt = this.createAutomatFinitTxt();

        String[] arrAutomatFinit = this.automatFinitTxt.split(";");

        String[] Q;
        Q = arrAutomatFinit[8].split(",");
        return Q;
    }
    public String getAlfabet() {
        this.automatFinitTxt = this.createAutomatFinitTxt();

        String[] arrAutomatFinit = this.automatFinitTxt.split(";");

        return arrAutomatFinit[9];
    }
    public String[] getTranzitii() {
        this.automatFinitTxt = this.createAutomatFinitTxt();

        String[] arrAutomatFinit = this.automatFinitTxt.split(";");

        String[] tranzitii;
        tranzitii = arrAutomatFinit[11].split(",");
        return tranzitii;
    }
    public String getF() {
        this.automatFinitTxt = this.createAutomatFinitTxt();

        String[] arrAutomatFinit = this.automatFinitTxt.split(";");

        return arrAutomatFinit[12];
    }
    private String readSecv() {
        this.automatFinitTxt = this.createAutomatFinitTxt();

        String[] arrAutomatFinit = this.automatFinitTxt.split(";");

        return arrAutomatFinit[16];
    }
    public boolean verifAcceptSecventa() {

        String[] myQ = this.getQ();
        String[] myTranzitionList = this.getTranzitii();

        String string = this.readSecv();

        String[] aux = string.split(",");
        String[] auxSplit = aux[1].split("->");

        boolean Okay = false;

        for(String q : myQ ) {
            if (q.equals(aux[0])) {
                Okay = true;
                break;
            }
        }

        if( Okay == false ) return false;

        Okay = false;

        for(String q : myQ ) {
            if (q.equals(auxSplit[1])) {
                Okay = true;
                break;
            }
        }

        if( Okay == false ) return false;

        Okay = false;

        for(String tranzition : myTranzitionList ) {
            if (tranzition.equals(auxSplit[0])) {
                Okay = true;
                break;
            }
        }

        if( Okay == false ) return false;
        return true;
    }

    public String returnStareaUrmatoare(String stare, String simbol) {
        if( simbol.equals("1") )
            return stare;
        if( stare.equals("q0") && simbol.equals("0") )
            return "q1";
        if( stare.equals("q1") && simbol.equals("0") )
            return "q2";
        return "Datele introduse sunt gresite!";
    }

}
