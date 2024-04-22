
import java.util.Scanner;

/**
 * Implementation of a measuring Scale with a random weight on the
 * left side. The user can manipulate the right to try and balance it.
 *
 * @author XUAN HUY PHAM - 000899551
 */

/**
 * mainly showing the menu
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vendingmachine vendingmachine1 = new Vendingmachine("Polka Dot Bow Tie ", 59.99, 40);

        Vendingmachine vendingmachine2 = new Vendingmachine("Fedora Hat", 199.99, 10);


        System.out.println("Welcome to the Break Room! \n");
        System.out.println("There are two vending machines here:\n");

        System.out.println("1. " + vendingmachine1);
        System.out.println("2. " + vendingmachine2);

        int choice;

        do {
            System.out.println("\nWhat would you like to do?\n");
            System.out.println("1. Insert coins \n2. Get change back \n3. Vend an item \n4. Leave the break room");
            System.out.println("Your choice? ");
            //user will input their choice (1 to 4)
            //Scanner input = new Scanner((System.in));
            choice = scanner.nextInt();
            scanner.nextLine();

            //if they choose 1 (insert coins), there will be two options for them
            //they can choose either machine 1 or machine 2
            //this loop will keep going until user choose the 4th option which is leaving the break room
            if (choice == 1) {
                System.out.println("Which machine do you want to insert coins into?: ");
                int choicemachine = scanner.nextInt();
                scanner.nextLine();

                //if they choose to insert coins into machine 1
                //user need to insert coins respectively toonies, loonies, quarters, dimes, nickels
                if (choicemachine == 1) {
                    System.out.println("Enter coins \nTOONIES / LOONIES / QUARTERS / DIMES / NICKELS");
                    double toonies = scanner.nextDouble();
                    double loonies = scanner.nextDouble();
                    double quarters = scanner.nextDouble();
                    double dimes = scanner.nextDouble();
                    double nickels = scanner.nextDouble();
                    vendingmachine1.insertCoin(toonies, loonies, quarters, dimes, nickels);
                } else if (choicemachine == 2) { //this is if they choose machine 2
                    System.out.println("Enter coins \nTOONIES / LOONIES / QUARTERS / DIMES / NICKELS");
                    double toonies = scanner.nextDouble();
                    double loonies = scanner.nextDouble();
                    double quarters = scanner.nextDouble();
                    double dimes = scanner.nextDouble();
                    double nickels = scanner.nextDouble();
                    vendingmachine2.insertCoin(toonies, loonies, quarters, dimes, nickels);
                } else {
                    //if they choose something not 1 or 2
                    System.out.println("Choose vending machine 1 or 2 only");

                }
            } else if (choice == 2) {
                //if they choose to take all the change back
                //they also have to choose which machine to withdraw
                System.out.println("Which machine do you want to get money back?");
                int returnchoice = scanner.nextInt();

                if (returnchoice == 1) {
                    double amountReturn = vendingmachine1.returnCredit();
                    if (amountReturn > 0) {
                        System.out.println(amountReturn + " was returned to you"); //showing amount that got returned
                    } else {
                        System.out.println("No credit left to return"); //if there's no unused credit left
                    }
                } else if (returnchoice == 2) {
                    double amountReturn = vendingmachine2.returnCredit();
                    if (amountReturn > 0) {
                        System.out.println(amountReturn + " was returned to you"); //same as machine 1
                    } else {
                        System.out.println("No credits left to return");//if there's no unsused credit left
                    }
                } else {
                    //if user didn't choose either 1 or 2
                    System.out.println("Please choose 1 or 2 to proceed with the return");
                }
            } else if (choice == 3) { //when user want to vend items from the machine
                System.out.println("*** VEND AN ITEM ***");
                System.out.println("Which machine to vend?"); //ask user which machine they want to vend
                int vendchoice = scanner.nextInt();

                if (vendchoice == 1) { //if they want to vend items from machine1
                    System.out.println("How many do you want to buy?: "); //ask them about the quantity they want to vend
                    int quantity = scanner.nextInt();
                    if (vendingmachine1.getProductQuantity() == 0) {//if the quantity is 0, it will let user know that out of stock
                        System.out.println("*** OUT OF STOCK ***");
                    } else if (vendingmachine1.getUnusedCredit() >= vendingmachine1.getProductPrice() * quantity) {
                        vendingmachine1.vend(quantity); //vend items succesfully
                    } else {
                        System.out.println("*** NOT ENOUGH CREDIT TO VEND"); //showing that unused credit is not enough to vend
                    }
                } else if (vendchoice == 2) { //exactly the same as machine 1, this is machine2
                    System.out.println("How many do you want to buy?: ");
                    int quantity = scanner.nextInt();
                    if (vendingmachine2.getProductQuantity() == 0) {
                        System.out.println(" *** OUT OF STOCK ***");
                    } else if (vendingmachine2.getUnusedCredit() >= vendingmachine2.getProductPrice() * quantity) {
                        vendingmachine2.vend(quantity);
                    } else {
                        System.out.println("*** NOT ENOUGH CREDIT TO VEND");
                    }
                }
            }

            //showing a report with all updated numbers
            System.out.println("\nVending Machine Report:");
            System.out.println("1. " + vendingmachine1);
            System.out.println("2. " + vendingmachine2);

        } while (choice != 4); //the loop/program will end when user choose to leave the break room

        System.out.println("Goodbye!! See you in the Mr. Moore's class ;)");
    }
}