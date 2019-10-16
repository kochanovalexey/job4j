package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class Класс, тестурующий Analyze
 *
 * @author akochanov
 * @version 1
 * @since 15.10.2019
 */
public class AnalyzeTest {
    @Test
    public void testAnalyze() {
        Analyze analyze = new Analyze();

        List<Analyze.User> previous = new ArrayList<>();
        previous.add(new Analyze.User(1, "Alex"));
        previous.add(new Analyze.User(2, "Max"));
        previous.add(new Analyze.User(3, "Anna"));
        previous.add(new Analyze.User(4, "Jack"));
        previous.add(new Analyze.User(5, "Alexander"));
        previous.add(new Analyze.User(6, "Liza"));
        previous.add(new Analyze.User(7, "Bill"));
        previous.add(new Analyze.User(8, "Anabelle"));
        previous.add(new Analyze.User(9, "Steven"));
        previous.add(new Analyze.User(10, "Greg"));

        List<Analyze.User> current = new ArrayList<>();
        current.add(new Analyze.User(1, "Lola"));
        current.add(new Analyze.User(2, "Stefan"));
        current.add(new Analyze.User(3, "Anna"));
        current.add(new Analyze.User(4, "Jack"));
        current.add(new Analyze.User(11, "Leo"));
        current.add(new Analyze.User(12, "Jason"));
        current.add(new Analyze.User(13, "Kira"));
        current.add(new Analyze.User(14, "Alina"));
        current.add(new Analyze.User(15, "Kate"));
        current.add(new Analyze.User(16, "Jane"));
        current.add(new Analyze.User(17, "Josh"));

        Analyze.Info info = analyze.diff(previous, current);
        assertThat(info.added, is(7));
        assertThat(info.changed, is(2));
        assertThat(info.deleted, is(6));
    }
}