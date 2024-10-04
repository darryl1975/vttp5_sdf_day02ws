public class App {
    public static void main(String[] args) {

        BankAccount fredAccount = new BankAccount("Fred");
        fredAccount.deposit(100.0f);

        BankAccount juneAccount = new BankAccount("June", 500.0f);

        fredAccount.toString();
        juneAccount.toString();
        juneAccount.withdraw(550.0f);
        juneAccount.withdraw(100.0f);
        fredAccount.deposit(100.0f);
        fredAccount.toString();
        juneAccount.toString();

        FixedDeposit deenDepositAccount = new FixedDeposit("Deen", 10000.0f);
        deenDepositAccount.withdraw(1000.0f);
        deenDepositAccount.deposit(1000000.0f);
        deenDepositAccount.showAccountInfo();

    }
}
