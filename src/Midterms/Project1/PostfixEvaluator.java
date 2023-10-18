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
    private String postfixExpression;

    /**
     * Constructor to initialize the expression to be evaluated.
     * @param expression a string that represents the postfix expression.
     */
    public PostfixEvaluator(String expression) {
        if (isValidPostfixExpression(expression)) {
            this.postfixExpression = expression;
        } else {
            throw new IllegalArgumentException("Cannot be evaluated: Invalid postfix expression");
        }
    }

    /**
     * Evaluates a postfix expression and returns the result.
     * This method also prints a detailed table of the evaluation process,
     * including the current symbol, operands, result of operation, and
     * the state of the operand stack at each step.
     * @return int The result of the evaluated postfix expression.
     * @throws StackUnderflowException if the stack underflows (i.e., an operator is found
     *         without enough operands in the stack).
     */

    public String evaluate() throws StackUnderflowException {
        MyStack<Integer> operandStack = new MyStack<>();
        String[] tokens = postfixExpression.split(" ");
        int operand2 = 0, operand1 = 0, value = 0;
        char symbol = 0;
        System.out.println("Postfix String -> " + postfixExpression);
        System.out.println("+--------+----------+----------+-------+-----------------+");
        System.out.println("| Symbol | Operand1 | Operand2 | Value | OperandStack    |");
        System.out.println("+--------+----------+----------+-------+-----------------+");
        for (String token : tokens) {
            symbol = token.charAt(0);
            // If it's an operand, push it onto the stack and print the state.
            if (Character.isDigit(symbol)) {
                int operand = Integer.parseInt(token);
                operandStack.push(operand);
                System.out.printf("| %-6s |          |          |       | %-15s |\n", symbol, operandStack.toString());
            }
            // If it's an operator, pop the top two operands, perform the operation,
            // push the result back onto the stack, and print the state.
            else if (isOperatorOrAssignment(symbol)) {
                operand2 = operandStack.pop();
                operand1 = operandStack.pop();
                value = performOperation(symbol, operand1, operand2);
                operandStack.push(value);
                System.out.printf("| %-6s | %-8d | %-8d | %-5d | %-15s |\n", symbol, operand1, operand2, value, operandStack.toString());
            }
            // If it's neither an operand nor an operator, throw an exception.
            else {
                throw new IllegalArgumentException("Invalid symbol: " + symbol);
            }
        }
        System.out.println("+--------+----------+----------+-------+-----------------+");

        // If the stack does not contain exactly one operand (the final result),
        // the expression was invalid.
        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }
        if (symbol == '=')
            return operand1 + " = " + operand2;
        else
             // Pop and return the final result from the stack.
            return String.valueOf(operandStack.pop());
    }

    /**
     * Checks if a given postfix expression is valid.
     * @param expression the postfix expression to validate.
     * @return true if the expression is valid, false otherwise.
     */
    private boolean isValidPostfixExpression(String expression) {
        String[] tokens = expression.split("\\s+"); // Split by whitespace
        int operandCount = 0;
        int operatorCount = 0;

        for (String token : tokens) {
            char symbol = token.charAt(0);
            System.out.println("token: "+token);
            if (isOperand(token)) {
                operandCount++;
            } else if (isOperatorOrAssignment(symbol)) {
                System.out.println("symbol: " +symbol);
                operatorCount++;
            } else {
                System.out.println("Invalid token: " + token);
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
    private boolean isOperatorOrAssignment(char symbol) {
        char[] arr = { '+', '-', '*', '/', '^', '(', ')' , '=' };
        for (char i : arr) {
            if (symbol == i)
                return true;
        }
        return false;
    }

    /**
     * Performs the operation and returns the result.
     * @param operator the operator to apply (one of +, -, *, /, ^, =).
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
            case '^':
                return (int) Math.pow(op1, op2);
            case '=':
                return op2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
