package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 18.07.2019
 */
public class SchoolTest {

    List<Student> students = List.of(
            new Student(22),
            new Student(90),
            new Student(1),
            new Student(8),
            new Student(67),
            new Student(43),
            new Student(99),
            new Student(12),
            new Student(54),
            new Student(76),
            new Student(73),
            new Student(23),
            new Student(26)
    );

    @Test
    public void whenAllListStudentsThenListStudentsWithScoreFrom70To100() {
        School school = new School();
        List<Student> result = school.collect(students, student -> student.score >= 70 && student.score <= 100);
        List<Student> expected = List.of(
                students.get(1),
                students.get(6),
                students.get(9),
                students.get(10)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenAllListStudentsThenListStudentsWithScoreFrom50To70() {
        School school = new School();
        List<Student> result = school.collect(students, student -> student.score >= 50 && student.score < 70);
        List<Student> expected = List.of(
                students.get(4),
                students.get(8)
        );
        assertThat(result, is(expected));
    }

    @Test
    public void whenAllListStudentsThenListStudentsWithScoreFrom0To50() {
        School school = new School();
        List<Student> result = school.collect(students, student -> student.score >= 0 && student.score < 50);
        List<Student> expected = List.of(
                students.get(0),
                students.get(2),
                students.get(3),
                students.get(5),
                students.get(7),
                students.get(11),
                students.get(12)
        );
        assertThat(result, is(expected));
    }
}
