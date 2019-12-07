package ru.job4j.io;

import java.io.File;
import java.util.*;

/**
 * Class Класс Сканирование файловой системы
 *
 * @author akochanov
 * @version 1
 * @since 29.11.2019
 */
public class Search {
    /**
     * Метод возвращает список всех файлов с конкретным расширением.
     * @param parent - путь до каталога, с которого нужно осуществлять поиск.
     * @param exts - расширения файлов, которые мы хотим получить.
     * @return - список всех файлов с конкретным расширением
     */
    List<File> files(String parent, List<String> exts) {
        List<File> files = new ArrayList<>();
        File file = new File(parent);
        ArrayDeque<File> deque = new ArrayDeque<>();
        deque.add(file);
        while (!deque.isEmpty()) {
            File currentFile = deque.poll();
            if (currentFile.isDirectory()) {
                File[] listFiles = currentFile.listFiles();
                if (listFiles != null) {
                    deque.addAll(Arrays.asList(listFiles));
                }
                continue;
            }
            if (checkExtensionFiles(currentFile, exts)) {
                files.add(currentFile);
            }
        }
        return files;
    }

    /**
     * Метод проверяет файл на конкретные расширения.
     * @param file - исходный файл
     * @param exts - спсиок расширений.
     * @return - результат проверки
     */
    private boolean checkExtensionFiles(File file, List<String> exts) {
        String nameFile = file.getName();
        return exts.stream().anyMatch(ext -> nameFile.endsWith(ext));
    }
}


