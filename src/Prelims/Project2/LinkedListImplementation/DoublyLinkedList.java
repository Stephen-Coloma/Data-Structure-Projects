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

import java.util.NoSuchElementException;

/**
 * DoublyLinkedList is a generic class that implements a doubly-linked list data structure.
 * It allows insertion, deletion, and retrieval of elements from both ends and at specific indices.
 * @param <E> The type of elements to be stored in the linked list.
 */
public class DoublyLinkedList<E> implements LinkedListInterface<E> {
    // Declare the instance variables for the DoublyLinkedList class
    /**
     * The size of the doubly-linked list, representing the number of elements it contains.
     */
    private int size;

    /**
     * The reference to the first node (head) in the doubly-linked list.
     */
    private Node<E> head;

    /**
     * The reference to the last node (tail) in the doubly-linked list.
     */
    private Node<E> tail;


    /**
     * Constructs an empty DoublyLinkedList.
     */
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Returns the current size of the linked list.
     * @return The number of elements in the linked list.
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Checks if the linked list is empty.
     * @return True if the linked list is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Searches for an element in the linked list and returns its index.
     * @param element The element to search for.
     * @return The index of the first occurrence of the element, or -1 if not found.
     */
    @Override
    public int search(String element) {
        Node<E> current = head;
        int index = 0;

        while (current != null) {
            if (element.equals(current.getData())) {
                return index;
            }
            current = current.getNext();
            index++;
        }

        return -1; // Element not found
    }

    /**
     * Clears the linked list, removing all elements.
     */
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Sets the head of the linked list to the given data element.
     * @param data The data element to set as the new head.
     */
    @Override
    public void setHead(E data) {
        Node<E> newNode = new Node<>(data);

        if (head == null){
            this.head = newNode;
            this.tail = newNode;
            size++;
        }else if(size == 1) {
            this.head = newNode;
            this.tail = newNode;
        }else {
            newNode.setNext(this.head.getNext()); //temp point to second element
            head.getNext().setPrev(newNode); //second element point back to temp
            this.head = newNode;
        }
    }

    /**
     * Sets the tail of the linked list to the given data element.
     * @param data The data element to set as the new tail.
     */
    @Override
    public void setTail(E data) {
        Node<E> newNode = new Node<>(data);

        if (this.tail == null){
            this.head = newNode;
            this.tail = newNode;
            size++;
        }else if(size == 1) {
            this.head = newNode;
            this.tail = newNode;
        }else{
            Node<E> current = this.tail.getPrev();
            current.setNext(newNode);
            newNode.setPrev(current);
        }
    }

    /**
     * Inserts a new element at the end (tail) of the linked list.
     * @param data The data element to insert.
     */
    @Override
    public void insert(E data){
        Node<E> newNode = new Node<>(data);

        if (tail == null){
            this.head = newNode;
            this.tail = newNode;
        }else {
            this.tail.setNext(newNode);
            newNode.setPrev(tail);
            this.tail = newNode;
        }

        size++;
    }

