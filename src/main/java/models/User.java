package models;

import java.util.List;

/**
 * Created by Stas on 07.10.2018.
 */
public class User {
    private String name;
    private int age;
    private List<String> messages;

    public User() {
    }

    //getters and setters

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

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
