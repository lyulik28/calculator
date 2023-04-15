import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.*;

public class OperationTwoTest {

    /*
    Тест перевіряє сумісну роботи функцій plus, divide, minus, multiply
    Очікуваний результат 70 порівюється із отриманим завдяки assertEquals
    У тесті перевіряється робота з int числами


     */

    @Test
    void calcInteger() throws Exception{
        var calculator = new Calculator();
        double expected = 70;
        double x1 = 1200;
        double x2 = 200;
        double x3 = 100;
        double x4 = 7;
        double x5 =  10;


        double res1 = calculator.plus(x1, x2);
        double res2 = calculator.divide(res1, x3);
        double res3 = calculator.minus(res2, x4);
        double res4 = calculator.multiply(res3, x5);

        assertEquals(expected, res4);
    }

    /*
    Тест перевіряє роботи функцій plus, divide, minus, multiply
    Очікуваний результат 223.1879 порівюється із отриманим завдяки assertEquals
    У тесті відбувається опрацювання double чисел
     */

    @Test
    void calcDouble() throws Exception{
        var calculator = new Calculator();
        double expected = 223.1878999999999;
        double x1 = 0.5;
        double x2 = 0.73;
        double x3 = 0.1;
        double x4 = 10.09;
        double x5 =  100.99;


        double res1 = calculator.plus(x1, x2);
        double res2 = calculator.divide(res1, x3);
        double res3 = calculator.minus(res2, x4);
        double res4 = calculator.multiply(res3, x5);

        assertEquals(expected, res4);
    }

    /*
    Тест роботи функцій plus, divide, minus, multiply
    Очікуваний результат NaN (фдже остання дія 0/0) порівюється із отриманим завдяки assertEquals
    У тесті перевіряється робота нулями
     */

    @Test
    void calcNull() throws Exception{
        var calculator = new Calculator();
        double expected = NaN;
        double x1 = Double.MAX_VALUE;
        double x2 = Double.MAX_VALUE;
        double x3 = 1238.2301943902;
        double x4 = 0;
        double x5 =  0;


        double res1 = calculator.minus(x1, x2);
        double res2 = calculator.plus(res1, x3);
        double res3 = calculator.multiply(res2, x4);
        double res4 = calculator.divide(res3, x5);

        assertEquals(expected, res4);
    }
}
