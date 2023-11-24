package UparuMountainGUI;

import java.text.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class In {   
    private static Scanner in = new Scanner(System.in); 
    public static String nextLine() {   
        return in.nextLine(); 
    }
    public static char nextChar() {   
        return in.nextLine().charAt(0); 
    } 
    public static char nextUpperChar() {   
        return in.nextLine().toUpperCase().charAt(0); 
    }
    public static int nextInt() {  
        int result = 0;
        while (true) {
            try {
                result = in.nextInt();
                in.nextLine();
                break;
            } catch (InputMismatchException e) {
                in = new Scanner(System.in);
                System.out.println("Try Again.");
            }
        }
        return result;
    }
    public static double nextDouble() {   
        double d = in.nextDouble();
        in.nextLine();
        return d;   
    }
    public static int readInt(String message) {
        int result = 0;
        while (true) {
            try {
                System.out.println(message + ": ");
                result = in.nextInt();
                in.nextLine();
                break;
            } catch (InputMismatchException e) {
                in = new Scanner(System.in);
                System.out.println("Try Again.");
            }
        }
        return result;
    }
    public static double readDouble(String message) {
        System.out.print(message + ": ");
        return In.nextDouble();
    }
    public static String readString(String message) {
        System.out.print(message + ":");
        return In.nextLine();
    }
    public static String formatted(double amount) {   
        DecimalFormat formatter = 
            new DecimalFormat("###,##0.00");
        return formatter.format(amount); 
    }
}

