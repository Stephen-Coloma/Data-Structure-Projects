/**
 *  Group B
 *  Class Code and Course Number: 9342 - CS 211
 *  Schedule: TF 9:00 - 10:30 AM
 *  <p>
 *      COLOMA, Stephen M.- 2232847@slu.edu.ph
 *      GUZMAN, Sanchie Earl M.- 2232886@slu.edu.ph
 *      NONATO, Marius Glenn M.- 2232731@slu.edu.ph
 *      RAGUDOS, Hannah T.- 2233361@slu.edu.ph
 *      RAMOS, Jerwin Kyle R.- 2232862@slu.edu.ph
 *      ROQUE, Rey Daniel L. - 2233357@slu.edu.ph
 *      SANTOS, Lourdene Eira C.- 2233120@slu.edu.ph
 *  </p>
 *
 * The program follows the following algorithm and workflow:
 *
 * 1. Welcome Message:
 *    - Display a welcome message introducing the user to the functionalities of the program.
 *
 * 2. Main Execution Loop (run method):
 *    - Prompt the user to press ENTER to continue.
 *    - Display a menu of options for the user to choose from:
 *        1. Convert Infix to Postfix
 *        2. Evaluate Postfix Expression
 *        3. Exit
 *    - Based on the user's choice, perform the corresponding action:
 *        - If the choice is 1 or 2, display valid operators and perform the selected action
 *        - If the choice is 3, display a thank you message and exit the program.
 *        - For any other choice, inform the user that it is an invalid choice and prompt again.
 *    - Repeat the menu prompt until the user chooses to exit (option 3).
 *
 * 3. Infix to Postfix Conversion (processInfixExpression method):
 *    - Prompt the user to enter an infix expression.
 *    - Convert the infix expression to postfix notation using the InfixConverter class.
 *    - Display the postfix expression.
 *
 * 4. Postfix Expression Evaluation (evaluatePostfixExpression method):
 *    - Prompt the user to enter a postfix expression.
 *    - Evaluate the postfix expression using the PostfixEvaluator class.
 *    - Display the evaluation result.
 *
 * 5. Repetition Prompt (askUserToRepeat method):
 *    - After performing an action (converting or evaluating), ask the user if they want to perform another operation.
 *    - Ensure the user input is valid ('y' or 'n') and return the response.
 *
 * 6. Exit:
 *    - Close the Scanner and gracefully exit the program.
 */

/* SAMPLE RUN:
========================================================
				Welcome to our Program!
Our program allows user to convert infix expression
to postfix expression and evaluate postfix expressions.
========================================================
Please press ENTER to continue...

What would you like to perform?
[1] Convert Infix to Postfix
[2] Evaluate Postfix Expression
[3] Exit
------------------------------------
CHOICE : 1
Enter infix expression: ((A-(B+C))*D)^(E+F)
+---------------+------------------------+---------------+
| Symbol        | postfixExpression      | operatorStack |
+---------------+------------------------+---------------+
|  (            |                        |  (            |
|  (            |                        |  ((           |
|  A            |  A                     |  ((           |
|  -            |  A                     |  ((-          |
|  (            |  A                     |  ((-(         |
|  B            |  AB                    |  ((-(         |
|  +            |  AB                    |  ((-(+        |
|  C            |  ABC                   |  ((-(+        |
|  )            |  ABC+                  |  ((-          |
|  )            |  ABC+-                 |  (            |
|  *            |  ABC+-                 |  (*           |
|  D            |  ABC+-D                |  (*           |
|  )            |  ABC+-D*               |               |
|  ^            |  ABC+-D*               |  ^            |
|  (            |  ABC+-D*               |  ^(           |
|  E            |  ABC+-D*E              |  ^(           |
|  +            |  ABC+-D*E              |  ^(+          |
|  F            |  ABC+-D*EF             |  ^(+          |
|  )            |  ABC+-D*EF+            |  ^            |
+---------------+------------------------+---------------+
Equivalent Postfix Expression: A B C + - D * E F + ^

Enter another postfix (y/n)? n

What would you like to perform?
[1] Convert Infix to Postfix
[2] Evaluate Postfix Expression
[3] Exit
------------------------------------
CHOICE : 2
Enter postfix expression (spaced with characters): 6 2 3 + - 3 8 2 / + * 2 ^ 3 +
Postfix String -> 6 2 3 + - 3 8 2 / + * 2 ^ 3 +
+--------+----------+----------+-------+-----------------+
| Symbol | Operand1 | Operand2 | Value | OperandStack    |
+--------+----------+----------+-------+-----------------+
| 6      |          |          |       | [6]             |
| 2      |          |          |       | [2,6]           |
| 3      |          |          |       | [3,2,6]         |
| +      | 2        | 3        | 5     | [5,6]           |
| -      | 6        | 5        | 1     | [1]             |
| 3      |          |          |       | [3,1]           |
| 8      |          |          |       | [8,3,1]         |
| 2      |          |          |       | [2,8,3,1]       |
| /      | 8        | 2        | 4     | [4,3,1]         |
| +      | 3        | 4        | 7     | [7,1]           |
| *      | 1        | 7        | 7     | [7]             |
| 2      |          |          |       | [2,7]           |
| ^      | 7        | 2        | 49    | [49]            |
| 3      |          |          |       | [3,49]          |
| +      | 49       | 3        | 52    | [52]            |
+--------+----------+----------+-------+-----------------+
Result: 52

Enter another postfix (y/n)? n

What would you like to perform?
[1] Convert Infix to Postfix
[2] Evaluate Postfix Expression
[3] Exit
------------------------------------
CHOICE : 3
Thank you for using the program.

Process finished with exit code 0*/

