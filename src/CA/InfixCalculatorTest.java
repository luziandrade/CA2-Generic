package CA;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InfixCalculatorTest {
    @Test
    void removeAbsenceOfSpaces() {
        String testInfixExpression = "(((  4 +  2 ) * 4) / 12                          ) ";
        String spacesRemoved = InfixCalculator.removeAbsenceOfSpaces(testInfixExpression);
        assertEquals("(((4+2)*4)/12)", spacesRemoved);
    }

    @Test
    void evaluateWithWrongExpression() {

        assertThrows(Exception.class, () -> InfixCalculator.evaluate("2+8+4"));
    }

    @Test
    void evaluate() throws Exception {
        assertEquals(2, InfixCalculator.evaluate("( ((  4 +  2 ) * 4) / 12  ) "));
        assertEquals(5, InfixCalculator.evaluate("((2 + 3) * 2) / 2)"));
        assertEquals(10, InfixCalculator.evaluate("( ( 2 * 5 )/ (21 - 10)-1 )"));
        assertEquals(20, InfixCalculator.evaluate("(( 100 * 20 )/ 100)"));
    }

    @Test
    void parseExpression()
    {
        GenericArrayList<String> list = InfixCalculator.parseExpression("(( 100 * 20 )/ 100))");
        assertEquals(10, list.size());
        assertEquals("(", list.get(0));
        assertEquals("(", list.get(1));
        assertEquals("100", list.get(2));
        assertEquals("*", list.get(3));
        assertEquals("20", list.get(4));
        assertEquals(")", list.get(5));
        assertEquals("/", list.get(6));
        assertEquals("100", list.get(7));
        assertEquals(")", list.get(8));
    }
}