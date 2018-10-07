package models;

public class Account {
    private String firstCutomerName;
    private String secondCutomerName;
    private String email;
    private String password;

    public String getFirstCutomerName() {
        return firstCutomerName;
    }

    public void setFirstCutomerName(String firstCutomerName) {
        this.firstCutomerName = firstCutomerName;
    }

    public String getSecondCutomerName() {
        return secondCutomerName;
    }

    public void setSecondCutomerName(String secondCutomerName) {
        this.secondCutomerName = secondCutomerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
