package HomeWork.HW3;

import HomeWork.lesson2HomeWork.BankAccount;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BankAccountHW3 {
    BankAccount accountForTest;
    public static final double doubleBalance = 9.9;
    public static final double intBalance = 10;
    public static final double zeroBalance = 0;
    public static final double negativeBalance = -1.1;
    public static final double negativeToZeroBalanceAdd = 1.1;
    public static final double negativeToPositiveBalanceAdd = 2.2;
    public static final double emptyBalance = 0.0;
    public static final double doubleSumForAdd = 9.9;
    public static final double intSumForAdd = 10;
    public static final double zeroSumForAdd = 0;
    public static final double negativeSumForAdd = -1;
    public static final double startBalanceToWithdraw = 10;
    public static final double doubleBalanceToWithdraw = 5.1;
    public static final double intBalanceToWithdraw = 5;
    public static final double zeroBalanceToWithdraw = 0;
    public static final double negativeBalanceToWithdraw = -1;
    public static final double withdrawToZeroBalance = 9.9;

//    Из предыдущего ДЗ: Создать класс BankAccount который будет иметь два поля
//    accountNumber и balance. Реализовать в классе методы setBalance() который будет задавать баланс ,
//    credit() метод должен начислять средства на счет, debit() - снимать средства со  счета.
//    Реализовать условие что если сумма снятия меньше чем остаток на счету - вывести сообщение :
//    “Сумма снятия больше чем остаток на счету!” . Создать обьект класса и проверить работу программы. Покрыть код юнит тестами

    @Before //BeforeEach
    public void init() {
        accountForTest = new BankAccount();
    }

    //account number
    @Test
    public void verifyNewAccountNumberIncreasesByOne() {
        int expectedAccountNumber = accountForTest.getAccountNumber() + 1;
        BankAccount oneMoreBankAccount = new BankAccount();
        int actualAccountNumber = oneMoreBankAccount.getAccountNumber();
        assertEquals(expectedAccountNumber, actualAccountNumber);
    }

    //balance when account created
    @Test
    public void verifyEmptyBalanceIfCreateNewAccount() {
        double expectedBalance = 0.0;
        accountForTest.setBalance(emptyBalance);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }


    //set balance
    @Test
    public void verifySetDoubleBalance() {
        double expectedBalance = 9.9;
        accountForTest.setBalance(doubleBalance);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }

    @Test
    public void verifySetIntBalance() {
        double expectedBalance = 10;
        accountForTest.setBalance(intBalance);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }

    @Test
    public void verifySetZeroBalance() {
        double expectedBalance = 0;
        accountForTest.setBalance(zeroBalance);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }

    @Test
    public void verifySetNegativeBalance() {
        double expectedBalance = -1.1;
        accountForTest.setBalance(negativeBalance);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }


    //credit to balance
    @Test
    public void verifyDoubleCreditToAdd() {
        double expectedBalance = 9.9;
        accountForTest.credit(doubleSumForAdd);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }

    @Test
    public void verifyIntCreditToAdd() {
        double expectedBalance = 10;
        accountForTest.credit(intSumForAdd);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }

    @Test
    public void verifyZeroCreditToAdd() {
        double expectedBalance = 0;
        accountForTest.credit(zeroSumForAdd);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }

    @Test
    public void verifyNegativeCreditToAdd() {
        double expectedBalance = 0;
        accountForTest.credit(negativeSumForAdd);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }

    @Test
    public void verifyCreditFromNegativeToZeroBalance() {
        double expectedBalance = 0;
        accountForTest.setBalance(negativeBalance);
        accountForTest.credit(negativeToZeroBalanceAdd);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }

    @Test
    public void verifyCreditFromNegativeToPositiveBalance() {
        double expectedBalance = 1.1;
        accountForTest.setBalance(negativeBalance);
        accountForTest.credit(negativeToPositiveBalanceAdd);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }


    //debit from balance
    @Test
    public void verifyDoubleToWithdraw() {
        accountForTest.setBalance(startBalanceToWithdraw);
        double expectedBalance = 4.9;
        accountForTest.debit(doubleBalanceToWithdraw);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }

    @Test
    public void verifyIntToWithdraw() {
        accountForTest.setBalance(startBalanceToWithdraw);
        double expectedBalance = 5;
        accountForTest.debit(intBalanceToWithdraw);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }

    @Test
    public void verifyZeroToWithdraw() {
        accountForTest.setBalance(startBalanceToWithdraw);
        double expectedBalance = 10;
        accountForTest.debit(zeroBalanceToWithdraw);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }

    @Test
    public void verifyNegativeToWithdraw() {
        accountForTest.setBalance(startBalanceToWithdraw);
        double expectedBalance = 10;
        accountForTest.debit(negativeBalanceToWithdraw);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }

    @Test
    public void verifyWithdrawToZeroBalance() {
        accountForTest.setBalance(doubleBalance);
        double expectedBalance = 0;
        accountForTest.debit(withdrawToZeroBalance);
        double actualBalance = accountForTest.getBalance();
        assertEquals(expectedBalance, actualBalance, 0);
    }

    @After //afterEach
    public void close() {
        accountForTest = null;
    }
}
