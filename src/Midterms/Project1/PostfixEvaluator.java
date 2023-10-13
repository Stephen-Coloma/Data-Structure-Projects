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
package Midterms.Project1;

import Midterms.Project1.stack.MyStack;
import Midterms.Project1.stack.StackUnderflowException;

/**
 * The PostfixEvaluator class represents a postfix expression evaluator that
 * can evaluate mathematical expressions provided in postfix notation.
 */
public class PostfixEvaluator {
    /**
     * The postfix expression to be evaluated.
     */
    private String expression;

    /**
     * Constructor to initialize the expression to be evaluated.
     * @param expression a string that represents the postfix expression.
     */
    public PostfixEvaluator(String expression) {
        if (isValidPostfixExpression(expression)) {
            this.expression = expression;
        } else {
            throw new IllegalArgumentException("Invalid postfix expression");
        }
    }

    /**
     * Evaluates the postfix expression and returns the result.
     * @return int the result of the evaluated postfix expression.
     */
    /*
        Algorithm:
        1. Create an empty stack for storing operands.
        2. For each character in the postfix expression string:
           a. If it's a digit, push it onto the stack.
           b. If it's an operator (+, -, *, /, ^):
              - Pop the top two operands from the stack.
              - Apply the operator and push the result back onto the stack.
        3. The final result should be the only element left on the stack.
        4. Pop and return it as the evaluated result.
    */
    public int evaluate(String postfixExpression) throws StackUnderflowException {
        // Initialize a stack to hold operands during evaluation
        MyStack<Integer> operandStack = new MyStack<>();

        String[] tokens = postfixExpression.split("");
        int operandStackIndex = 0;
        int value = 0;

        System.out.println("Postfix String -> " + postfixExpression);
        System.out.println("Symbol\tOperand1\tOperand2\tValue\tOperandStack");

        for (String token : tokens) {
            char symbol = token.charAt(0);
            if (Character.isDigit(symbol)) { // If it's an operand, push it onto the stack
                int operand = Integer.parseInt(token);
                operandStack.push(operand);
                operandStackIndex++;

                // Print the table row with the updated operand stack
                System.out.printf("%s\t\t\t\t\t%30s%n", symbol, operandStack);
            } else if (isOperator(symbol)) { // It's an operator
                if (operandStackIndex < 2)
                    throw new IllegalArgumentException("Invalid expression");

                int operand2 = operandStack.pop();
                int operand1 = operandStack.pop();
                value = performOperation(symbol, operand1, operand2);
                operandStack.push(value);
                operandStackIndex--;

                // Print the table row with the updated operand stack
                System.out.printf("%s\t%10d\t%10d\t%10d\t%10s%n", symbol, operand1, operand2, value, operandStack);
            } else {
                throw new IllegalArgumentException("Invalid symbol: " + symbol);
            }
        } //end of for

        if (operandStackIndex != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }

        return operandStack.pop();
    }

    /**
     * Checks if a given postfix expression is valid.
     * @param expression the postfix expression to validate.
     * @return true if the expression is valid, false otherwise.
     */
    private boolean isValidPostfixExpression(String expression) {
        char[] tokens = expression.toCharArray(); // Convert the expression to a character array

        int operandCount = 0;
        int operatorCount = 0;

        for (char token : tokens) {
            if (Character.isWhitespace(token)) {
                continue;
            }
            if (isOperand(String.valueOf(token))) {
                operandCount++;
            } else if (isOperator(token)) {
                operatorCount++;
            } else {
                // Invalid character found
                return false;
            }
        }
        // For a valid postfix expression, the number of operands should be one more than the number of operators
        return operandCount == operatorCount + 1;
    }

    /**
     * Check if a token is a valid operand (integer in this case).
     * @param token the token to check.
     * @return true if the token is a valid operand, false otherwise.
     */
    private boolean isOperand(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks if the symbol of the string expression is an operator
     * @param symbol symbol from the string expression
     * @return boolean the result of determining whether the symbol is an operator or not.
     */
    private boolean isOperator(char symbol) {
        char[] arr = { '+', '-', '*', '/', '$', '(', ')' };
        for (char i : arr) {
            if (symbol == i)
                return true;
        }
        return false;
    }

    /**
     * Performs the operation and returns the result.
     * @param operator the operator to apply (one of +, -, *, /, $).
     * @param op1 the first operand.
     * @param op2 the second operand.
     * @return int the result of applying the operator to op1 and op2.
     */
    private int performOperation(char operator, int op1, int op2) {
        switch (operator) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                if (op2 == 0)
                    throw new ArithmeticException("Cannot divide by zero");
                return op1 / op2;
            case '$':
                return (int) Math.pow(op1, op2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
