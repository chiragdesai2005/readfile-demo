package com.test.file;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Collections.EMPTY_LIST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FileWriterTest {

    public static final String OUTPUT_TXT = "output.txt";

    @Before
    public void clean() {
        File f = new File("output.txt");
        if (f.exists()) {
            f.delete();
        }
    }

    @Test
    public void shouldDoNothingWithNullResultList() {
        FileWriter.writeFile(null);
        File f = new File("output.txt");
        assertEquals(f.exists(), false);
    }

    @Test
    public void shouldDoNothingWithEmptyResultList() {
        FileWriter.writeFile(EMPTY_LIST);
        File f = new File("output.txt");
        assertEquals(f.exists(), false);
    }

    @Test
    public void shouldDoNothingWithResultList() throws Exception {
        List<String> resultList = new ArrayList<>(2);
        resultList.add("ABC");
        resultList.add("XYZ");
        FileWriter.writeFile(resultList);
        File f = new File(OUTPUT_TXT);
        Stream<String> data = Files.lines(Paths.get(OUTPUT_TXT));
        assertEquals(f.exists(), true);
        assertNotNull(data);
        assertEquals(data.count(), 2);
    }

}