package inClass.lesson3;

import inClass.lesson3.ArrayLesson3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayLesson3Test3 {
    ArrayLesson3 array;
    public static final int[] noEvenNumbersInArray = {1, 3, 5, 7};
    public static final int[] oneEvenNumberInArray = {1, 3, 5, 6};

    @Before
    public void init() {
        array = new ArrayLesson3();
    }

    @Test
    public void verifyNoEvenNumbersInArrey() {
        int expectedNumberOfEvenNumbersInArray = 0;
        array.setTestArray(noEvenNumbersInArray);
        int actualEvenNumbersInArray = array.amountOfEvenInArray();
        Assert.assertEquals(expectedNumberOfEvenNumbersInArray, actualEvenNumbersInArray);
    }

    @Test
    public void verifyOneEvenNumberInArrey() {
        int expectedNumberOfEvenNumbersInArray = 1;
        array.setTestArray(oneEvenNumberInArray);
        int actualEvenNumbersInArray = array.amountOfEvenInArray();
        Assert.assertEquals(expectedNumberOfEvenNumbersInArray, actualEvenNumbersInArray);
    }
}
