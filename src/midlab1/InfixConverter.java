/**
 TODO: Create an algorithm for the whole class
 */

package midlab1;

//TODO: Create javadoc comments
public class InfixConverter {
    private String infix;
    private String postfix;

    public InfixConverter(String infix) {
        this.infix = infix;
    }

    public String getInfix() {
        return infix;
    }

    public void setInfix(String infix) {
        this.infix = infix;
    }

    public void convertToPostfix(){
        //TODO: create implementation of the conversion of the infix. Copy the code of sir Dalos
        //TODO: Make sure that invalid input (errors) can be handled.
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
            return true;
        }else
            return false;
    }

    @Override
    public String toString() {
        return "InfixConverter{" +
                "infix='" + infix + '\'' +
                ", postfix='" + postfix + '\'' +
                '}';
    }
}
