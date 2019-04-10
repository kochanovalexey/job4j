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
        return scanner.next();
    }
}
