package midlab1.stack;

public class MyStack<T> implements MyStackInterface<T>{
    private Node<T> top;
    private int count;

    /**Constructs new null Stack. Initialize the count to 0*/
    public MyStack(){
        top=null;
        count=0;
    }

    /**Pushes/adds an element on top of the stack and updating the elements count.
     * @param item item to be added on the stack.*/
    public void push(T item ){
        Node<T> newNode = new Node<T>(item, null);
        if (isEmpty()) {
            top = newNode;
        }

        else {
            newNode.setNext(top);
            top = newNode;
        }
        count +=1;
        return;
    }

    /**Pops/deletes an element on top of the stack and updating the elements count.
     * @throws  StackUnderflowException when the stack is empty.
     * @return element being popped out of the stack.*/
    public T pop() throws StackUnderflowException{
        T topElement=null;
        if (isEmpty())
            throw new StackUnderflowException("Stack is empty");
        else {
            topElement = top.getDatum();
            if (count == 1) {
                top = null;
            } else {
                top = top.getNext();
            }
            count -= 1;
        }
        return topElement;
    }

    /**Peeks/checks the element on top of the stack.
     * @throws  StackUnderflowException when the stack is empty.
     * @return top element of the stack.*/
    public T peek() throws StackUnderflowException {
        T topElement=null;
        if (isEmpty())
            throw new StackUnderflowException("Stack is empty");
        else {
            topElement = top.getDatum();
        }
        return topElement;
    }

    /**Returns the element count of the stack.
     * @return the element count*/
    public int size(){
        return count;
    }

    /**
     * Checks if the stack is empty.
     * @return true if stack is empty, otherwise false. */
    public boolean isEmpty(){
        return (count==0);
    }

    /**
     * Returns the String representation of the stack
     * @return string representation of the stack
     */
    public String toString(){
        StringBuilder result = new StringBuilder("[");
        Node<T> current = top;
        while(current!=null){
            result.append(current.getDatum());
            if(current.getNext()!=null){
                result.append(",");
            }
            current = current.getNext();
        }
        result.append("]");
        return result.toString();
    }

} // end of MyStack class