package Midterms.midlab1;

import java.util.Scanner;

/**
 * MyProgram Class facilitates the conversion of infix expressions to postfix
 * and evaluates postfix expressions through a user-friendly console interface.
 */
public class MyProgram {

    static Scanner kbd = new Scanner(System.in);

    public static void main(String[] args) {
        MyProgram runProgram = new MyProgram();
        runProgram.run();
    } // end of main method

    /**
     * Main execution loop of the program.
     * Manages user input and program flow through various functionalities until the user decides to exit.
     */
    public void run() {
        printWelcomeMessage();
        promptEnterKey();

        int choice;
        do {
            choice = getUserChoice();
            handleUserChoice(choice);
        } while (choice != 3);

        kbd.close();
    }

    /**
     * Outputs a welcome message to introduce the program to the user.
     */
    private void printWelcomeMessage() {
        System.out.println("========================================================");
        System.out.println("\t\t\t\tWelcome to our Program!");
        System.out.println("Our program allows user to convert infix expression");
        System.out.println("to postfix expression and evaluate postfix expressions.");
        System.out.println("========================================================");
    }

    /**
     * Waits for the user to press ENTER to proceed.
     */
    private void promptEnterKey() {
        System.out.print("Please press ENTER to continue...");
        kbd.nextLine();
    }

    /**
     * Displays a menu to the user and returns their selection.
     *
     * @return integer representing user's choice.
     */
    private int getUserChoice() {
        showMenu();
        try {
            return Integer.parseInt(kbd.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return 0;
        }
    }

    /**
     * Handles the user's menu choice by activating the respective functionality.
     *
     * @param choice integer representing user's choice.
     */
    private void handleUserChoice(int choice) {
        char repeat;
        switch (choice) {
            case 1 -> {
                showValidOperators();
                do {
                    processInfixExpression();
                    repeat = askUserToRepeat();
                } while (repeat == 'y');
            }
            case 2 -> {
                showValidOperators();
                do {
                    evaluatePostfixExpression();
                    repeat = askUserToRepeat();
                } while (repeat == 'y');
            }
            case 3 -> System.out.println("Thank you for using the program.");
            default -> System.out.println("Invalid choice. Please try again. \n");
        }
    }

    /**
     * Outputs the main menu options to the console.
     */
    private void showMenu() {
        System.out.println("\nWhat would you like to perform?");
        System.out.println("[1] Convert Infix to Postfix ");
        System.out.println("[2] Evaluate Postfix Expression ");
        System.out.println("[3] Exit");
        System.out.println("------------------------------------");
        System.out.print("CHOICE : ");
    }

    /**
     * Outputs the valid operators utilized in the program for conversion of infix to postfix expression
     *
     */
    private void showValidOperators(){
        System.out.println("IMPORTANT NOTE: In this program, you can only use the following operators:");
        System.out.println("   +   (Addition)");
        System.out.println("   -   (Subtraction)");
        System.out.println("   *   (Multiplication)");
        System.out.println("   /   (Division)");
        System.out.println("   ^   (Exponentiation)");
        System.out.println("   =   (Equals)");
        System.out.print("\nPlease press ENTER to continue...");
        kbd.nextLine();
    }
    /**
     * Retrieves an infix expression from the user, converts it to postfix, and outputs the result.
     */
    private void processInfixExpression() {
        System.out.print("Enter infix expression: ");
        String infix = kbd.nextLine();
        InfixConverter infixExpression = new InfixConverter(infix);
        try {
            System.out.println(infixExpression.convertToPostfix());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Retrieves a postfix expression from the user, evaluates it, and outputs the result.
     */
    private void evaluatePostfixExpression() {
        System.out.print("Enter postfix expression (spaced with characters): ");
        String postfix = kbd.nextLine();
        try {
            PostfixEvaluator postfixExpression = new PostfixEvaluator(postfix);
            String result = postfixExpression.evaluate();
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Asks if the user wants to perform another operation, ensuring that the input is either 'y' or 'n'.
     *
     * @return the first character of the user's input.
     */
    private char askUserToRepeat() {
        char repeat;
        while (true) {
            System.out.print("\nEnter another expression (y/n)? ");
            repeat = kbd.nextLine().toLowerCase().charAt(0);
            if (repeat == 'y' || repeat == 'n') {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
        return repeat;
    }
} // end of MyProgramClass
