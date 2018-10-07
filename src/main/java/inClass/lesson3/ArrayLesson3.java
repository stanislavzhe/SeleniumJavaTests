package inClass.lesson3;

public class ArrayLesson3 {
    //      Создайте массив из 4 целых чисел
    //      Выведите массив на экран. Подсчитайте сколько в массиве чётных элементов
    private int [] testArray;

    public int[] getTestArray() {
        return testArray;
    }

    public void setTestArray(int[] testArray) {
        this.testArray = testArray;
    }

    public void printArray(int[] array) {
        System.out.print("Array: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public int amountOfEvenInArray() {
        int amount = 0;
        for (int i = 0; i < testArray.length; i++) {
            if (isEven(testArray[i])) {
                amount++;
            }
        }
        return amount;
    }
}
