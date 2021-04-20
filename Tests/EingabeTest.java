import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;

import static org.junit.Assert.*;

public class EingabeTest {

    @Test
    public void readInt() {
        StringBufferInputStream s = new StringBufferInputStream("10");
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(s));

        assertEquals(10, Eingabe.readInt(consoleInput));

    }
    @Test
    public void readChar() {
        StringBufferInputStream s = new StringBufferInputStream("r1d121234");
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(s));

        assertEquals('r', Eingabe.readChar(consoleInput));
    }

}