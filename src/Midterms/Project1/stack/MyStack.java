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
 * MyStack is a generic stack implementation that provides
 * fundamental stack operations such as push, pop, and peek.
 *
 * @param <T> the type of elements in this stack
 */
public class MyStack<T> implements MyStackInterface<T> {
    private Node<T> top;
    private int count;

    /**
     * Constructs a new, empty stack.
     */
    public MyStack(){
        top = null;
        count = 0;
    }

    /**
     * Adds (pushes) an item onto the top of this stack and updates the element count.
     *
     * @param item the item to be added onto the top of this stack
     */
    public void push(T item) {
        Node<T> newNode = new Node<>(item, null);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
        count += 1;
    }

    /**
     * Removes (pops) the item at the top of this stack, updates the element count, and returns the item.
     *
     * @return the item at the top of this stack
     * @throws StackUnderflowException if this stack is empty
     */
    public T pop() throws StackUnderflowException {
        if (isEmpty()) throw new StackUnderflowException("Stack is empty");

        T topElement = top.getDatum();
        top = (count == 1) ? null : top.getNext();
        count -= 1;
        return topElement;
    }

    /**
     * Retrieves (peeks) the item at the top of this stack without removing it.
     *
     * @return the item at the top of this stack
     * @throws StackUnderflowException if this stack is empty
     */
    public T peek() throws StackUnderflowException {
        if (isEmpty()) throw new StackUnderflowException("Stack is empty");
        return top.getDatum();
    }

    /**
     * Retrieves the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    public int size() {
        return count;
    }

    /**
     * Checks if this stack is empty.
     *
     * @return {@code true} if this stack contains no items; {@code false} otherwise
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Returns a string representation of this stack. The string representation consists
     * of the stack's elements in order from top to bottom, enclosed in square brackets ("[]").
     * Adjacent elements are separated by the characters ", " (comma and space).
     *
     * @return a string representation of this stack
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> current = top;
        while (current != null) {
            result.append(current.getDatum());
            if (current.getNext() != null) {
                result.append(",");
            }
            current = current.getNext();
        }
        result.append("]");
        return result.toString();
    }
} // end of MyStack class
