public class Calculate {
    public static String calculate(String input) throws Exception {

        String[] parts;
        String sign;

        if (input.contains(" + ")) {
            parts = input.split(" \\+ ");
            sign = "+";
        } else if (input.contains(" - ")) {
            parts = input.split(" \\- ");
            sign = "-";
        } else if (input.contains(" * ")) {
            parts = input.split(" \\* ");
            sign = "*";
        } else if (input.contains(" / ")) {
            parts = input.split(" \\/ ");
            sign = "/";
        } else {
            throw new Exception("Указан неправильный знак");
        }

        String str1 = parts[0];
        String str2 = parts[1];
        if (parts.length != 2) {
            throw new IllegalArgumentException("Необходимо указать 3 элемента.");
        }

        String str2Beginning = str2.substring(0, 1);
        String str2End = String.valueOf(str2.charAt(str2.length() - 1));

        Check.validInput(str1, str2, sign);

        str1 = str1.replaceAll("\"", "").trim();
        str2 = str2.replaceAll("\"", "").trim();
        String quot = "\"";


        switch (sign) {
            case "+":
                if (str2Beginning.equals(quot) & str2End.equals(quot)) {
                    String result = str1 + str2;
                    return cut(result);
                } else if (!str2Beginning.equals("\"") | !str2End.equals("\"")) {
                    if (str2.matches("\\d")) {
                        throw new IllegalArgumentException("Для сложения необходимо указать строку");
                    } else {
                        throw new IllegalArgumentException("Укажите второе выражение в кавычках");
                    }
                }

            case "-":
                if (str2Beginning.equals(quot) & str2End.equals(quot)) {

                    int index = str1.indexOf(str2);
                    if (index == -1) {
                        String result = str1; dsdsdsds
                        return cut(result);
                    } else {
                        String result = str1.substring(0, index);
                        result = result + str1.substring(index + str2.length());
                        return cut(result);

                    }
                } else if (!str2Beginning.equals("\"") | !str2End.equals("\"")) {
                    if (str2.matches("\\d")) {
                        throw new IllegalArgumentException("Для вычитания необходимо указать строку");
                    } else {
                        throw new IllegalArgumentException("Укажите второе выражение в кавычках");

                    }
                }

            case "*":
                if (!str2.matches("\\d*")) {
                    throw new IllegalArgumentException("Для умножения необходимо указать число.");
                } else {
                    int multiplier = Integer.parseInt(str2);
                    String result = str1.repeat(multiplier);
                    return cut(result);
                }

            case "/":
                if (!str2.matches("\\d*")) {
                    throw new IllegalArgumentException("Для деления необходимо указать число.");
                } else {
                    int divisor = Integer.parseInt(str2);
                    if (divisor == 0) {
                        throw new IllegalArgumentException("Деление на ноль невозможно.");
                    } else {
                        int newLength = str1.length() / divisor;
                        String result = str1.substring(0, Math.min(newLength, str1.length())).trim();
                        return cut(result);
                    }
                }
        }

        return input;
    }

    private static String cut(String cut) {
        if (cut.length() > 40) {
            return "\"" + cut.substring(0, 40) + "...\"";
        }
        return "\"" + cut + "\"";
    }

}

