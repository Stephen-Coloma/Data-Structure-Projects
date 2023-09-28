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
package Project2.LinkedListImplementation;

/**
 * The LinkedListInterface is an interface representing a generic linked list data structure.
 * @param <E> The type of elements to be stored in the linked list.
 */
public interface LinkedListInterface<E> {
    /**
     * Gets the current size of the linked list.
     * @return The number of elements in the linked list.
     */
    public int getSize();

    /**
     * Checks if the linked list is empty.
     * @return True if the linked list is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Searches for the index of a given data element in the linked list.
     * @param data The data element to search for.
     * @return The index of the first occurrence of the element, or -1 if not found.
     */
    public int search(String data);

    /**
     * Clears the linked list, removing all elements.
     */
    public void clear();

    /**
     * Sets the head of the linked list to the given data element.
     * @param data The data element to set as the new head.
     */
    public void setHead(E data);

    /**
     * Sets the tail of the linked list to the given data element.
     * @param data The data element to set as the new tail.
     */
    public void setTail(E data);

    /**
     * Inserts a new data element at the end (tail) of the linked list.
     * @param data The data element to insert.
     */
    public void insert(E data);

    /**
     * Inserts a new data element at the head of the linked list.
     * @param data The data element to insert.
     */
    public void insertAtHead(E data);

    /**
     * Inserts a new data element at the tail of the linked list.
     * @param data The data element to insert.
     */
    public void insertAtTail(E data);

    /**
     * Inserts a new data element at the specified index in the linked list.
     * @param index The index at which to insert the element.
     * @param data  The data element to insert.
     */
    public void insertAtIndex(int index, E data);

    /**
     * Retrieves the data element at the specified index in the linked list.
     * @param index The index of the element to retrieve.
     * @return The data element at the specified index.
     */
    public E getElement(int index);

    /**
     * Searches for a data element in the linked list and returns it.
     * @param data The data element to search for.
     * @return The first occurrence of the element found in the list.
     */
    public E getElement(E data);

    /**
     * Deletes the current element (tail) from the linked list.
     */
    public void delete();

    /**
     * Deletes the first occurrence of the specified data element from the linked list.
     * @param data The data element to delete.
     */
    public void delete(E data);

    /**
     * Deletes the current element (head) from the linked list.
     */
    public void deleteAtHead();

    /**
     * Deletes the current element (tail) from the linked list.
     */
    public void deleteAtTail();

    /**
     * Deletes the element at the specified index from the linked list.
     * @param index The index of the element to delete.
     */
    public void deleteAtIndex(int index);

    /**
     * Returns a string representation of the linked list.
     * @return A string representation of the linked list.
     */
    public String toString();
}