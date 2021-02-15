import org.junit.Test;

import static org.junit.Assert.*;

public class GreetingsTest {
    @Test
    public void GreetingsTextIsNotNull() {
        Greetings intro = new Greetings();
        assertNotNull(intro.greetingsText());
    }

    @Test
    public void GreetingsTextTest(){
        Greetings intro = new Greetings();
        assertEquals(intro.greetingsText(),"Willkommen zu Mastermind \n Ein Code aus vier Farben ist zu knacken \n Die Farben sind blue, red, green, yellow, black und white " +
                "\n Hinweise zur Positionierung ->  p: Perfekt || o: Vorhaben || f: False");
    }
}