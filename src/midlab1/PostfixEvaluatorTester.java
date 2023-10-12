package midlab1;

import midlab1.stack.StackUnderflowException;
import java.util.Scanner;

public class PostfixEvaluatorTester {

    /*
    Algorithm for Evaluating a Postfix Expression:

    1. Create an empty stack for storing operands.
    2. For each character in the postfix expression string:
        - If it's a digit, push it onto the stack.
        - If it's an operator (+, -, *, /, ^):
            a. Pop the top two operands from the stack.
            b. Apply the operator and push the result back onto the stack.
    3. The final result should be the only element left on the stack.
    4. Pop and return it as the evaluated result.
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
}
