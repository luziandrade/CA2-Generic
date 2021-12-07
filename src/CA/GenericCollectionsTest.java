package CA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;


class GenericCollectionsTest {
    //Declaring an array which will hold objects
    private final GenericArrayList<Person> person = new GenericArrayList<>();
    private final GenericArrayList<Integer> age = new GenericArrayList<>();

    @BeforeEach
    void base() {
        person.add(new Person(20, "Hegarty", "Dermot"));
        person.add(new Person(23, "Minchin", "Tim"));
        person.add(new Person(19, "DiCamillo", "Kate"));
        person.add(new Person(28, "Hardinge", "Frances"));
        person.add(new Person(24, "Bryson", "Bill"));
        person.add(new Person(26, "Ness", "Patrick"));

        int i = 1;
        while(i <= 6){
            age.add(i);
            i++;
        }
    }


    @Test
    void sort() {
        GenericCollections.sort(person);
        assertEquals(19, person.get(0).getAge());
        assertEquals(26, person.get(person.size() - 2).getAge());
    }

    @Test
    void maxAge() {
        Person oldAge = GenericCollections.max(person);
        assertEquals(28, oldAge.getAge());
    }

    @Test
    void maxOnEmptyArr() {
        GenericArrayList<Integer> emptyArrList = new GenericArrayList<>();
        assertThrows(NoSuchElementException.class, () -> GenericCollections.max(emptyArrList));
    }

    @Test
    void rotationBy1() {
        GenericCollections.rotate(age, 1);
        assertEquals("6,1,2,3,4,5,", age.toString());

    }

    @Test
    void rotationBy2() {
        GenericCollections.rotate(age, 2);
        assertEquals("5,6,1,2,3,4,", age.toString());
    }


    @Test
    void rotationMinus() {
        GenericCollections.rotate(age, -5);
        assertEquals("6,1,2,3,4,5,", age.toString());
    }

    @Test
    void rotationPersonTwo() {
        GenericCollections.rotate(person, 2);
        assertEquals(24, person.get(0).getAge());
        assertEquals(26, person.get(1).getAge());
        assertEquals(20, person.get(2).getAge());
        assertEquals(28, person.get(person.size() - 1).getAge());
        assertEquals(19, person.get(person.size() - 2).getAge());
    }

    @Test
    void rotate2() {
        GenericCollections.rotate2(age, 2);
        assertEquals("5,6,1,2,3,4,", age.toString());
    }

    @Test
    void rotate2List() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();

        int i = 1;
        while(i <= 10){
            list.add(i);
            i++;
        }

        GenericCollections.rotate(list, 1);
        assertEquals("10,1,2,3,4,5,6,7,8,9,", list.toString());
    }

}