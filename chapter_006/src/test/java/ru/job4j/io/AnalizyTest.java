package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {

    @Test
    public void whenServerHaveUnavailableTime() {
        String pathLog = "./data/server.log";
        String pathUnavailable = "./data/unavailable.csv";
        Analizy analizy = new Analizy();
        analizy.unavailable(pathLog, pathUnavailable);
    }


}