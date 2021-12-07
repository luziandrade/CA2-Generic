package CA;

import java.util.*;

public class InfixCalculatorTester {
    public static void main(String[] args) throws Exception {
        System.out.println("Insert expression (Infix):");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        System.out.println("Result: " + InfixCalculator.evaluate(expression));
    }
}

