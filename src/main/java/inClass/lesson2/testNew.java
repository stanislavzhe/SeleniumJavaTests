package inClass.lesson2;

import java.util.*;

public class testNew {

    public static void main(String[] args) {
//        System.out.println("I want to be the best AQA");
//
//        Scanner keyboard = new Scanner(System.in);
//        System.out.print("Enter first number: ");
//        int a = keyboard.nextInt();
//        System.out.print("Enter second number: ");
//        int b = keyboard.nextInt();
//        int sum = a + b;
//        System.out.println("Sum of " + a + " + " + b + " = " + sum);
//
//        System.out.println("sum: " + culc(a,b));
//        System.out.println("substraction: " + substraction(a,b));
//        System.out.println("substraction: " + substraction(b,a));
//
//        System.out.println();
//        keyboard = new Scanner(System.in);
//        System.out.print("Enter first number: ");
//        String name = keyboard.nextLine();
//        System.out.println("My name is " + name + "!");
//
//        inClass.lesson2.testNew nova = new inClass.lesson2.testNew();
//
//        inClass.lesson2.Animal newCat = new inClass.lesson2.Animal();
//        newCat.setName("Barsic");
//        System.out.println("Name: " + newCat.getName());
//        newCat.setAge(2);
//        System.out.println("Age: " + newCat.getAge());
//        newCat.setColor("Gray");
//        System.out.println("Color: " + newCat.getColor());
//
//        System.out.println(newCat.toString());
//
//        inClass.lesson2.Animal.animalInfo(newCat.getName(),newCat.getAge());
//
//        int[] numbers = new int[10];
//
//        int[] numbersTwo = {3, 5, 1, 8};
//
//        int sum = 0;
//        for (int element : numbersTwo
//                ) {
//            sum += element;
//        }
//        System.out.println("Sum of numbers: " + sum);
//
//        List <Integer> numbersThree = new ArrayList <Integer> ();
//        numbersThree.add(1);
//        numbersThree.add(2);
//        numbersThree.add(3);
//        numbersThree.add(4);
//        System.out.println("List: " + numbersThree.toString());

        Set <Integer> setNumbers = new HashSet<Integer>();
        setNumbers.add(3);
        setNumbers.add(2);
        setNumbers.add(2);
        setNumbers.add(1);
        setNumbers.add(4);
        System.out.println(setNumbers.toString());

        for (Integer number: setNumbers
             ) {
            System.out.print(number + " ");
        }
    }

    public static int culc(int fisrtNumber, int secondNumber) {
        int sum = fisrtNumber + secondNumber;
        return sum;
    }

    public static int substraction(int fisrtNumber, int secondNumber) {
        int sub = fisrtNumber - secondNumber;
        return sub;
    }


}
