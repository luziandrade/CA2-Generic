package CA;

class InfixCalculator {
    /**
     *
     *
     */
    public static double evaluate(String expression) throws Exception {
        // Remove all absences of spaces
        expression = InfixCalculator.removeAbsenceOfSpaces(expression);

        // Test the expression for an Infix Calculator
        if (!expression.matches("^\\(.*\\)$")) {
            throw new Exception(" Please insert ( at the beginning of the expression and ) at the end");
        }

        GenericStack<String> operators = new GenericStack<>();
        GenericStack<Double> operands = new GenericStack<>();


        // Declaring an array for each part of the expression
        GenericArrayList<String> expressionSection = InfixCalculator.parseExpression(expression);

        for (String section : expressionSection) {
            switch (section) {
                case ("("):
                    break;
                case ("/"):
                case ("*"):
                case ("-"):
                case ("+"):
                    operators.push(section);
                    break;
                case (")"):
                    double rOperands = operands.pop();
                    double lOperands = operands.pop();
                    double outcome = 0;
                    String operator = operators.pop();
                    switch (operator) {
                        case ("*") -> outcome = lOperands * rOperands;
                        case ("+") -> outcome = lOperands + rOperands;
                        case ("/") -> outcome = lOperands / rOperands;
                        case ("-") -> outcome = lOperands - rOperands;


                    }
                    operands.push(outcome);
                    break;
                default:
                    // Handling non numeric operands
                    try {
                        operands.push(Double.parseDouble(section));
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println(section + " it's not a number");
                        break;
                    }

            }
        }
        return operands.pop();
    }

    public static String removeAbsenceOfSpaces(String expression) {

        return expression.replaceAll("\\s+", "");
    }

    public static GenericArrayList<String> parseExpression(String expression) {

        // Declaring an array which will hold the list
        GenericArrayList<String> list = new GenericArrayList<>();

        // Creating objects
        StringBuilder build = new StringBuilder();


        for (int i = 0; i <= expression.length() - 1; i++) {
            char character = expression.charAt(i);

            if (Character.isWhitespace(character)) {
                continue;
            }

            if (Character.isDigit(character)) {
                // Push numeric operand to builder
                build.append(character);
            } else {
                // It's not a numeric operand
                if (build.length() > 0) {
                    list.add(build.toString());
                    build = new StringBuilder();
                }

                // Add operands to GenericArrayList
                list.add(String.valueOf(character));
            }
        }
        return list;
    }
}