    /**
     * Inserts a new element at the head of the linked list.
     * @param data The data element to insert.
     */
    @Override
    public void insertAtHead(E data) {
        Node<E> newNode = new Node<>(data);

        if (this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else {
            newNode.setNext(this.head); //newNOde points to head
            this.head.setPrev(newNode);//head points to newNOde
            this.head = newNode;
        }

        size++;
    }

    /**
     * Inserts a new element at the tail of the linked list.
     * @param data The data element to insert.
     */
    @Override
    public void insertAtTail(E data) {
        Node<E> newNode = new Node<>(data);

        if (tail == null){
            this.head = newNode;
            this.tail = newNode;
        }else {
            this.tail.setNext(newNode);
            newNode.setPrev(tail);
            this.tail = newNode;
        }

        size++;
    }

    /**
     * Inserts a new element at the specified index in the linked list.
     * @param index The index at which to insert the element.
     * @param data  The data element to insert.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public void insertAtIndex(int index, E data) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Cannot add the element: Index " + index + " is out of bounds");
        }

        Node<E> newNode = new Node<>(data);

        if (index == 0) {
            // Insert at the head
            newNode.setNext(head);
            if (head != null) {
                head.setPrev(newNode);
            }
            head = newNode;

            if (tail == null) {
                // If the list was empty, update the tail
                tail = newNode;
            }
        } else if (index == this.size) {
            // Insert at the tail
            newNode.setPrev(tail);
            if (tail != null) {
                tail.setNext(newNode);
            }
            tail = newNode;

            if (head == null) {
                // If the list was empty, update the head
                head = newNode;
            }
        } else {
            // Insert in the middle
            int counterFromHead = 0;
            Node<E> current = head;

            while (counterFromHead < index) {
                current = current.getNext();
                counterFromHead++;
            }

            newNode.setPrev(current.getPrev());
            newNode.setNext(current);
            current.getPrev().setNext(newNode);
            current.setPrev(newNode);
        }

        size++;
    }

    /**
     * Retrieves the element at the specified index in the linked list.
     * @param index The index of the element to retrieve.
     * @return The data element at the specified index.
     * @throws NoSuchElementException if the index is invalid.
     */
    @Override
    public E getElement(int index) throws NoSuchElementException{
        if (index < 0 || index>=this.size){
            throw new NoSuchElementException("No such element was found");
        } else if (index >= (size/2)) { //traverse from tail
            int counterFromTail = size-1;

            Node<E> current = tail;
            while (counterFromTail != index){
                current = current.getPrev(); //traverse from tail backwards
                counterFromTail--;
            }
            return current.getData();
        }else { //traverse from head
            int counterFromHead = 0;

            Node<E> current = head;
            while (counterFromHead != index){
                current = current.getNext(); //traverse from tail backwards
                counterFromHead++;
            }
            return current.getData();
        }
    }

    /**
     * Searches for an element in the linked list and returns it.
     * @param data The data element to search for.
     * @return The first occurrence of the element found in the list.
     * @throws NoSuchElementException if the element is not found.
     */
    @Override
    public E getElement(E data) throws NoSuchElementException{
        Node<E> current = head;

        while (current != null) {
            if (data.equals(current.getData())) {
                return current.getData(); // Found the element, return it
            }
            current = current.getNext();
        }
        throw new NoSuchElementException("No such element was found");
    }

    /**
     * Deletes the current element (tail) from the linked list.
     * @throws NoSuchElementException if the list is empty.
     */
    @Override
    public void delete() throws NoSuchElementException{
        if (tail == null){//0 elements
            throw new NoSuchElementException("There is no current element at Tail");
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
        }else {
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
            size--;
        }
    }

    /**
     * Deletes the first occurrence of the specified element from the linked list.
     * @param data The data element to delete.
     * @throws NoSuchElementException if the element is not found.
     */
    @Override
    public void delete(E data) throws NoSuchElementException{
        if (this.isEmpty()){
            throw new NoSuchElementException("The list is empty");
        } else if (size == 1) {
            if (data.equals(this.head.getData())){
                this.head = null;
                this.tail = null;
                size--;
            }else throw new NoSuchElementException("Element not found in the list");
        }else {
            Node<E> current = head;
            if (data.equals(head.getData())){
                head = current.getNext();
                head.setPrev(null);
                size--;
                return;
            }
            while (current != null){
                if (data.equals(current.getData())){
                    Node<E> prevNode = current.getPrev();
                    Node<E> nextNode = current.getNext();

                    if (prevNode != null) {
                        prevNode.setNext(nextNode);
                    }
                    if (nextNode != null) {
                        nextNode.setPrev(prevNode);
                    } else {
                        // If the deleted node is the tail, update the tail
                        tail = prevNode;
                    }
                    size--;
                    return;
                }
                current = current.getNext();
            }

            throw new NoSuchElementException("Element not found in the list");
        }
    }

    /**
     * Deletes the current element (head) from the linked list.
     * @throws NoSuchElementException if the list is empty.
     */
    @Override
    public void deleteAtHead() throws NoSuchElementException{
        if (head == null) {
            throw new NoSuchElementException("There is no current element at Head");
        } else if (size == 1) {
            head =null;
            tail=null;
            size--;
        }else {
            head.getNext().setPrev(null);
            head = head.getNext();
            size--;
        }
    }

    /**
     * Deletes the current element (tail) from the linked list.
     * @throws NoSuchElementException if the list is empty.
     */
    @Override
    public void deleteAtTail() {
        if (tail == null){//0 elements
            throw new NoSuchElementException("There is no current element at Tail");
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
        }else {
            tail.getPrev().setNext(null);
            tail = tail.getPrev();
            size--;
        }
    }


    /**
     * Deletes the element at the specified index in the linked list.
     * @param index The index of the element to delete.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public void deleteAtIndex(int index) {
        if (index >= this.size || index < 0){
            throw new IndexOutOfBoundsException("Cannot add the element: Index " + index + " is out of bounds");
        }else if(index == 0){
            deleteAtHead();
        }else if (index == this.size-1) {
            deleteAtTail();
        }else {
            if (index >= (size / 2)) { //a,b,c,d,e,f  5 size, index 3.
                int counterFromTail = size - 1;

                Node<E> current = tail;
                while (counterFromTail != index) {
                    current = current.getPrev(); //traverse from tail backwards
                    counterFromTail--;
                }
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
            } else {
                int counterFromHead = 0;

                Node<E> current = head;
                while (counterFromHead != index) {
                    current = current.getNext(); //traverse from tail backwards
                    counterFromHead++;
                }
                current.getPrev().setNext(current.getNext());
                current.getNext().setPrev(current.getPrev());
            }
            size--;
        }
    }


    /**
     * Returns a string representation of the linked list.
     * @return A string representation of the linked list in the format: "null <--> ... <--> null".
     */
    @Override
    public String toString(){
        if (head == null){
            return "null";
        }else {
            Node<E> current = head;

            String temp = "null <--> " + current.toString();

            while (current.getNext() != null){
                temp += " <--> " + current.getNext().toString() ;
                current = current.getNext();
            }

            temp += " <--> null";

            return temp;
        }
    }
}