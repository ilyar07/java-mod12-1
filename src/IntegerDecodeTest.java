import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerDecodeTest {

    @Test
    public void testDecimal() {
        assertEquals(10, Integer.decode("10"));
    }

    @Test
    public void testNegativeDecimal() {
        assertEquals(-10, Integer.decode("-10"));
    }

    @Test
    public void testHexWith0x() {
        assertEquals(16, Integer.decode("0x10"));
    }

    @Test
    public void testHexWithHash() {
        assertEquals(16, Integer.decode("#10"));
    }

    @Test
    public void testOctal() {
        assertEquals(8, Integer.decode("010"));
    }

    @Test
    public void testPlusSign() {
        assertEquals(10, Integer.decode("+10"));
    }

    @Test
    public void testWrongSignPosition() {
        assertThrows(NumberFormatException.class, () -> {
            Integer.decode("0x-10");
        });
    }

    @Test
    public void testEmptyString() {
        assertThrows(NumberFormatException.class, () -> {
            Integer.decode("");
        });
    }
    @Test
    public void testTooLargeNumber() {
        assertThrows(NumberFormatException.class, () -> Integer.decode("999999999999999999999"));
    }
}