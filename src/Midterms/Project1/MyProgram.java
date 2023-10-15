package Midterms.Project1;

import java.util.Scanner;

public class MyProgram {
    static Scanner scan = new Scanner(System.in);


    /**
     * Create a method displayMenu() that has 3 menu.
     * 1. Convert Infix to Postfix Expression
     * 2. Evaluate Postfix Expression
     * 3. Exit Program
     *
     * Use do while loop to display the menu in the main method.
     *  After each chosen option, handle each chosen option through switch-case logic in the main method.
     *
     * - pag pinili yung exit option, show thankyou message siguro
     */
    public static void main(String[] args) {
        MyProgram runProgram = new MyProgram();
        runProgram.run();
    }   // end of main method

    public void run() {
        int choice;
        do {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("This program allows the user to convert infix expressions ");
            System.out.println("to postfix expressions and evaluates them.");
            System.out.println("Press enter to continue...");
            System.out.println("-------------------------------------------------------------------------------------");
            scan.nextLine();
            showMenu();

            choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter infix expression: ");
                    String infixExpression = scan.nextLine();
                    InfixConverter infix = new InfixConverter (infixExpression);
                    try {
                        System.out.println(infix.convertToPostfix());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                case 2:

                case 3:
                    System.out.println("Thank you for using the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again. \n");
            }
        } while (choice < 4);
    }   //end of run method

    public void showMenu() {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("What would you like to perform? Press the number of your choice.");
        System.out.println("[1] Convert Infix to Postfix ");
        System.out.println("[2] Evaluate Postfix Expression ");
        System.out.println("[3] Exit");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.print("CHOICE : ");
    }   // end of showMenu method
    public void convertInfix() throws Exception{
        System.out.println("Enter infix expression: ");
        String infix = String.valueOf(scan.hasNext());
        InfixConverter infixExpression = new InfixConverter(infix);
        infixExpression.convertToPostfix();
    }
    public void evaluatePostfix() {}
}