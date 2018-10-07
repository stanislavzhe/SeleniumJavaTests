package HomeWork.lesson2HomeWork;

public class ArrayTest1and2 {
    public static void main(String[] args) {
//      Создайте массив из 15 случайных целых чисел из отрезка [0;9].
//      Выведите массив на экран. Подсчитайте сколько в массиве чётных элементов и
//      выведете это количество на экран на отдельной строке.
//      Создать метод, который будет сортировать указанный массив по возрастанию любым известным вам способом.

        int arrayLength = 15;
        int[] testArray = new int[arrayLength];
        int fromNumber = 0;
        int toNumber = 9;

        setArrayByRandomInt(testArray, fromNumber, toNumber);
        printArray(testArray);

        System.out.println("Amount of even elements in array: " + amountOfEvenInArray(testArray));

        sortArray(testArray);
        printArray(testArray);
    }

    public static int setRandomInt(int fromNumber, int toNumber) {
        int randomNumber = fromNumber + (int) (Math.round(Math.random() * toNumber));
        return randomNumber;
    }

    public static void setArrayByRandomInt(int[] array, int fromNumber, int toNumber) {
        for (int i = 0; i < array.length; i++) {
            array[i] = setRandomInt(fromNumber, toNumber);
        }
    }

    public static void printArray(int[] array) {
        System.out.print("Array: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        } else return false;
    }

    public static int amountOfEvenInArray(int[] array) {
        int amount = 0;
        for (int i = 0; i < array.length; i++) {
            if (isEven(array[i]) == true) {
                amount++;
            }
        }
        return amount;
    }

    public static boolean isFirstBiggerThanSecond(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber) {
            return true;
        } else return false;
    }

    public static void changeTwoElements(int[] array, int firstElementPosition, int secondElementPosition) {
        int intForChange = array[firstElementPosition];
        array[firstElementPosition] = array[secondElementPosition];
        array[secondElementPosition] = intForChange;
    }

    public static void sortArray(int[] array) {
        boolean isChanged = true;
        while (isChanged == true) {
            isChanged = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (isFirstBiggerThanSecond(array[i], array[i + 1])) {
                    changeTwoElements(array, i, i + 1);
                    isChanged = true;
                }
            }
        }
    }
}
