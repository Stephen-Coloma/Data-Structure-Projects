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
        //TODO: create an implementation of the precedence method
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
