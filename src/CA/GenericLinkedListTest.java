package CA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;


class GenericLinkedListTest {

    @Test
    void add() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        assertEquals("One,Two,Three,Four,Five,", list.toString());
        assertEquals(5, list.size());
    }

    @Test
    void addAtIndicator() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Eight");
        list.add("Nine");
        list.add(2, "Six");
        list.add(3, "Ten");
        assertEquals(9, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(10, "Six"));
        list.add(9, "Eleven");
        assertEquals("One,Two,Six,Ten,Three,Four,Five,Eight,Nine,Eleven,", list.toString());
        list.add(1, "Seven");
        assertEquals("One,Seven,Two,Six,Ten,Three,Four,Five,Eight,Nine,Eleven,", list.toString());
    }

    @Test
    void capacity() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        int i = 0;
        while (i < 10){
            assertEquals(i, list.size());
            list.add("N");
            ++i;
        }
    }

    @Test
    void discardTheSame() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("Two");
        list.add("Two");

        list.remove("Two");
        assertEquals("Two,", list.toString());
    }


    @Test
    void set() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("One");
        list.add("Generic List");
        list.add("Setting List");
        assertEquals("Generic List", list.set(1, "Linked List"));
        assertEquals("One,Linked List,Setting List,", list.toString());
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, "avoid"));
    }

    @Test
    void get() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertEquals("One", list.get(0));
        assertEquals("Two", list.get(1));
        assertEquals("Three", list.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }


    @Test
    void remove() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        assertEquals("Two", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("One,Three,", list.toString());
        list.add("Four");
        assertEquals("One,Three,Four,", list.toString());
        assertEquals("Three", list.remove(1));
        assertEquals("One,Four,", list.toString());
    }


    @Test
    void discardAtIndicator() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.remove("Two");
        assertEquals(2, list.size());
        assertEquals("One,Three,", list.toString());
        list.add("Four");
        assertEquals("One,Three,Four,", list.toString());
        list.remove("One");
        list.remove("Three");
        assertEquals("Four,", list.toString());
    }

    @Test
    void discardAtIndicator2()
    {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("One");
        list.add("Two");
        list.remove("One");
        assertEquals("Two,", list.toString());
        assertEquals(1, list.size());

        list.add("One");
        assertEquals("Two,One,", list.toString());
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
    }

    @Test
    void discardEmpty()
    {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void contains() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        assertTrue(list.contains("One"));
        assertTrue(list.contains("Two"));
        assertTrue(list.contains("Three"));
        assertTrue(list.contains("Four"));
        assertTrue(list.contains("Five"));
        assertTrue(list.contains("Six"));
        assertFalse(list.contains("Seven"));
    }

    @Test
    void isEmpty() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        assertTrue(list.isEmpty());
        list.add("One");
        assertFalse(list.isEmpty());
    }


    @Test
    void startAndNext() {
        GenericLinkedList<String> list = new GenericLinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        StringBuilder expectedString = new StringBuilder();
        for (String l : list) {
            expectedString.append(l).append(",");
        }
        assertEquals("One,Two,Three,Four,Five,", expectedString.toString());
    }

    @Test
    void emptystartAndNext() {
        GenericLinkedList<String> list = new GenericLinkedList<>();

        int i = 0;
        for (String l : list) {
            ++i;
        }
        assertEquals(0, i);
    }

    @Test
    void rotateBy1() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        int i = 5;
        while( i <= 14) {
            list.add(i);
            i++;
        }
        list.rotate2(1);
        assertEquals("14,5,6,7,8,9,10,11,12,13,", list.toString());
    }

    @Test
    void rotateBy2() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        int i = 5;
        while ( i <= 14) {
            list.add(i);
            i++;
        }
        list.rotate2(2);
        assertEquals("13,14,5,6,7,8,9,10,11,12,", list.toString());
    }


    @Test
    void rotateBy5Minus() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        int i = 5;
        while ( i <= 14 ) {
            list.add(i);
            i++;
        }
        list.rotate2(-5);
        assertEquals("10,11,12,13,14,5,6,7,8,9,", list.toString());
    }
}