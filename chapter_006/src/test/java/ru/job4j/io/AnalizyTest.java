package ru.job4j.io;

import org.junit.Test;

import java.util.List;
import java.util.ListIterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {

    @Test
    public void whenServerHaveUnavailableTime() {
        String pathLog = "./data/server.log";
        Analizy analizy = new Analizy();
        List<String> result = analizy.getUnavailablePeriods(pathLog);
        ListIterator<String> listIterator = result.listIterator();
        assertThat(listIterator.hasNext(), is(true));
        assertThat(listIterator.next(), is("10:57:01;10:58:01"));
        assertThat(listIterator.hasNext(), is(true));
        assertThat(listIterator.next(), is("10:58:01;10:59:01"));
        assertThat(listIterator.hasNext(), is(true));
        assertThat(listIterator.next(), is("11:01:02;11:02:02"));
        assertThat(listIterator.hasNext(), is(false));
    }


}