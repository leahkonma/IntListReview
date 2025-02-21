import java.util.Iterator;

public class DoublyLinkedIntList implements IntList{
    //private fields
    private class Node{
        int data;
        Node next; // address of the node "after" this one in line
        Node prev; //address of the node "before" this one in line

        public Node(){
            next = null;
            prev = null;
        }
    }

    private Node pre;
    private Node post;
    private int size;

    //constructor
    public DoublyLinkedIntList(){
        //an empty list has 2 sentinel (dummy) nodes that serve as bookends
        pre = new Node();
        post = new Node();
        pre.next = post; //sentinel node before first data node
        post.prev = pre; //sentinel node after last data node
        size = 0;
    }

    public void printList(){
        //start at the first node, after first sentinel
        Node current = pre.next;

        //go through the list until the last sentinel node
        while (current != post){
            System.out.print(current.data + ", ");
            current = current.next;
        }
    }

    /**
     * Prepends (inserts) the specified value at the front of the list (at index 0).
     * Shifts the value currently at the front of the list (if any) and any
     * subsequent values to the right.
     *
     * @param value value to be inserted
     */
    @Override
    public void addFront(int value) {
        Node newNode = new Node();
        newNode.data = value;

        //adjust references to point to new node
        newNode.prev = pre;
        newNode.next = pre.next;

        //update first and end sentinels
        pre.next.prev = newNode;
        pre.next = newNode;

        size++;
    }

    /**
     * Appends (inserts) the specified value at the back of the list (at index size()-1).
     *
     * @param value value to be inserted
     */
    @Override
    public void addBack(int value) {
        Node lastNode = post.prev;

        //set up my new node and fill it out (data, prev, next)
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = post;
        newNode.prev = lastNode;

        //go to the end of the list's sentinel, and update it's prev
        post.prev = newNode;

        //go to the node before the new on, and update it's next
        lastNode.next = newNode;
        size++;
    }

    /**
     * Inserts the specified value at the specified position in this list.
     * Shifts the value currently at that position (if any) and any subsequent
     * values to the right.
     *
     * @param index index at which the specified value is to be inserted
     * @param value value to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, int value) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node newNode = new Node();
        newNode.data = value;

        Node current = pre.next;

        for (int i = 0; i < index; i++) {
           current = current.next;
        }

        //update references to include new node
        newNode.next = current.prev;
        newNode.prev = current;

        //update neighboring nodes' reference
        current.prev.next = newNode;
        current.prev = newNode;

        size++;
    }

    /**
     * Removes the value located at the front of the list
     * (at index 0), if it is present.
     * Shifts any subsequent values to the left.
     */
    @Override
    public void removeFront() {
        if (size > 0){
            //the node to be removed
            Node removedNode = pre.next;

            //update references
            pre.next = removedNode.next; //set pre to the node after the removed one
            removedNode.next.prev = pre; //new 'first' node connects back to sentinel pre
            size--;
        }

    }

    /**
     * Removes the value located at the back of the list
     * (at index size()-1), if it is present.
     */
    @Override
    public void removeBack() {
        if(size > 0){
            //set up temporary variable
            Node removedNode = post.prev;

            //go to the node before the last, and point to post node
            removedNode.prev.next = post;

            //point the post node to the node before the removedNode
            post.prev = removedNode.prev;

            //optional to clean up
            removedNode.next = null;
            removedNode.prev = null;

            size--;
        }
    }

    /**
     * Removes the value at the specified position in this list.
     * Shifts any subsequent values to the left. Returns the value
     * that was removed from the list.
     *
     * @param index the index of the value to be removed
     * @return the value previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int remove(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node removedNode = pre;

        //removing first node
        if (index == 0){
            removeFront();
        }
        //removing last node
        else if (index == size-1){
            removeBack();
        }
        //removing middle node
        else{
            Node current = pre.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            removedNode = current;
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
        return removedNode.data;
    }

    /**
     * Returns the value at the specified position in the list.
     *
     * @param index index of the value to return
     * @return the value at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public int get(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node current = pre.next;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        //return the data at the index
        return current.data;
    }

    /**
     * Returns true if this list contains the specified value.
     *
     * @param value value whose presence in this list is to be searched for
     * @return true if this list contains the specified value
     */
    @Override
    public boolean contains(int value) {
        //if list is empty
        if(pre.next == post){
            return false;
        }
        //new node to traverse list
        Node current = pre.next;

        while (current.next != post){
            if (current.data == value){
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified value
     * in this list, or -1 if this list does not contain the value.
     *
     * @param value value to search for
     * @return the index of the first occurrence of the specified value in this list
     * or -1 if this list does not contain the value
     */
    @Override
    public int indexOf(int value) {
        Node current = pre.next;
        int index = 0;

        //go to the end of the list
        while(current != post){
            if (current.data == value){
                return index;
            }else{
                index++;
                current = current.next;
            }
        }
        return -1;
    }

    /**
     * @return true if this list contains no values
     */
    @Override
    public boolean isEmpty() {
        if (pre.next == post){
            return true;
        }
        return false;
    }

    /**
     * @return the number of values in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all the values from this list.
     * The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        pre.next = post;
        size = 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
