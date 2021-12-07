package CA;

import interfaces.IList;
import interfaces.IStack;

import java.util.*;

public class GenericStack<T> implements IStack<T>, Iterable<T> {
    private final IList<T> stackData;

    public GenericStack() {

        stackData = new GenericArrayList<>();
    }

    public GenericStack(IList<T> data) {

        stackData = data;
    }

    /**
     * Pushes an item onto the top of this stack
     *
     * @param element the element argument.
     */
    @Override
    public void push(T element) {

        stackData.add(element);
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack
     */
    @Override
    public T pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        int set = stackData.size() - 1;
        T first = stackData.get(set);
        stackData.remove(set);
        return first;
    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return the object at the top of this stack
     */
    @Override
    public T peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        int key = stackData.size() - 1;
        return stackData.get(key);
    }

    /**
     * Tests if this stack is empty.
     *
     * @return {@code true} if and only if this stack contains
     * no items; {@code false} otherwise.
     */
    @Override
    public boolean empty() {

        return stackData.size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        int i = 0;
        while ( i < stackData.size()) {
            builder.append(stackData.get(i)).append(",");
            i++;
        }
        return builder.toString();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {

        return new GenericIteratorStackQueue<>(stackData);
    }

}
