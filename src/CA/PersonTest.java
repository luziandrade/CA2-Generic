package CA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person testPerson;


    @BeforeEach
    void setUp() {

        testPerson = new Person(29, "Andrade", "Luana");
    }

    @Test
    void getFirstname() {

        assertEquals("Luana", testPerson.getFirstname());
    }

    @Test
    void getSurname() {

        assertEquals("Andrade", testPerson.getSurname());
    }

    @Test
    void getAge() {

        assertEquals(29, testPerson.getAge());
    }

    @Test
    void compareTo() {
        Person personOne = new Person(28, "Surname", "Name");
        Person personTwo = new Person(29, "Surname", "Name");
        Person personThree = new Person(30, "Surname", "Name");

        assertEquals(1, testPerson.compareTo(personOne));
        assertEquals(0, testPerson.compareTo(personTwo));
        assertEquals(-1, testPerson.compareTo(personThree));
    }

    @Test
    void ToString() {
        String expected = "Person{" +
                "firstname='Luana" + '\'' +
                ", surname='Andrade" + '\'' +
                ", age=29" +
                '}';
        assertEquals(expected, testPerson.toString());
    }
}
