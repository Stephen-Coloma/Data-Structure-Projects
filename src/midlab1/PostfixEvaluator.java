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

public class PostfixEvaluator {
    private String expression;

    /**
     * Constructor to initialize the expression to be evaluated.
     * @param expression: A string that represents the postfix expression.
     */
    public PostfixEvaluator(String expression) {
        // TODO: Validate the expression (optional but recommended)
        this.expression = expression;
    }

    /**
     * Evaluates the postfix expression and returns the result.
     * @return int: The result of the evaluated postfix expression.
     */
    public int evaluate(String expression) {
        // Initialize a stack to hold operands during evaluation
        MyStack<Integer> operandStack = new MyStack<>();

        // TODO: Implement the evaluation algorithm
        // 1. Iterate through each character in the expression.
        // 2. If the character is a digit, push it onto the operandStack.
        // 3. If the character is an operator (+, -, *, /, ^):
        //    a. Pop the top two elements from the operandStack (ensure the stack is not empty).
        //    b. Apply the operator and push the result back onto the operandStack.
        // 4. The final result should be the only element left on the operandStack. Pop and return it.

        for(int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            if(Character.isDigit(symbol)) {
                // TODO: Push the digit onto the operandStack
            } else {
                // TODO: Implement operator handling and perform the operation
                // Hint: Use the performOperation() method to get the result of the operation
                // and push the result back onto the operandStack.
            }
        }

        // TODO: Return the final result from the operandStack.
        // Ensure that the stack is not empty before popping the final result.
        return -1;
    }

    /**
     * Performs the operation and returns the result.
     * @param operator: The operator to apply (one of +, -, *, /, ^).
     * @param op1: The first operand.
     * @param op2: The second operand.
     * @return int: The result of applying the operator to op1 and op2.
     */
    private int performOperation(char operator, int op1, int op2) {
        // TODO: Implement the operation logic
        // 1. Use a switch statement or if-else to determine which operator was passed.
        // 2. Perform the corresponding operation on op1 and op2.
        // 3. Return the result.

        return -1;
    }
}
