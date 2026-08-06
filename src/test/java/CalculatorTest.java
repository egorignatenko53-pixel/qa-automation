import org.example.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
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
    @ParameterizedTest
    @ValueSource(ints = {5, 100, 7, 999, 1,34,23})
    public void testIsPositiveMany(int number) {
        assertTrue(calc.isPositive(number));
    }
    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "10, 20, 30",
            "0, 0, 0",
            "100, 1, 101"
    })
    public void testSumMany(int a, int b, int expected) {
        assertEquals(expected, calc.sum(a, b));
    }
    @ParameterizedTest
    @CsvSource({
            "10,2,5",
            "20,4,5",
            "9,3,3",
            "18,3,6"
    })
    public void testDevideMany(int a, int b, int expected) {
        assertEquals(expected, calc.divide(a, b));
    }
    }


