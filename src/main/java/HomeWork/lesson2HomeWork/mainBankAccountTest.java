package HomeWork.lesson2HomeWork;

public class mainBankAccountTest {
    public static void main(String[] args) {
        BankAccount newAccount = new BankAccount();
        System.out.println("Start Balance: " + newAccount.getBalance());
        newAccount.setBalance(9.9);
        System.out.println("Account: " + newAccount.getAccountNumber());
        System.out.println("Start Balance: " + newAccount.getBalance());

        newAccount.credit(10.1);
        System.out.println("Balance after add sum: " + newAccount.getBalance());
        newAccount.debit(20.1);//error message shown
        System.out.println("Balance after error: " + newAccount.getBalance());
        newAccount.debit(20);
        System.out.println("Balance after withdraw: " + newAccount.getBalance());

        newAccount.credit(-10);
        System.out.println("Balance after add negative sum: " + newAccount.getBalance());
        newAccount.debit(-20);
        System.out.println("Balance after withdraw negative sum: " + newAccount.getBalance());
    }
}
