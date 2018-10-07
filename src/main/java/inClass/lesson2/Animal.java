package inClass.lesson2;

public class Animal {
    private String name;
    private int age;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void animalInfo (String name, int age) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    @Override
    public String toString() {
        return "inClass.lesson2.Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
