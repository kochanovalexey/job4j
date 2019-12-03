package ru.job4j.io;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Class Класс Архивация проекта
 *
 * @author akochanov
 * @version 1
 * @since 02.12.2019
 */
public class Zip {
    /**
     * Метод архивирующий файлы
     * @param source - файлы для архивации
     * @param target - файл назначения
     */
    public void pack(List<File> source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : source) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод поиск файлов в директории
     * @param root - директория
     * @param ext - расширение исключения
     * @return - список найденных файлов
     */
    public List<File> seekBy(String root, String ext) {
        List<File> fileList = new ArrayList<>();
        File file = new File(root);
        ArrayDeque<File> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(file);
        while (!arrayDeque.isEmpty()) {
            File currentFile = arrayDeque.poll();
            if (currentFile.isDirectory()) {
                File[] listFiles = currentFile.listFiles();
                if (listFiles != null) {
                    arrayDeque.addAll(Arrays.asList(listFiles));
                }
                continue;
            }
            if (!checkExtensionFiles(currentFile, ext)) {
                fileList.add(currentFile);
            }
        }
        return fileList;
    }

    /**
     * Метод проверяет файл на конкретные расширения.
     * @param file - исходный файл
     * @param ext - спсиок расширений.
     * @return - результат проверки
     */
    private boolean checkExtensionFiles(File file, String ext) {
        String nameFile = file.getName();
        return nameFile.endsWith(ext);
    }

    public static void main(String[] args) {
        Args args1 = new Args(args);
        Zip zip = new Zip();
        List<File> fileList = zip.seekBy(args1.directory, args1.exclude);
        zip.pack(fileList, new File(args1.output));
    }

    private static class Args {
        /**
         * Директория
         */
        private String directory;
        /**
         * Расширения исключения
         */
        private String exclude;
        /**
         * Файл назначения
         */
        private String output;

        public Args(String[] args) {
            String params = "";
            for (String arg : args) {
                if (arg.equals("-d") || arg.equals("-e") || arg.equals("-o")) {
                    params = arg;
                    continue;
                }
                if (params.equals("-d")) {
                    this.directory = arg;
                } else if (params.equals("-e")) {
                    this.exclude = arg;
                } else if (params.equals("-o")) {
                    this.output = arg;
                }
            }
        }

        /**
         * Геттер directory
         * @return - directory
         */
        public String getDirectory() {
            return this.directory;
        }

        /**
         * Геттер exclude
         * @return - exclude
         */
        public String getExclude() {
            return this.exclude;
        }

        /**
         * Геттер output
         * @return - output
         */
        public String getOutput() {
            return this.output;
        }
    }
}
