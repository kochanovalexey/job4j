package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        List<String> listPeriod = getUnavailablePeriods(source);
        writeUnavailablePeriods(listPeriod, target);
    }

    /**
     * Метод, возвращающий периоды недоступности сервера
     * @param source - путь к файлу
     * @return - список недоступных периодов
     */
    public List<String> getUnavailablePeriods(String source) {
        List<String> listPeriod = new ArrayList<>();
        String time = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;
            do {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                String[] subStr = line.split(" ");
                if (time != "") {
                    time = time.concat(subStr[1]);
                    listPeriod.add(time);
                    time = "";
                }
                if (subStr[0].equals("400") || subStr[0].equals("500")) {
                    time = subStr[1].concat(";");
                }
            } while (line != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPeriod;
    }

    /**
     * Метод, записывающий периоды недоступности сервера
     * @param listPeriod - спсиок периодов
     * @param target - путь к файлу
     */
    private void writeUnavailablePeriods(List<String> listPeriod, String target) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            for (String time: listPeriod) {
                writer.write(time);
                writer.newLine();
            }
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
