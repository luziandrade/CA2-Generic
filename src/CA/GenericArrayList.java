package CA;

import interfaces.IList;

import java.util.*;

public class GenericArrayList<T> implements IList<T> {

    //Declaring variables to hold arrays
    private T[] buffer;

    // Declaring variable to determine if buffer is full
    private int nextFreeLoc;

    //Declaring variable to allocate more space when the buffer is full
    private int currentCapacity;

    private static final int INITIAL_CAPACITY = 3;

    public GenericArrayList() {
        currentCapacity = INITIAL_CAPACITY;
        nextFreeLoc = 0;
        buffer = (T[]) new Object[currentCapacity];
    }


    @Override
    public void add(T elem) {
        addArray();
        buffer[nextFreeLoc++] = elem;
    }

    //Adding element to a position
    @Override
    public void add(int index, T element) {
        if (index > nextFreeLoc || index < 0) {
            throw new IndexOutOfBoundsException("Outside of the range");
        }

        //Adding arrays
        addArray();

        //Discolate everything up from right to left
        //Discolate everything from left to right
        int i = nextFreeLoc;
        while(i > index){
            buffer[i] = buffer[i - 1];
            i--;
        }

        buffer[index] = element;

        nextFreeLoc++;
    }

    //Updating element to a position
    @Override
    public T set(int index, T element) {
        if (index > nextFreeLoc || index < 0) {
            throw new IndexOutOfBoundsException("Outside of the range");
        }
        int i = 0;
        while(i < nextFreeLoc) {
            if (i == index) {
                T previousElement = buffer[i];
                buffer[i] = element;

                return previousElement;
            }
            i++;
        }


        return null;
    }

    //Getting element to a position
    @Override
    public T get(int index) {
        if (index >= nextFreeLoc || index < 0) {
            throw new IndexOutOfBoundsException("Outside of the range");
        }

        return buffer[index];
    }

    @Override
    public int size() {

        return nextFreeLoc;
    }

    //Remove element from the list
    @Override
    public T remove(int index) {
        if (index >= nextFreeLoc || index < 0) {
            throw new IndexOutOfBoundsException("Outside of the range");
        }
        T removedElement = buffer[index];

        int i = index;
        while(i < nextFreeLoc){
            this.addArray();
            buffer[i] = buffer[i + 1];
            i++;
        }
        nextFreeLoc--;
        return removedElement;
    }

    @Override
    public boolean remove(T elem) {

        int i = 0;
        while(i < nextFreeLoc){
            if (buffer[i].equals(elem)) {
                this.remove(i);
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {

        return (nextFreeLoc == 0);
    }


    @Override
    public boolean contains(T element) {

        int index = 0;
        while(index < nextFreeLoc){
            if (buffer[index].equals(element)) {
                return true;
            }
            index++;
        }
        return false;
    }

    private void addArray() {
        if (nextFreeLoc == currentCapacity) {
            T[] tempArr;
            tempArr = (T[]) new Object[buffer.length * 2];
            currentCapacity *= 2;


            int i = 0;
            while(i < buffer.length){
                tempArr[i] = buffer[i];
                i++;
            }

            buffer = tempArr;
        }
    }


    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        int i = 0;
        while(i < nextFreeLoc){
            data.append(buffer[i]).append(",");
            i++;
        }

        return data.toString();
    }


    @Override
    public Iterator<T> iterator() {

        return new GenericArrayListIterator();
    }

    //Rotating elements setting distance
    @Override
    public void rotate2(int distance) {
        if(distance < 0) {
            distance += size();
        }
        if(distance == 0) {
            return;
        }
        T temp;

        int i = 0;
        while(i < distance){
            temp = remove(size() - 1);
            add(0, temp);
            i++;
        }
    }


    class GenericArrayListIterator implements Iterator<T> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < nextFreeLoc;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return buffer[cursor++];
        }
    }


}
