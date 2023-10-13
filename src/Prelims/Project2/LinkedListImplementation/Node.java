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
package Prelims.Project2.LinkedListImplementation;

/**
 * Node is a generic class representing a node in a doubly-linked list.
 * @param <E> The type of data stored in the node.
 */
public class Node<E> {
    //Declare the instance variables for the Node class
    /**
     * The data stored in the node.
     */
    private E data;

    /**
     * A reference to the next node in the doubly-linked list.
     */
    private Node<E> next;

    /**
     * A reference to the previous node in the doubly-linked list.
     */
    private Node<E> prev;

    /**
     * Constructs a new node with the specified data.
     * @param data The data to be stored in the node.
     */
    public Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    /**
     * Retrieves the data stored in the node.
     * @return The data stored in the node.
     */
    public E getData() {
        return data;
    }

    /**
     * Sets the data stored in the node to the specified value.
     * @param data The new data to be stored in the node.
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Retrieves the reference to the next node in the list.
     * @return The reference to the next node.
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * Sets the reference to the next node in the list.
     * @param next The new reference to the next node.
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }

    /**
     * Retrieves the reference to the previous node in the list.
     * @return The reference to the previous node.
     */
    public Node<E> getPrev() {
        return prev;
    }

    /**
     * Sets the reference to the previous node in the list.
     * @param prev The new reference to the previous node.
     */
    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    /**
     * Returns a string representation of the data stored in the node.
     * @return A string representation of the node's data.
     */
    @Override
    public String toString() {
        return this.data.toString();
    }
}