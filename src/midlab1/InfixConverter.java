/**
 TODO: Create an algorithm for the whole class
 */

package midlab1;

import midlab1.stack.MyStack;

import javax.crypto.spec.PSource;

//TODO: Create javadoc comments
public class InfixConverter {
    private String infix;

    public InfixConverter(String infix) {
        this.infix = infix;
    }

    public String getInfix() {
        return infix;
    }

    public void setInfix(String infix) {
        this.infix = infix;
    }

    public String convertToPostfix(){
        infix = infix.replaceAll(" ", "");
        int index = 0;

        String postfixExpression = "";
        MyStack<Character> operatorStack = new MyStack<>();
        char lastChar = ' '; // Initialize to a space to ensure no two consecutive operators at the beginning.

        //check if the first and last char is an operator
        if (isOperator(infix.charAt(0)) || isOperator(infix.charAt(infix.length()-1))){
            return "Cannot be converted to postfix: No operator in first or last character.";
        }

        try {
            while (index != infix.length()) {
                char symbol = infix.charAt(index);

                //checks for consecutive operators. But '(' and ')' are allowed
                if (isOperator(symbol)) {
                    if (isOperator(lastChar) && symbol != '(' && symbol != ')') {
                        return "Cannot be converted to postfix: No two consecutive operators.";
                    }
                }

                if (isOperand(symbol)) {
                    postfixExpression += symbol;
                } else {
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
             while (!operatorStack.isEmpty()) {
                 char topSymbol = operatorStack.pop();

                 if (topSymbol=='('){
                     return "Cannot be converted to postfix: extra \"(\".";
                 }else if (topSymbol==')'){
                     return "Cannot be converted to postfix: extra \")\".";
                 }
                 postfixExpression+=topSymbol;
             }
         }catch (Exception e){
             e.printStackTrace();
         }
         return postfixExpression;
    }

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

    private boolean isOperand(char symbol){
        char[] operators = {'^', '(', ')', '*', '/', '+', '-'};
        for (char operator:operators) {
            if (operator==symbol){
                return false;
            }
        }
        return true;
    }

    private boolean isOperator(char symbol) {
        return symbol == '^' || symbol == '*' || symbol == '/' || symbol == '+' || symbol == '-';
    }

    @Override
    public String toString() {
        return infix;
    }

    public static void main(String[] args) {
        InfixConverter hi = new InfixConverter("+(A+B/C*(D+E)-F)");
        System.out.println(hi.convertToPostfix());
    }
}
