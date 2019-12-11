package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 07.12.2019
 */
public class ConsoleChat {

    /**
     * Конец работы
     */
    private boolean endOfChat;

    /**
     * Продолжить чат
     */
    private boolean continueChat = true;

    /**
     * Список сообщений от пользователя
     */
    private List<String> log = new ArrayList<>();

    /**
     * Метод ввода
     */
    private void input() {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
        log.add(inputString);
        this.endOfChat = inputString.equals("закончить");
        this.continueChat = continueChat ? !inputString.equals("стоп") : inputString.equals("продолжить");
        if (endOfChat) {
            writeLog();
        }
    }

    /**
     * Метод вывода
     */
    private void output() {
        try(BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("java.io.tmpdir").concat("answer")))) {
            Object[] answers = reader.lines().toArray();
            Random random = new Random();
            System.out.println(answers[random.nextInt(answers.length - 1)]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод записи
     */
    public void writeLog() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(System.getProperty("java.io.tmpdir").concat("ConsoleChat")))) {
            for (String line : log) {
                writer.write(line);
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Init метод
     */
    private void init() {
        while (!endOfChat) {
            input();
            if (!endOfChat && this.continueChat) {
                output();
            }
        }
    }

    public static void main(String[] args) {
        new ConsoleChat().init();
    }
}
