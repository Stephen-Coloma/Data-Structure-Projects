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
 * The Node class represents a node in a linked list, which can store a data item
 * of generic type T and a reference to the next Node in the list.
 *
 * @param <T> the type of elements held in the Node.
 */
public class Node<T> {

    private T datum;  // The data element stored in the Node.
    private Node<T> next;  // Reference to the next Node in the list.

    /**
     * Default constructor initializes the Node with null values.
     */
    public Node(){
        datum = null;
        next = null;
    }

    /**
     * Parameterized constructor initializes the Node with the provided values.
     *
     * @param datum the data to be stored in the Node.
     * @param next the next Node in the list.
     */
    public Node(T datum, Node<T> next){
        this.datum = datum;
        this.next = next;
    }

    /**
     * @return T returns the data stored in the Node.
     */
    public T getDatum(){
        return datum;
    }

    /**
     * @return Node<T> returns the next Node in the list.
     */
    public Node<T> getNext(){
        return next;
    }

    /**
     * Sets the data stored in the Node.
     *
     * @param datum the data to be stored.
     */
    public void setDatum(T datum){
        this.datum = datum;
    }

    /**
     * Sets the next Node in the list.
     *
     * @param n the Node to be set as the next Node.
     */
    public void setNext(Node<T> n){
        next = n;
    }
} // end of Node class
