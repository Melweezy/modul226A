import org.junit.Test;

import static org.junit.Assert.*;

public class KontoTest {
    @Test
    public void einzahlenTest() {
        Konto konto1 = new Konto(100,"Meier","Hans", 1);
        konto1.einzahlen(100);
        assertNotEquals(konto1.getSaldo(),199);
    }
    @Test
    public void zinsTestLow(){
        Konto konto2 = new Konto(100,"Meier","Hans", 1);
        konto2.verzinsen(365);
        boolean isTrue = false;
        if(konto2.getSaldo() == 150) {
            isTrue = true;
        }
        assertTrue(isTrue);
    }
    @Test
    public void zinsTestHigh(){
        Konto konto3 = new Konto(500000,"Mister","Sister", 1);
        konto3.verzinsen(365);
        boolean isTrue = false;
        if(konto3.getSaldo() == 500000){
            isTrue = true;
        }
        assertTrue(isTrue);
    }
}