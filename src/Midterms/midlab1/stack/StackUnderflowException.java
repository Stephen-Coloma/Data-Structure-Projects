/**
 * Group MixAndMatch
 * Class Code and Course Number: 9342 - CS 211
 * Schedule: TF 9:00 - 10:30 AM
 *
 * <p>
 *      COLOMA, Stephen M.- 2232847@slu.edu.ph
 *      GUZMAN, Sanchie Earl M.- 2232886@slu.edu.ph
 *      NONATO, Marius Glenn M.- 2232731@slu.edu.ph
 *      RAGUDOS, Hannah T.- 2233361@slu.edu.ph
 *      RAMOS, Jerwin Kyle R.- 2232862@slu.edu.ph
 *      ROQUE, Rey Daniel L. - 2233357@slu.edu.ph
 *      SANTOS, Lourdene Eira C.- 2233120@slu.edu.ph
 * </p>
 */

package Midterms.midlab1.stack;

/**
 * The StackUnderflowException class represents a customized exception that is thrown
 * when an operation is attempted that requires reading or popping an element from an
 * empty stack, which is not permissible because it violates the stack abstract data type.
 */
public class StackUnderflowException extends Exception{

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message   the detail message. The detail message is saved for
     *                  later retrieval by the getMessage() method.
     */
    public StackUnderflowException(String message){
        super(message);
    }
} // end of StackUnderflowException class
