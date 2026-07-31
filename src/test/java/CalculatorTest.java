import org.example.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testSum() {
        Calculator calc = new Calculator();
        int result = calc.sum(2, 3);
        assertEquals(5, result);
    }
        @Test
        public void testIsPositive() {
            Calculator calc = new Calculator();
            assertTrue(calc.isPositive(5));    // 5 положительное → ожидаем true
            assertFalse(calc.isPositive(-3));  // -3 отрицательное → ожидаем false
        }
    }


