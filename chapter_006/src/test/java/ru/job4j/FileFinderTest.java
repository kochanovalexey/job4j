package ru.job4j;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 03.03.2020
 */
public class FileFinderTest {
    @Test
    public void whenSearchParamIsFullNameThenFoundedFile() {
        FileFinder fileFinder = new FileFinder();
        String root = "src/test/resources";
        String name = "testFile2";
        String searchParam = "-f";
        List<File> result = fileFinder.seekBy(root, name, searchParam);
        List<File> expected = new ArrayList<>();
        expected.add(new File("src/test/resources/fileFinder/test1/testFile2"));
        assertThat(result, is(expected));
    }

    @Test
    public void whenSearchParamIsFileNameThenFoundedFile() {
        FileFinder fileFinder = new FileFinder();
        String root = "src/test/resources";
        String name = "(.*)testFile1";
        String searchParam = "-m";
        List<File> result = fileFinder.seekBy(root, name, searchParam);
        List<File> expected = new ArrayList<>();
        expected.add(new File("src/test/resources/fileFinder/testFile1"));
        assertThat(result, is(expected));
    }

    @Test
    public void whenSearchParamIsRegularExpressionThenFoundedFile() {
        FileFinder fileFinder = new FileFinder();
        String root = "src/test/resources";
        String name = "(.*)testFile1";
        String searchParam = "-r";
        List<File> result = fileFinder.seekBy(root, name, searchParam);
        List<File> expected = new ArrayList<>();
        expected.add(new File("src/test/resources/fileFinder/test1/testFile1"));
        assertThat(result, is(expected));
    }
}
