package CA;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class GenericQueueTest {

    @Test
    void enqueue() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.enqueue(10);
        assertEquals("10,", queue.toString());
    }

    @Test
    void dequeue() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.enqueue(15);
        queue.enqueue(16);

        assertEquals(15, queue.dequeue());
        assertEquals("16,", queue.toString());
    }

    @Test
    void emptyDequeue() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        assertThrows(NoSuchElementException.class, queue::dequeue);
    }


    @Test
    void firstOne() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.enqueue(15);
        queue.enqueue(16);
        queue.enqueue(17);

        assertEquals(15, queue.first());
    }

    @Test
    void emptyFirstOne() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        assertThrows(NoSuchElementException.class, queue::first);
    }

    @Test
    void empty() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        assertTrue(queue.empty());
    }

    @Test
    void iterator() {
        GenericQueue<Integer> stack = new GenericQueue<>();
        stack.enqueue(1);
        stack.enqueue(2);

        int i = 1;
        for(int no : stack) {
            assertEquals(i, no);
            ++i;
        }
        assertEquals(3, i);
    }


    @Test
    void enqueueGenericLinkedList(){
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        StringBuilder expectedOut = new StringBuilder();

        int i = 0;
        while ( i < 9) {
            list.add(i);
            expectedOut.append(i).append(",");
            ++i;
        }
        GenericQueue<Integer> queue = new GenericQueue<>(list);
        assertEquals(expectedOut.toString(), queue.toString());

        queue.enqueue(10);
        assertEquals(expectedOut +"10,", queue.toString());
    }


    @Test
    void linkedList()
    {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("testing0");
        list.add("testing1");

        GenericQueue<String> stack = new GenericQueue<>(list);
        int i = 0;
        for(String elem : stack) {
            assertEquals("testing"+i, elem);
            i++;
        }
        assertEquals(2, i);
    }
}