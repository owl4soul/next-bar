package bar.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tools {

    public static String readString() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String inputString = reader.readLine();
            return inputString;
        } catch (IOException e) {
            System.out.println("ОШИБКА ПРИ ВВОДЕ СТРОКИ!");
            e.printStackTrace();
        }
        return null;

    }

    public static Integer readInteger() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int inputInteger = reader.read();
            return inputInteger;
        } catch (IOException e) {
            System.out.println("ОШИБКА ПРИ ВВОДЕ ЧИСЛА!");
            e.printStackTrace();
        }
        return null;

    }
}
