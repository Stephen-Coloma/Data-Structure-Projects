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
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * The InfixConverter class represents is used to convert infix expressions to postfix expressions.
 */
public class InfixConverter {
    private String infix;

    /**
     * Method that constructs an InfixConverter using the given infix expression
     * @param infix infix expression to be converted to postfix expression
     */
    public InfixConverter(String infix) {
        this.infix = infix;
    }

    /**
     * Method that gets the current infix expression
     * @return the infix expression
     */
    public String getInfix() {
        return infix;
    }

    /**
     * Method that sets the infix expression to a certain value
     * @param infix new infix expression
     */
    public void setInfix(String infix) {
        this.infix = infix;
    }

    /**
     * Method that converts the infix expression into a postfix expression
     * @return the converted infix, which is the postfix expression
     * @throws Exception when there are error characters in input infix
     */
    public String convertToPostfix() throws Exception {
        infix = infix.replaceAll(" ", "").toUpperCase();
        int index = 0;

        String postfixExpression = "";
        MyStack<Character> operatorStack = new MyStack<>();
        char lastChar = ' '; // Initialize to a space to ensure no two consecutive operators at the beginning.

        // Check if the first and last char is an operator
        if (isOperator(infix.charAt(0)) || isOperator(infix.charAt(infix.length() - 1))) {
            throw new IllegalArgumentException("Cannot be converted to postfix: No operator in first or last character.");
        }

        LinkedList<String> symbolList = new LinkedList<>();
        LinkedList<String> postfixExpressionList = new LinkedList<>();
        LinkedList<String> operatorStackList = new LinkedList<>();

        if (isOperator(infix.charAt(0)) || isOperator(infix.charAt(infix.length()-1))){
            throw new IllegalArgumentException("Cannot be converted to postfix: No operator in first or last character.");
        }

        while (index != infix.length()) {
            char symbol = infix.charAt(index);
            String symbolStr = String.valueOf(symbol);
            //checks for consecutive operands such as AB
            if (isOperand(symbol)) {
                if (isOperand(lastChar)) {
                    throw new IllegalArgumentException("Cannot be converted to postfix: No two consecutive operands.");
                }
                postfixExpression += symbol;
            } else {
                //checks for consecutive operators. But '(' and ')' are allowed
                if (isOperator(symbol)) {
                    if (isOperator(lastChar) && symbol != '(' && symbol != ')') {
                        throw new IllegalArgumentException("Cannot be converted to postfix: No two consecutive operators.");
                    }
                }

                while (!operatorStack.isEmpty() && precedence(operatorStack.peek(), symbol)) {
                    char topSymbol = operatorStack.pop();
                    postfixExpression += topSymbol;
                }

                if (operatorStack.isEmpty() || symbol != ')') {
                    operatorStack.push(symbol);
                } else {
                    char topSymbol = operatorStack.pop();
                }
            }

            symbolList.add(symbolStr);
            postfixExpressionList.add(postfixExpression);
            operatorStackList.add(operatorStack.toString().replace(",", ""));

            lastChar = symbol;
            index++;
        }

        while (!operatorStack.isEmpty()) {
            char topSymbol = operatorStack.pop();

            if (topSymbol == '(') {
                throw new IllegalArgumentException("Cannot be converted to postfix: extra \"(\".");
            } else if (topSymbol == ')') {
                throw new IllegalArgumentException("Cannot be converted to postfix: extra \")\".");
            }
            postfixExpression += topSymbol;
        }

        //displaying the table
        displayTable(symbolList,postfixExpressionList,operatorStackList);

        //spacing out the postfix expression
        String spacedExpression = postfixExpression
                .chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        return "Equivalent Postfix Expression: " + spacedExpression;
    }

    /**
     * Method that displays a table of information for a given symbol, postfix expression, and operator stack.
     * @param symbolList linked list that contains the symbols.
     * @param postfixExpressionList linked list that contains the postfix string expression.
     * @param operatorStackList linked list that contains the operator stack.
     */
    private void displayTable(LinkedList<String> symbolList, LinkedList<String> postfixExpressionList, LinkedList<String> operatorStackList) {
        System.out.println("+---------------+------------------------+---------------+");
        System.out.printf("%-16s%-25s%-16s%n", "| Symbol ", "| postfixExpression ", "| operatorStack |");
        System.out.println("+---------------+------------------------+---------------+");

        for (int i = 0; i < symbolList.size(); i++) {
            String symbol = symbolList.get(i);
            String postfixExpression = postfixExpressionList.get(i);
            String operatorStack = operatorStackList.get(i);

            StringBuilder reversedOperatorStack = new StringBuilder(operatorStack);
            reversedOperatorStack.reverse();

            operatorStack = reversedOperatorStack.toString().replace("[", "").replace("]", "");

            System.out.printf("%-2s%-13s%-2s%-22s%-2s%-13s%s%n", "|  ", symbol, "|  ", postfixExpression, "|  ", operatorStack ,"|");
        }
        System.out.println("+---------------+------------------------+---------------+");
    }

    /**
     * Method that checks if the precedence of operator1 is higher than operator2
     * @param operator1 The first operator
     * @param operator2 The second operator
     * @return true if operator1 has higher precedence or if they have the same level, and false if it is not.
     */
    private static boolean precedence(char operator1, char operator2){
        //if operator 1 is ^ it has a higher precedence than any of the operator (*/+-)
        if ((operator1 == '^') && (operator2 == '*' || operator2 == '/' || operator2 == '+' || operator2 == '-'))
            return true; // returns true if operator 1 has a higher precedence
        //if operator 1 is * or / it has a higher precedence than operator 2 of + and -
        else if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-'))
            return true;
        else if ((operator1 == '*' || operator1 == '/') && (operator2 == '*' || operator2 == '/'))
            return true;
        else if ((operator1 == '+' || operator1 == '-') && (operator2 == '+' || operator2 == '-'))
            return true;
        else if (operator2 == ')'){
            if (operator1 == '('){
                return false;
            }
            return true;
        }else
            return false;
    }

    /**
     * Private method that checks if a character is an operand or not
     * @param symbol The character to be checked
     * @return true if the character is an operand, and false if it is not
     * @throws Exception when the symbol is invalid operand
     */
    private boolean isOperand(char symbol) throws Exception{
        char[] operators = {'^', '(', ')', '*', '/', '+', '-'};
        for (char operator:operators) {
            if (operator==symbol){
                return false;
            }
        }

        if ((symbol >= 'A' && symbol <= 'Z') || symbol==' '){
            return true;
        }else {
            throw new Exception("Cannot be converted to postfix: invalid character: " + String.valueOf(symbol));
        }
    }

    /**
     * Checks if the given character is an operator.
     * @param symbol The character to be checked.
     * @return true if the character is one of the following operators: '^', '*', '/', '+', or '-',
     *         false otherwise.
     */
    private boolean isOperator(char symbol) {
        return symbol == '^' || symbol == '*' || symbol == '/' || symbol == '+' || symbol == '-';
    }

    /**
     * Returns the string representation of the object.
     * @return The infix expression represented as a string.
     */
    @Override
    public String toString() {
        return infix;
    }
}
