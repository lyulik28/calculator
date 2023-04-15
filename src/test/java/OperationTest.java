import org.example.Calculator;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OperationTest {

    /*
    У JUnit 5 тести не обов'язково мають бути public
    var - локальний тип змінної (замість написання Calculator)

    Тест на перевірку окремої роботи функції plus
    При додаванні 324326.042 до 2648213.341 маємо отримати 2972539.383
    Придодаванні великого числа до максимального значення маємо отримати Double.POSITIVE_INFINITY
     */
    @Test
    void plusTest(){
        var calculator = new Calculator();
        assertEquals(2972539.383, calculator.plus(2648213.341,324326.042));
        assertEquals(Double.POSITIVE_INFINITY, calculator.plus(Double.MAX_VALUE,1e292));
    }

    /*
    Тест на перевірку окремої роботи функції minus
    При відніманні від 4 1521.8543 очікуванний результат -  -1517.8543
     */
    @Test
    void minusTest(){
        var calculator = new Calculator();
        assertEquals(-1517.8543, calculator.minus(4,1521.8543));
    }

    /*
    Тест на перевірку окремої роботи функції multiply
    -42.001 * 1.8543 = -77.88245429999999 - очікуємий результат
    0 * 1.8543 = 0 - очікуємий результат
     */
    @Test
    void multiplyTest(){
        var calculator = new Calculator();
        assertEquals(-77.88245429999999, calculator.multiply(-42.001,1.8543));
        assertEquals(0, calculator.multiply(0,1.8543));
    }

    /*
    Тест на перевірку окремої роботи функції divide
    -41.032 / 1.82 = 22.545054945054943 - очікуємий результат
    При діленні на 0, який є значенням double маємо отримувати POSITIVE_INFINITY,
    якщо друге число було від'ємном, то NEGATIVE_INFINITY
     */
    @Test
    void divideTest(){
        var calculator = new Calculator();
        assertEquals(22.545054945054943, calculator.divide(41.032,1.82));
        assertEquals(Double.POSITIVE_INFINITY, calculator.divide(41.032,0));
        assertEquals(Double.NEGATIVE_INFINITY, calculator.divide(-5,0));
    }
}
