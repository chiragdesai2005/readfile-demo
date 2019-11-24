package com.test.file;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputValidatorTest {

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenArgsDoNotMatch() throws Exception {
        String[] args = new String[1];
        assertEquals("", InputValidator.validate(args));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenInvalidArgs() throws Exception {
        String[] args = new String[2];
        args[0] = "";
        assertEquals("", InputValidator.validate(args));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenInvalidThreadCount() throws Exception {
        String[] args = {"./tt.txt", "0"};
        assertEquals("", InputValidator.validate(args));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenStringThreadCount() throws Exception {
        String[] args = {"./tt.txt", "abc"};
        assertEquals("", InputValidator.validate(args));
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenFileNotFound() throws Exception {
        String[] args = {"./tt.txt", "2"};
        assertEquals("", InputValidator.validate(args));
    }
}
