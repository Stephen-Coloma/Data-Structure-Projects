package midlab1;

import midlab1.stack.MyStack;

//TODO: Create javadoc comments
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
     */
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

                //checks for consecutive operands such as AB
                if (isOperand(symbol)) {
                    if (isOperand(lastChar)) {
                        return "Cannot be converted to postfix: No two consecutive operands.";
                    }
                    postfixExpression += symbol;
                } else {
                    //checks for consecutive operators. But '(' and ')' are allowed
                    if (isOperator(symbol)) {
                        if (isOperator(lastChar) && symbol != '(' && symbol != ')') {
                            return "Cannot be converted to postfix: No two consecutive operators.";
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

    /**
     * Method that checks if the precedence of operator1 is higher than operator2
     * @param operator1 The first operator
     * @param operator2 The second operator
     * @return true if operator1 has higher precedence, and false if it is not
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
     * Method that checks if a character is an operand or not
     * @param symbol The character to be checked
     * @return true if the character is an operand, and false if it is not
     */
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
        InfixConverter hi = new InfixConverter("(A+B/C*(D+E)-F)");
        System.out.println(hi.convertToPostfix());
    }
}
