package ru.job4j;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Class Класс FileFinder
 *
 * @author akochanov
 * @version 1
 * @since 11.02.2020
 */
public class FileFinder {

    /**
     * Запись результата в лог
     * @param source - найденные файлы
     * @param target - лог-файл
     */
    public void writeToLog(List<File> source, String target) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            for (File file : source) {
                writer.write(file.getAbsolutePath());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод поиск файлов в заданой директории
     * @param root - директория поиска
     * @param name - имя файла, маска или регулярное выражение для поиска
     * @param searchParam - параметр поиска
     * @return - найденные файлы
     */
    public List<File> seekBy(String root, String name, String searchParam) {
        List<File> fileList = new ArrayList<>();
        File file = new File(root);
        ArrayDeque<File> deque = new ArrayDeque();
        deque.add(file);
        while (!deque.isEmpty()) {
            File currentFile = deque.poll();
            if (currentFile.isDirectory()) {
                File[] listFiles = currentFile.listFiles();
                deque.addAll(Arrays.asList(listFiles));
                continue;
            }
            if (checkFileByCondition(currentFile, name, searchParam)) {
                fileList.add(currentFile);
            }
        }
        return fileList;
    }

    /**
     * Проверка на соответствие файла условию
     * @param currentFile - файл
     * @param name - имя файла, маска или регулярное выражение
     * @param searchParam - параметр поиска
     * @return - резуьтат сравнения
     */
    public boolean checkFileByCondition(File currentFile, String name, String searchParam) {
        boolean result = false;
        if (searchParam.equals("-m")) {
            return currentFile.getName().matches(name);
        } else if (searchParam.equals("-f")) {
            return name.equals(currentFile.getName());
        } else if (searchParam.equals("-r")) {
            Pattern pattern = Pattern.compile(currentFile.getName());
            return pattern.matcher(name).find();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Args args1 = new Args(args);
        if (args1.checkFields()) {
            throw new Exception("Не все ключи заполнены!");
        }
        FileFinder fileFinder = new FileFinder();
        List<File> fileList = fileFinder.seekBy(args1.directory, args1.name, args1.searchParam);
        fileFinder.writeToLog(fileList, args1.output);
    }

    /**
     * Класс ключей
     */
    private static class Args {
        /**
         * Директория поиска
         */
        private String directory;
        /**
         * Имя файла, маска или регулярное выражение
         */
        private String name;
        /**
         * Параметр поиска
         */
        private String searchParam;
        /**
         * Лог-файл
         */
        private String output;

        public Args(String[] args) {
            String params = "";
            for (String arg : args) {
                if (arg.equals("-m") || arg.equals("-f") || arg.equals("-r")) {
                    searchParam = arg;
                    continue;
                }
                if (arg.equals("-d") || arg.equals("-n") || arg.equals("-o")) {
                    params = arg;
                    continue;
                }
                if (params.equals("-d")) {
                    this.directory = arg;
                } else if (params.equals("-n")) {
                    this.name = arg;
                } else if (params.equals("-o")) {
                    this.output = arg;
                }
            }
        }

        public String getDirectory() {
            return this.directory;
        }

        public String getName() {
            return name;
        }

        public String getSearchParameter() {
            return searchParam;
        }

        public String getOutput() {
            return output;
        }

        /**
         * Проверка заполненности ключей
         * @return - результат проверки
         */
        public boolean checkFields() {
            return !(this.directory.isEmpty() || this.name.isEmpty() || this.searchParam.isEmpty() || this.output.isEmpty());
        }
    }
}
