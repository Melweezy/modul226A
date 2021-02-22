import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class KontoTest {

    Konto konto1;
    Konto konto2;

    @Before
    public void setUp(){
        konto1 = new Konto(100,"Meier","Hans", 1);
        konto2 = new Konto(500000,"Mister","Sister", 1);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void einzahlenTest() {
        konto1.einzahlen(100);
        assertNotEquals(konto1.getSaldo(),199);
    }
    @Test
    public void einzahlenTestNegativ(){
        konto1.einzahlen(-100);
        assertEquals(konto1.getSaldo(), 100,0);
    }
    @Test
    public void abhebenTest() {
        konto2.abheben(499998);

        assertEquals(konto2.getSaldo(), 0, 0);
    }
    @Test
    public void abhebenTestNegativ() {
        konto1.abheben(-100);
        assertEquals(konto1.getSaldo(), 100, 0);
    }
    @Test
    public void abhebenTestNull() {
        konto1.abheben(0);
        assertEquals(konto1.getSaldo(),100,0);
    }
    @Test
    public void zinsTestLow(){
        konto1.verzinsen(365);
        boolean isTrue = false;
        if(konto1.getSaldo() == 150) {
            isTrue = true;
        }
        assertTrue(isTrue);
    }
    @Test
    public void zinsTestHigh(){
        konto2.verzinsen(365);
        boolean isTrue = false;
        if(konto2.getSaldo() == 500000){
            isTrue = true;
        }
        assertTrue(isTrue);
    }
}