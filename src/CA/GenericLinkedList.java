package CA;

import interfaces.IList;

import java.util.*;

public class GenericLinkedList<T> implements IList<T> {

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    //Creating a  CONSTRUCTOR for a new node
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            next = null;
        }
    }

//Adding an element to the end of the array list
    @Override
    public void add(T elem) {
        Node last = tail;
        Node newNode = new Node(elem);

        tail = newNode;

        if (last == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }

        size++;
    }

    //Adding element to a position
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            addToBeg(element);
        } else if (index == size) {
            add(element);
        } else {
            Node newNode = new Node(element);
            Node prevNode = getNode(index - 1);
            Node nextNode = getNode(index);

            prevNode.next = newNode;
            newNode.next = nextNode;
        }
        size++;
    }


    public void addToBeg(T elem) {
        Node newNode = new Node(elem);
        newNode.next = head;
        head = newNode;
    }

    //Updating element to a position
    @Override
    public T set(int index, T element) {
        Node node = getNode(index);
        assert node != null;
        T prevData = node.data;
        node.data = element;
        return prevData;
    }

    //Getting element to a position
    @Override
    public T get(int index) {
        if(index == size() - 1) {
            return tail.data;
        }
        Node node = getNode(index);
        return (node == null) ? null : node.data;
    }


    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node set = head;
        int i = 0;
        while(set != null){
            if (i == index) {
                return set;
            }
            set = set.next;
            i++;
        }
        return null;
    }


    @Override
    public int size() {
        return size;
    }

    //Remove element from the list
    @Override
    public T remove(int index) {
        Node delNode = getNode(index);

        Node prevNode;
        if (index == 0) {
            prevNode = head.next;
            head = prevNode;
        } else {
            prevNode = getNode(index - 1);
        }

        if (prevNode == null) {
            tail = null;
        } else if (index + 1 >= size) {
            prevNode.next = null;
            tail = prevNode;
        } else {
            prevNode.next = getNode(index + 1);
        }
        size--;

        return delNode.data;
    }

    //Remove element from the list
    @Override
    public boolean remove(T elem) {
        if (isEmpty()) {
            return false;
        }

        int index = getNodeIndex(elem);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public boolean contains(T element) {
        return getNodeIndex(element) >= 0;
    }

    private int getNodeIndex(T element) {
        int i = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return i;
            }
            current = current.next;
            i++;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        //
        return new GenericLinkedListIterator();
    }

    //Rotating elements setting distance
    @Override
    public void rotate2(int distance) {
        T temp;
        if(distance < 0) {
            distance = distance + size;
        }

        if(distance == 0) {
            return;
        }
        int i = 0;
        while(i < distance){
            temp = remove(size() - 1);
            add(0, temp);
            i++;
        }


    }

    @Override
    public String toString() {
        Node set = head;
        StringBuilder string = new StringBuilder();
        while (set != null) {
            string.append(set.data).append(",");
            set = set.next;
        }
        return string.toString();
    }

    class GenericLinkedListIterator implements Iterator<T> {
        Node set = head;


        @Override
        public boolean hasNext() {
            return set != null;
        }


        @Override
        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = set.data;
            set = set.next;
            return data;
        }
    }
}
