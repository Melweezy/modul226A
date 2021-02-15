import org.junit.Test;

import static org.junit.Assert.*;

public class MasterMindTest {
    @Test
    public void GreetingsTextIsNotNull() {
        Greetings GreetingsClass = new Greetings();
        assertNotNull(GreetingsClass.greetingsText());
    }
    @Test
    public void DeclaredSequenceIsNotNull() {
        assertNotNull(MasterMind.declareSequence());
    }
    @Test
    public void ChecksIfInputIsCorrect() {
        assertEquals(true, MasterMind.inputCheck("rbgw"));
    }
    @Test
    public void FeedbackForGuess() {
        assertTrue(MasterMind.feedback("rbbb", new char[]{'r', 'b', 'b', 'b'}));
    }
}