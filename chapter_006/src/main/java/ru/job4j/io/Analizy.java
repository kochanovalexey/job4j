package ru.job4j.io;

import java.io.*;
/**
 * Class Класс Analizy
 *
 * @author akochanov
 * @version 1
 * @since 25.11.2019
 */
public class Analizy {
    /**
     * Метод записывает промежутки времени, когда сервер был не доступен
     * @param source - источник данных
     * @param target - путь, куда будет записан результат метода
     */
    public void unavailable(String source, String target) {
        boolean unavailable = false;
        try (BufferedReader read = new BufferedReader(new FileReader(source));
            BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            String line;
            do {
                line = read.readLine();
                if (line == null) {
                    return;
                }
                String[] subStr = line.split(" ");
                if (unavailable) {
                    writer.write(subStr[1]);
                    writer.newLine();
                    unavailable = false;
                }
                if (subStr[0].equals("400") || subStr[0].equals("500")) {
                    writer.write(String.format(subStr[1].concat(";")));
                    unavailable = true;
                }

            } while (line != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("10:57:01;10:58:01");
            out.println("10:58:01;10:59:01");
            out.println("11:01:02;11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
