import org.example.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc;

    @BeforeEach
    public void setUp() {
        calc = new Calculator();   // выполнится ПЕРЕД каждым тестом
    }

    @Test
    public void testSumm() {
        int result = calc.sum(2, 3);   // calc уже создан, new не нужен!
        assertEquals(5, result);
    }

    @Test
    public void testSum() {

        int result = calc.sum(2, 3);
        assertEquals(5, result);
    }
        @Test
        public void testIsPositive() {

            assertTrue(calc.isPositive(5));    // 5 положительное → ожидаем true
            assertFalse(calc.isPositive(-3));  // -3 отрицательное → ожидаем false
        }
        @Test
    public void testmultiply() {

            int result = calc.multiply(2, 3);
            assertEquals(6, result);
    }
    @Test
    public void testDivide() {

        int result = calc.divide(6, 2);
        assertEquals(3, result);
    }
    @Test
    public void testDivideByZero() {

        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }
    }


