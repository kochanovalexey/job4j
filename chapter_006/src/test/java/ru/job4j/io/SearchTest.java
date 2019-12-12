package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Class Класс
 *
 * @author akochanov
 * @version 1
 * @since 01.12.2019
 */
public class SearchTest {
    @Test
    public void whenDirectoryContainFilesWithSpecificExtension() {
        Search search = new Search();
        List<String> exts = new ArrayList<>();
        exts.add("png2");
        exts.add("jpg2");
        List<File> result = search.files(System.getProperty("java.io.tmpdir").concat("java"), exts);
        ListIterator<File> listIterator = result.listIterator();
        assertThat(listIterator.hasNext(), is(true));
        assertThat(listIterator.next().getName(), is("file1.png2"));
        assertThat(listIterator.hasNext(), is(true));
        assertThat(listIterator.next().getName(), is("file2.png2"));
        assertThat(listIterator.hasNext(), is(true));
        assertThat(listIterator.next().getName(), is("file3.jpg2"));
        assertThat(listIterator.hasNext(), is(false));
    }
}
