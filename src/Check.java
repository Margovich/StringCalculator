public class Check {
    public static void validInput(String str1, String str2, String sign) throws Exception {

        if (str1.replaceAll("\"", "").trim().length() > 10) {
            throw new IllegalArgumentException("Длина строки не должна превышать 10 символов.");
        }

        if (str2.replaceAll("\"", "").trim().length() > 10) {
            throw new IllegalArgumentException("Длина строки не должна превышать 10 символов.");
        }

        if (sign.equals("*") || sign.equals("/")) {
            if (str2.contains("\"")) throw new Exception("Для умножения и деления необходимо указать число");
        }

        if (isNumeric(str2)) {
            int i = Integer.parseInt(str2);
            if (1 > i || i > 10) {
                throw new Exception("Число должно быть от 1 до 10");
            }
        }
    }

    public static boolean isNumeric(String str2) {
        try {
            Double.parseDouble(str2);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}




