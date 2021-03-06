package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class Класс ConsoleInput
 *
 * @author akochanov
 * @version 1
 * @since 10.04.2019
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Значение не соодержится в меню");
        }
        return key;
    }
}
