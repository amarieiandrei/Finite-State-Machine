package Service;

import java.util.Scanner;

public class SomeMethods {

    public int readInteger(String string) {
        try {
            System.out.println( string );
            Scanner scanner = new Scanner(System.in);
            int integer = scanner.nextInt();
            return integer;
        }
        catch (Exception exception){
            System.out.println( "Integer please!" );
            return readInteger(string);
        }
    }

    public String readString(String string) {
        try {
            System.out.println( string );
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            return input;
        }
        catch (Exception exception){
            System.out.println( "String please!" );
            return readString(string);
        }
    }

}
