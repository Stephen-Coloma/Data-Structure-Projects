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

package Midterms.Project1.stack;

/**
 * MyStackInterface defines the generic stack operations that
 * should be supported by any stack implementation.
 *
 * @param <T> the type of elements in this stack
 */
public interface MyStackInterface<T> {

    /**
     * Adds (pushes) an item onto the top of this stack.
     *
     * @param item the item to be added onto the top of this stack
     */
    public void push(T item);

    /**
     * Removes (pops) the item at the top of this stack and returns it.
     *
     * @return the item at the top of this stack
     * @throws StackUnderflowException if this stack is empty
     */
    public T pop() throws StackUnderflowException;

    /**
     * Retrieves (peeks) the item at the top of this stack without removing it.
     *
     * @return the item at the top of this stack
     * @throws StackUnderflowException if this stack is empty
     */
    public T peek() throws StackUnderflowException;

    /**
     * Retrieves the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    public int size();

    /**
     * Checks if this stack is empty.
     *
     * @return {@code true} if this stack contains no items; {@code false} otherwise
     */
    public boolean isEmpty();
} // end of MyStackInterface
