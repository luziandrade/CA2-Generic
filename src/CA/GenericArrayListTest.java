package CA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericArrayListTest {
    //Declaring an array which will hold objects
    private GenericArrayList<String> arrStrList;
    private GenericArrayList<Integer> arrListInt;

    @BeforeEach
    void base() {
        arrListInt = new GenericArrayList<>();
        arrStrList = new GenericArrayList<>();

    }

    @Test
    void contains() {
        arrStrList.add("test7");
        assertTrue(arrStrList.contains("test7"));
        assertFalse(arrStrList.contains("test8"));
    }

    @Test
    void add() {
        StringBuilder str = new StringBuilder();
        StringBuilder Inte = new StringBuilder();


         //Add 15 string and 15 integers to GenericArray
        int i = 0;
        while (i < 15){
            arrStrList.add("C");
            str.append("C,");

            arrListInt.add(i);
            Inte.append(i).append(",");
            i++;
        }

        //Checking if two elements are equal
        assertEquals(str.toString() , arrStrList.toString());
        assertEquals(Inte.toString(), arrListInt.toString());
    }

    @Test
    void testAdd() {
        assertThrows(IndexOutOfBoundsException.class, () -> arrStrList.add(2, "test1"));
        arrStrList.add("t");
        arrStrList.add(0, "test1");
        arrStrList.add(1, "test2");
        arrStrList.add(2, "test3");
        arrStrList.add(3, "test4");
        arrStrList.add(4, "test5");
        assertEquals("test1,test2,test3,test4,test5,t,", arrStrList.toString());
    }

    @Test
    void isEmpty() {
        assertTrue(arrStrList.isEmpty());
        arrStrList.add("test6");
        assertFalse(arrStrList.isEmpty());
    }

    @Test
    void set() {
        arrStrList.add("One");
        assertEquals("One", arrStrList.set(0, "Two"));
        assertEquals("Two,", arrStrList.toString());
        assertThrows(IndexOutOfBoundsException.class, () -> arrStrList.set(2, "Boundaries"));
    }

    @Test
    void testRemove() {

        arrStrList.add("Test");
        arrStrList.add("Test");
        arrStrList.add("Test5");

        assertTrue(arrStrList.remove("Test"));
        assertFalse(arrStrList.remove("Test2"));
        assertFalse(arrStrList.remove("Test4"));
        assertEquals(2, arrStrList.size());
    }

    @Test
    void get() {
        arrStrList.add("Three");
        arrStrList.add("Four");
        arrStrList.add("Five");
        arrStrList.add("Six");
        arrStrList.add("Seven");
        assertEquals("Three", arrStrList.get(0));
        assertEquals("Four", arrStrList.get(1));
        assertEquals("Five", arrStrList.get(2));
        assertEquals("Six", arrStrList.get(3));
        assertEquals("Seven", arrStrList.get(4));
        assertThrows(IndexOutOfBoundsException.class, () -> arrStrList.get(5));
    }

    @Test
    void size() {
        int i = 0;
        while ( i < 5) {
            assertEquals(i, arrListInt.size());
            arrListInt.add(i);
            i++;
        }

    }

    @Test
    void remove() {

        arrStrList.add("Six");
        arrStrList.add("Seven");
        arrStrList.add("Eight");

        assertEquals("Seven", arrStrList.remove(1));
        assertEquals(2, arrStrList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> arrStrList.get(2));
    }

    @Test
    void iterator() {
        arrStrList.add("testing0");
        arrStrList.add("testing1");
        arrStrList.add("testing2");
        arrStrList.add("testing3");

        int i = 0;
        for (String s : arrStrList) {
            assertEquals("testing"+i, s);
            ++i;
        }
        assertEquals(4, i);
    }

    @Test
    void rotate() {
        int i = 1;
        while (i <= 15){
            arrListInt.add(i);
            i++;
        }
        arrListInt.rotate2(1);
        assertEquals("15,1,2,3,4,5,6,7,8,9,10,11,12,13,14,", arrListInt.toString());
    }

    @Test
    void rotateBy2() {
        int i = 1;
        while (i <= 15){
            arrListInt.add(i);
            i++;
        }

        arrListInt.rotate2(2);
        assertEquals("14,15,1,2,3,4,5,6,7,8,9,10,11,12,13,", arrListInt.toString());
    }

}