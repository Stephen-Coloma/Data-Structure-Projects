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
     * @throws IllegalArgumentException when there are error characters in input infix
     */
    public String convertToPostfix() throws Exception{
        infix = infix.replaceAll(" ", "").toUpperCase();
        int index = 0;

        String postfixExpression = "";
        MyStack<Character> operatorStack = new MyStack<>();
        char lastChar = ' '; // Initialize to a space to ensure no two consecutive operators at the beginning.

        //check if the first and last char is an operator
        if (isOperator(infix.charAt(0)) || isOperator(infix.charAt(infix.length()-1))){
            throw new IllegalArgumentException("Cannot be converted to postfix: No operator in first or last character.");
        }

        while (index != infix.length()) {
            char symbol = infix.charAt(index);

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
            lastChar = symbol; // Update the last character seen.
            index++;
        }

        //concatenating remaining operator in the operatorStack
        while (!operatorStack.isEmpty()) {
            char topSymbol = operatorStack.pop();

            if (topSymbol=='('){
                throw new IllegalArgumentException("Cannot be converted to postfix: extra \"(\".");
            }else if (topSymbol==')'){
                throw new IllegalArgumentException("Cannot be converted to postfix: extra \")\".");
            }
            postfixExpression+=topSymbol;
        }
         return postfixExpression;
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

    public static void main(String[] args) {
        InfixConverter hi = new InfixConverter("((A-(B+C))*D)^(E+F)");
        try {
            System.out.println(hi.convertToPostfix());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
