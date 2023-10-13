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
    Please enter a postfix expression. Use spaces to separate operands and operators.
    Enter postfix expression: 6 2 3 + - 3 8 2 / + * 2 $ 3 +
    Postfix String -> 6 2 3 + - 3 8 2 / + * 2 $ 3 +
    Symbol	Operand1	Operand2	Value	OperandStack
    6					                           [6]
    2					                         [2,6]
    3					                       [3,2,6]
    +	         2	         3	         5	     [5,6]
    -	         6	         5	         1	       [1]
    3					                         [3,1]
    8					                       [8,3,1]
    2					                     [2,8,3,1]
    /	         8	         2	         4	   [4,3,1]
    +	         3	         4	         7	     [7,1]
    *	         1	         7	         7	       [7]
    2					                         [2,7]
    $	         7	         2	        49	      [49]
    3					                        [3,49]
    +	        49	         3	        52	      [52]
    Result: 52
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
        PostfixEvaluatorTester myProgram;
        try {
            myProgram = new PostfixEvaluatorTester();
            myProgram.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * The run method runs the functionality of the program, which allows the user to input a
     * postfix expression, evaluates it, and displays the result or error messages as appropriate.
     */
    public void run() {
        PostfixEvaluator postfixEvaluator;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a postfix expression. Use spaces to separate operands and operators.");
        System.out.print("Enter postfix expression: ");
        String postfixExpression = scanner.nextLine();

        try {
            postfixEvaluator = new PostfixEvaluator(postfixExpression);
            int result = postfixEvaluator.evaluate(postfixExpression);
            System.out.print("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: " + e.getMessage());
        } catch (StackUnderflowException e) {
            System.out.println("Stack Underflow Error: " + e.getMessage());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
} // end of PostfixEvaluatorTester class