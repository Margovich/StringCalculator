import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Запишите выражение в формате: \"строка\" пробел \"знак : +, -, *, /\" пробел \"строка\" при + и -, число при * и /\". Примеры: \"строка\" + \"строка\", \"строка\" * число");
        String input = sc.nextLine();
        System.out.println(Calculate.calculate(input));
    }
}



