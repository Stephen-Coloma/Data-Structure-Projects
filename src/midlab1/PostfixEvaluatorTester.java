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
package midlab1;

import midlab1.stack.StackUnderflowException;
import java.util.Scanner;

/**
 * The PostfixEvaluatorTester class is an executable class
 * for evaluating postfix expressions using the PostfixEvaluator class.
 */
public class PostfixEvaluatorTester {
    /**
     * The main method of the program.
     * @param args the command-line arguments.
     */
    public static void main(String[] args) {
        PostfixEvaluator postfixEvaluator;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a postfix expression (operands and operators separated by space): ");
        String postfixExpression = scanner.nextLine();

        try {
            postfixEvaluator = new PostfixEvaluator(postfixExpression);
            int result = postfixEvaluator.evaluate(postfixExpression);
            System.out.print("Result: " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (StackUnderflowException e) {
            System.out.println("Stack Underflow Error: " + e.getMessage());
        }
        catch (Exception e1) {
            e1.printStackTrace();
        }
    }
} // end of PostfixEvaluatorTester class