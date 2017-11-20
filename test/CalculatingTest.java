import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatingTest {
    static final Calculating CALC = new Calculating();
    @Test
    public void addTest() {
        assertEquals(CALC.add(2,4), 6);
    }
}