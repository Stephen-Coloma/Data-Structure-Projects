/**
 Group MixAndMatch
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

/*
SAMPLE RUN:
Please enter a postfix expression.
Enter postfix expression: 6 2 3 + - 3 8 2 / + * 2 $ 3 +
Postfix String -> 6 2 3 + - 3 8 2 / + * 2 $ 3 +
+--------+----------+----------+-------+-----------------+
| Symbol | Operand1 | Operand2 | Value | OperandStack    |
+--------+----------+----------+-------+-----------------+
| 6      |          |          |       | [6]             |
+--------+----------+----------+-------+-----------------+
| 2      |          |          |       | [2,6]           |
+--------+----------+----------+-------+-----------------+
| 3      |          |          |       | [3,2,6]         |
+--------+----------+----------+-------+-----------------+
| +      | 2        | 3        | 5     | [5,6]           |
+--------+----------+----------+-------+-----------------+
| -      | 6        | 5        | 1     | [1]             |
+--------+----------+----------+-------+-----------------+
| 3      |          |          |       | [3,1]           |
+--------+----------+----------+-------+-----------------+
| 8      |          |          |       | [8,3,1]         |
+--------+----------+----------+-------+-----------------+
| 2      |          |          |       | [2,8,3,1]       |
+--------+----------+----------+-------+-----------------+
| /      | 8        | 2        | 4     | [4,3,1]         |
+--------+----------+----------+-------+-----------------+
| +      | 3        | 4        | 7     | [7,1]           |
+--------+----------+----------+-------+-----------------+
| *      | 1        | 7        | 7     | [7]             |
+--------+----------+----------+-------+-----------------+
| 2      |          |          |       | [2,7]           |
+--------+----------+----------+-------+-----------------+
| $      | 7        | 2        | 49    | [49]            |
+--------+----------+----------+-------+-----------------+
| 3      |          |          |       | [3,49]          |
+--------+----------+----------+-------+-----------------+
| +      | 49       | 3        | 52    | [52]            |
+--------+----------+----------+-------+-----------------+
Result: 52

Do you want to evaluate another expression? (Y/N): Y

Please enter a postfix expression.
Enter postfix expression: 8 4 + 3 2 * +
Postfix String -> 8 4 + 3 2 * +
+--------+----------+----------+-------+-----------------+
| Symbol | Operand1 | Operand2 | Value | OperandStack    |
+--------+----------+----------+-------+-----------------+
| 8      |          |          |       | [8]             |
+--------+----------+----------+-------+-----------------+
| 4      |          |          |       | [4,8]           |
+--------+----------+----------+-------+-----------------+
| +      | 8        | 4        | 12    | [12]            |
+--------+----------+----------+-------+-----------------+
| 3      |          |          |       | [3,12]          |
+--------+----------+----------+-------+-----------------+
| 2      |          |          |       | [2,3,12]        |
+--------+----------+----------+-------+-----------------+
| *      | 3        | 2        | 6     | [6,12]          |
+--------+----------+----------+-------+-----------------+
| +      | 12       | 6        | 18    | [18]            |
+--------+----------+----------+-------+-----------------+
Result: 18

Do you want to evaluate another expression? (Y/N): N

Thank you for using our program!
 */

package Midterms.Project1;

import Midterms.Project1.stack.StackUnderflowException;
import java.util.Scanner;


/**
 * The PostfixEvaluatorTester class interacts with the user,
 * prompting them to input postfix expressions and displays
 * the evaluated result or relevant error messages.
 */
public class PostfixEvaluatorTester {

    private static final String THANK_YOU_MESSAGE = "Thank you for using our program!";
    private static final String ANOTHER_EXPRESSION_PROMPT = "Do you want to evaluate another expression? (Y/N): ";
    private static final String POSTFIX_PROMPT = "Please enter a postfix expression.\nEnter postfix expression: ";

    public static void main(String[] args) {
        try {
            new PostfixEvaluatorTester().run();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("An unexpected error occurred. Please try again.");
        } finally {
            System.out.println(THANK_YOU_MESSAGE);
            System.exit(0);
        }
    }

    /**
     * The run method manages the user interaction, looping until
     * the user decides not to evaluate more expressions.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String ans = "";

        while (!"N".equalsIgnoreCase(ans)) {
            try {
                evaluateExpression(scanner);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("An unexpected error occurred while evaluating the expression.");
            }
            ans = getYesOrNoAnswer(scanner, ANOTHER_EXPRESSION_PROMPT);
            System.out.println();
        }
    }

    /**
     * The evaluateExpression method prompts the user for a postfix expression,
     * utilizes PostfixEvaluator for evaluation, and displays the result or
     * an error message. Additionally, it prints a formatted table as an example.
     *
     * @param scanner a Scanner object for user input.
     */
    private void evaluateExpression(Scanner scanner) {
        System.out.print(POSTFIX_PROMPT);
        String postfixExpression = scanner.nextLine();

        try {
            // Evaluate the expression
            PostfixEvaluator postfixEvaluator = new PostfixEvaluator(postfixExpression);
            int result = postfixEvaluator.evaluate(postfixExpression);
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal Argument: " + e.getMessage());
        } catch (StackUnderflowException e) {
            System.out.println("Stack Underflow Error: " + e.getMessage());
        }
        System.out.println();
    }

    /**
     * The getYesOrNoAnswer method prompts the user with a specified message
     * and ensures the input is either 'Y' or 'N'.
     *
     * @param scanner the Scanner object for accepting user input.
     * @param message the message to display as the prompt.
     * @return A String, which is either "Y" or "N".
     */
    private String getYesOrNoAnswer(Scanner scanner, String message) {
        String ans;
        while (true) {
            System.out.print(message);
            ans = scanner.nextLine().trim().toUpperCase();
            if ("Y".equals(ans) || "N".equals(ans)) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
        return ans;
    }
} // end of PostfixEvaluatorTester class