/**
 * Algorithm for Evaluating a Postfix Expression
 *
 * 1. Create an empty stack for storing operands.
 * 2. For each character in the postfix expression string:
 *    - If it's a digit, push it onto the stack.
 *    - If it's an operator (+, -, *, /, ^):
 * 3. Pop the top two operands from the stack.
 * 4. Apply the operator and push the result back onto the stack.
 * 5. The final result should be the only element left on the stack.
 * 6. Pop and return it as the evaluated result.

*/
package midlab1;

import midlab1.stack.MyStack;
import midlab1.stack.StackUnderflowException;

public class PostfixEvaluator {
    private String expression;

    /**
     * Constructor to initialize the expression to be evaluated.
     * @param expression: A string that represents the postfix expression.
     */
    public PostfixEvaluator(String expression) {
        // TODO: Validate the expression
        this.expression = expression;
    }

    /**
     * Evaluates the postfix expression and returns the result.
     * @return int: The result of the evaluated postfix expression.
     */
    //Algorithm
    // 1. Iterate through each character in the expression.
    // 2. If the character is a digit, push it onto the operandStack.
    // 3. If the character is an operator (+, -, *, /, ^):
    //    a. Pop the top two elements from the operandStack (ensure the stack is not empty).
    //    b. Apply the operator and push the result back onto the operandStack.
    // 4. The final result should be the only element left on the operandStack. Pop and return it.

    public int evaluate(String postfixExpression) throws StackUnderflowException {
        // Initialize a stack to hold operands during evaluation
        MyStack<Integer> operandStack = new MyStack<>();

        String[] tokens = postfixExpression.split(" ");
        int operandStackIndex = 0;
        int value=0;
        System.out.println("Postfix String -> " + postfixExpression);
        System.out.println("Symbol\tOperand1\tOperand2\tValue\tOperandStack");

        for (String token : tokens) {
            char symbol = token.charAt(0);
            if (Character.isDigit(symbol)) {            // If it's an operand, push it onto the stack
                int operand = Integer.parseInt(token);
                operandStack.push(operand);
                operandStackIndex++;

                System.out.printf("%s\t\t\t\t\t%30s%n", symbol, operandStack);          // Print the table row with the updated operand stack
            }
            else if (isOperator(symbol)) {       // It's an operator
                if (operandStackIndex < 2) {
                    throw new IllegalArgumentException("Invalid expression");
                }
                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                value = performOperation(symbol, operand1, operand2);
                operandStack.push(value);
                operandStackIndex--;

                System.out.printf("%s\t%10d\t%10d\t%10d\t%10s%n", symbol, operand1, operand2, value, operandStack);     // Print the table row with the updated operand stack
            } else {
                throw new IllegalArgumentException("Invalid symbol: " + symbol);
            }
        }//end of for

        if (operandStackIndex != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return operandStack.pop();
    }

    /**
     * Checks if the symbol of the string expression is an operator
     * @param symbol : symbol from the string expression
     * @return boolean: The result of determining whether the symbol is an operator or not.
     */
    private boolean isOperator(char symbol) {
        return symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/' || symbol == '^';
    }

    /**
     * Performs the operation and returns the result.
     * @param operator: The operator to apply (one of +, -, *, /, ^).
     * @param op1: The first operand.
     * @param op2: The second operand.
     * @return int: The result of applying the operator to op1 and op2.
     */
    private int performOperation(char operator, int op1, int op2) {
        System.out.println("test");
        // 1. Use a switch statement or if-else to determine which operator was passed.
        // 2. Perform the corresponding operation on op1 and op2.
        // 3. Return the result.

        return -1;
    }
}
