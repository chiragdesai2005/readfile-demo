package com.test.file;

import org.junit.Test;

import static com.test.file.FileEncryptor.cipher;
import static org.junit.Assert.assertEquals;

public class FileEncryptorTest {

    @Test
    public void shouldDoNothingWithEmptyString() {
        assertEquals("", cipher("", 3));
    }

    @Test
    public void shouldNotCipherSymbols() {
        assertEquals("-", cipher("-", 3));

        String symbols = "1!@#$%^&*(){}/";
        assertEquals(symbols, cipher(symbols, 3));
    }

    @Test
    public void shouldCipherLowerCaseLetter() {
        assertEquals("a", cipher("a", 0));

        assertEquals("b", cipher("a", 1));
        assertEquals("d", cipher("a", 3));
        assertEquals("j", cipher("e", 5));

        assertEquals("a", cipher("z", 1));
        assertEquals("c", cipher("x", 5));
    }

    @Test
    public void shouldCipherUpperCaseLetter() {
        assertEquals("A", cipher("A", 0));

        assertEquals("B", cipher("A", 1));
        assertEquals("D", cipher("A", 3));
        assertEquals("J", cipher("E", 5));

        assertEquals("A", cipher("Z", 1));
        assertEquals("C", cipher("X", 5));
        assertEquals("Z", cipher("C", -3));
    }

    @Test
    public void shouldCipherWholeAlphabet() {
        String allChars = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        assertEquals("QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD",
                cipher(allChars, -3));
    }

    @Test
    public void shouldCycle() {
        assertEquals("aoeu-snth", cipher("aoeu-snth", 52));
        assertEquals("cqgw-upvj", cipher("aoeu-snth", 54));
    }

    @Test
    public void shouldDecipher() {
        String s = "aoeu";

        String encrypted = cipher(s, 2);

        assertEquals(s, cipher(encrypted, -2));
    }
}
