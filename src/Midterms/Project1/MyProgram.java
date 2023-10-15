/**
 Group B
 Class Code and Course Number: 9342 - CS 211
 Schedule: TF 9:00 - 10:30 AM
 <p>
 COLOMA, Stephen M.- 2232847@slu.edu.ph
 GUZMAN, Sanchie Earl M.- 2232886@slu.edu.ph
 NONATO, Marius Glenn M.- 2232731@slu.edu.ph
 RAGUDOS, Hannah T.- 2233361@slu.edu.ph
 RAMOS, Jerwin Kyle R.- 2232862@slu.edu.ph
 ROQUE, Rey Daniel L. - 2233357@slu.edu.ph
 SANTOS, Lourdene Eira C.- 2233120@slu.edu.ph
 </p>
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

package Midterms.Project1;

import java.util.Scanner;

public class MyProgram {
    static Scanner kbd = new Scanner(System.in);
    public static void main(String[] args) {
        MyProgram runProgram = new MyProgram();
        runProgram.run();
    }   // end of main method

    /**This method is called when running the program.*/
    public void run() {
        System.out.println("========================================================");
        System.out.println("\t\t\t\tWelcome to our Program!");
        System.out.println("Our program allows user to convert infix expression");
        System.out.println("to postfix expression and evaluate postfix expressions.");
        System.out.println("========================================================");
        System.out.print("Please press ENTER to continue...");
        kbd.nextLine();
        int choice;

        do {
            showMenu();
            choice = Integer.parseInt(kbd.nextLine());
            char repeat;
            switch (choice) {
                case 1: //converting infix to postfix
                    repeat = 'y';
                    while (repeat=='y'){
                        System.out.print("Enter infix expression: ");
                        String infix = kbd.nextLine();
                        InfixConverter infixExpression = new InfixConverter(infix);
                        try {
                            System.out.println(infixExpression.convertToPostfix());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.print("\nEnter another postfix (y/n)? ");
                        repeat = kbd.nextLine().toLowerCase().charAt(0);
                    }
                    break;
                case 2: //evaluating postfix
                    repeat = 'y';
                    while (repeat=='y'){
                        System.out.print("Enter postfix expression (spaced with characters): ");
                        String postfix = kbd.nextLine();
                        try {
                            PostfixEvaluator postfixExpression = new PostfixEvaluator(postfix);
                            int result = postfixExpression.evaluate();
                            System.out.println("Result: " + result);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.print("\nEnter another postfix (y/n)? ");
                        repeat = kbd.nextLine().toLowerCase().toLowerCase().charAt(0);
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the program.");
                    kbd.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again. \n");
            }
        } while (choice < 4);
        kbd.close();
    }   //end of run method

    /**This method shows the three menu options.*/
    public void showMenu() {
        System.out.println("\nWhat would you like to perform?");
        System.out.println("[1] Convert Infix to Postfix ");
        System.out.println("[2] Evaluate Postfix Expression ");
        System.out.println("[3] Exit");
        System.out.println("------------------------------------");
        System.out.print("CHOICE : ");
    }   // end of showMenu method
}
