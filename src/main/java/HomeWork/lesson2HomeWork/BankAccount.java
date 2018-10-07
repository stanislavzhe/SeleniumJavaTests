package HomeWork.lesson2HomeWork;

public class BankAccount {
//  Создать класс BankAccount который будет иметь два поля 	accountNumber и balance.
//  Реализовать в классе методы setBalance() который будет задавать баланс , credit()
//  метод должен начислять средства на счет, debit() - снимать средтва со  счета.
//  Реализовать условие что если сумма снятия меньше чем остаток на счету - вывести сообщение :
//  “Сумма снятия больше чем остаок на счету!” . Создать обьект класса и проверить работу программы.


    private static int accountNumber = 0;
    private double balance;

    public BankAccount() {
        accountNumber++;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void credit(double sumToAdd) {
        if (sumToAdd < 0) {
            System.out.println("Сумма взноса не может быть отрицательной");
        } else balance += sumToAdd;
    }

    public void debit(double sumToWithdraw) {
        if (sumToWithdraw < 0) {
            System.out.println("Сумма снятия не может быть отрицательной");
        } else if (balance < sumToWithdraw) {
            System.out.println("Сумма снятия больше чем остаок на счету!");
        } else balance -= sumToWithdraw;
    }
}
