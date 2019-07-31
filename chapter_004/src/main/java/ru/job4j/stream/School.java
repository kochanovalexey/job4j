package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class Класс School
 *
 * @author akochanov
 * @version 1
 * @since 18.07.2019
 */
public class School {
    /**
     * Метод фильтрующий список учеников
     * @param students - список учеников
     * @param predict - predict
     * @return - отфильтрованный список учеников
     */
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }
    /**
     * Метод Преобразующий список студентов в карту
     * @param students - список студентов
     * @return - карта студентов
     */
    Map<String, Student> collectToMap(List<Student> students) {
        return students.stream().collect(
                Collectors.toMap(
                        s -> s.getSurname(),
                        s -> s
                ));
    }

    /**
     * Метод, возращающий список студентов, у которых балл выше bound
     * @param students - список студентов
     * @param bound - граница
     * @return - список студентов с балом выше bound
     */
    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .sorted(new StudentComparator().reversed())
                .flatMap(Stream::ofNullable)
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());
    }

    class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getScore() - o2.getScore();
        }
    }
}
