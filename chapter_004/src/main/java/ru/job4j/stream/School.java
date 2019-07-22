package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        return students.stream().distinct().collect(
                Collectors.toMap(
                        s -> s.getSurname(),
                        s -> s
                ));
    }
}
