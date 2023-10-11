package midlab1;

import midlab1.stack.StackUnderflowException;

import java.util.Scanner;

public class PostfixEvaluatorTester {
    public static void main(String[] args) {
        PostfixEvaluator postfixEvaluator;
        Scanner scanner = new Scanner(System.in);

        //System.out.print("Enter a postfix expression (operands and operators separated by space): ");
        String postfixExpression = "6 5 * 7 + 8 *";

        try {
            postfixEvaluator = new PostfixEvaluator(postfixExpression);
            int result = postfixEvaluator.evaluate(postfixExpression);
            System.out.print("Result: " +result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch(Exception e1){
            e1.printStackTrace();
        }
    }
}
