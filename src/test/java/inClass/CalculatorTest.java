package inClass;

import inClass.lesson3.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    public static final int firstPositiveNumber = 10;
    public static final int secondPositiveNumber = 5;
    public static final int firstNegativeNumber = -10;
    public static final int secondNegativeNumber = -5;
    Calculator calculator;

    @Before //BeforeEach
    public void init(){
        calculator = new Calculator();
    }

    @Test
    public void verifyAddOfTwoPositiveNumbers() {
        int expectedSumma = 15;
        calculator.setFirstNumber(firstPositiveNumber);
        calculator.setSecondNumber(secondPositiveNumber);
        int actualSumma = calculator.addNumbers();
        Assert.assertEquals(expectedSumma, actualSumma);
    }

    @Test
    public void verifyDivisionOfTwoPositiveNumbers() {
        int expectedSumma = 2;
        calculator.setFirstNumber(firstPositiveNumber);
        calculator.setSecondNumber(secondPositiveNumber);
        int actualSumma = calculator.divideNumbers();
        Assert.assertEquals(expectedSumma, actualSumma);
    }

    @Test
    public void verifyMulitplicationOfTwoPositiveNumbers() {
        int expectedSumma = 50;
        calculator.setFirstNumber(firstPositiveNumber);
        calculator.setSecondNumber(secondPositiveNumber);
        int actualSumma = calculator.multiplyNumbers();
        Assert.assertEquals(expectedSumma, actualSumma);
    }

    @Test
    public void verifyAddOfTwoNegativeNumbers() {
        int expectedSumma = -15;
        calculator.setFirstNumber(firstNegativeNumber);
        calculator.setSecondNumber(secondNegativeNumber);
        int actualSumma = calculator.addNumbers();
        Assert.assertEquals(expectedSumma, actualSumma);
    }

    @After //afterEach
    public void close(){
        calculator = null;
    }
}
