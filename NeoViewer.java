/**
* @author J. R. N
*    e-mail: joshua.nghe@stonybrook.edu
*    Stony Brook ID: 114908487
**/

import java.util.InputMismatchException;
import java.util.Scanner;

public class NeoViewer {

    static Scanner input = new Scanner(System.in);

    public static void printMenu(){
        System.out.print("\nOption Menu:\n   A) Add a page to the database\n   S) Sort the database\n   P) Print the database as a table.\n   Q) Quit\n\nSelect a menu option:");
    }

    public static void printSortMenu(){
        System.out.print("\nR) Sort by referenceID\nD) Sort by diameter\nA) Sort by approach date\nM) Sort by miss distance\nSelect an option: ");
    }


    public static int nextIntLine(){
        int n = input.nextInt();
        if(input.hasNextLine()){
            input.nextLine();
        }
        return n;
    }

    /**
     * The main method runs a menu driven application which creates a NeoDatabase instance and then prompts the user for a menu command selecting the operation. The required information is then requested from the user based on the selected operation. Following is the list of menu options and their required information:
     * @param args
     */

    public static void main(String[] args) {
        System.out.println("Welcome to NEO Viewer!");
        NeoDatabase user = new NeoDatabase();

        
        boolean menu = true;

        while(menu){
            printMenu();
            String in = input.nextLine().toUpperCase();

            switch(in){
                case "A":
                    try{
                        System.out.print("Enter the page to load:");
                        int pageNumber = nextIntLine();
                        String newURL = NeoDatabase.buildQueryURL(pageNumber);
                        NeoDatabase.addAll(newURL);

                        System.out.println("\nPage loaded successfully!");
    
                    }catch(InputMismatchException i){

                    }

                    break;
                case "S":
                    printSortMenu();
                    String sInput = input.nextLine().toUpperCase();
                    switch(sInput){
                        case "R":
                            user.sort(new ReferenceIDComparator());
                            System.out.println("Table sorted on referenceID.");
                            break;
                        case "D":
                            user.sort(new DiameterComparator());
                            System.out.println("Table sorted on diameter.");
                            break;
                        case "A":
                            user.sort(new ApproachDateComparator());
                            System.out.println("Table sorted on approach date.");
                            break;
                        case "M":
                            user.sort(new MissDistanceComparator());
                            System.out.println("Table sorted on miss distance.");
                            break;
                        default:
                            System.out.println("Invalid input.");
                    }
                    break;
                case "P":
                    NeoDatabase.printData();
                    break;
                case "Q":
                    System.out.println("\nProgram terminating normally...");
                    menu = false;
                    break;
                default:
                    System.out.println("Invalid input.");

            }
        }


    }
    
}
