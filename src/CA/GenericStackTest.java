package CA;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GenericStackTest {

    @Test
    void peekEmpty() {
        GenericStack<Integer> stack = new GenericStack<>();
        assertThrows(EmptyStackException.class, stack::peek);
    }

    @Test
    void empty() {
        GenericStack<Integer> stack = new GenericStack<>();
        assertTrue(stack.empty());
        stack.push(10);
        assertFalse(stack.empty());
    }

    @Test
    void pop() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(10);
        list.add(9);

        GenericStack<Integer> stack = new GenericStack<>(list);
        stack.push(8);
        assertEquals("10,9,8,", stack.toString());
    }

    @Test
    void popEmpty() {
        GenericStack<Integer> stack = new GenericStack<>();
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void peek() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(10);
        list.add(9);

        GenericStack<Integer> stack = new GenericStack<>(list);
        assertEquals(9, stack.peek());
        assertEquals("10,9,", stack.toString());
    }


    @Test
    void iterator() {
        GenericStack<Integer> stack = new GenericStack<>();
        stack.push(1);
        stack.push(2);

        int i = 1;
        for(int no : stack) {
            assertEquals(i, no);
            ++i;
        }
        assertEquals(3, i);
    }

    @Test
    void linkedList()
    {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("testing0");
        list.add("testing1");
        list.add("testing2");
        list.add("testing3");

        GenericStack<String> stack = new GenericStack<>(list);
        int i = 0;
        for(String elem : stack) {
            assertEquals("testing"+i, elem);
            i++;
        }
        assertEquals(4, i);
    }

    @Test
    void GenericArrList() {
        GenericArrayList<Integer> list = new GenericArrayList<>();
        list.add(10);
        list.add(9);

        GenericStack<Integer> stack = new GenericStack<>(list);
        stack.push(8);
        assertEquals("10,9,8,", stack.toString());
    }

    @Test
    void GenericLinkedList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.add(10);
        list.add(9);

        GenericStack<Integer> stack = new GenericStack<>(list);
        stack.push(8);
        assertEquals("10,9,8,", stack.toString());
    }

}