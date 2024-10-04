import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BankAccount {
    private final String accountNo;
    private final String holderName;
    private float balance;
    private Boolean isClosed;
    private Date accountStart;
    private Date accountEnd;

    private List<String> transactions;

    public BankAccount(String holderName) {
        this.accountNo = generateAccountNo();
        this.holderName = holderName;
        this.balance = 0.0f;

        if (transactions == null) {
            transactions = new ArrayList<>();
        }
    }

    public BankAccount(String holderName, Float balance) {
        this.accountNo = generateAccountNo();
        this.holderName = holderName;
        this.balance = balance;

        if (transactions == null) {
            transactions = new ArrayList<>();
        }
    }

    private String generateAccountNo() {
        int startAsciiNo = 65;
        int endAsciiNo = 90;
        int accountNoLength = 10;

        Random random = new Random();
        String accountNo = "";

        for(int i = 0; i < accountNoLength; i++) {
            int randomValue = startAsciiNo + (int) (random.nextFloat() * (endAsciiNo - startAsciiNo + 1));

            accountNo = accountNo + (char) randomValue;
        }
        return accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    // public void setAccountNo(String accountNo) {
    //     this.accountNo = accountNo;
    // }

    public String getHolderName() {
        return holderName;
    }

    // public void setHolderName(String holderName) {
    //     this.holderName = holderName;
    // }

    public float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public Date getAccountStart() {
        return accountStart;
    }

    public void setAccountStart(Date accountStart) {
        this.accountStart = accountStart;
    }

    public Date getAccountEnd() {
        return accountEnd;
    }

    public void setAccountEnd(Date accountEnd) {
        this.accountEnd = accountEnd;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "BankAccount [accountNo=" + accountNo + ", holderName=" + holderName + ", balance=" + balance
                + ", isClosed=" + isClosed + ", accountStart=" + accountStart + ", accountEnd=" + accountEnd + "]";
    }

    public void deposit(float amount) {
        if (!this.isClosed) {
            if (amount > 0.0f) {
                this.balance = this.balance + amount;

                transactions.add("deposit amount $" + amount + " at " + LocalDate.now().toString());
            } else {
                throw new IllegalArgumentException("Deposit amount cannot be less than $1.");
            }
        } else {
            throw new IllegalArgumentException("Account is closed. Transaction aborted");
        }

    }

    public void withdraw(float amount) {
        if (!this.isClosed) {
            if (amount <= this.balance) {
                this.balance = this.balance - amount;
            } else {
                throw new IllegalArgumentException("Withdrawal amount cannot be more than your bank balance.");
            }
        } else {
            throw new IllegalArgumentException("Account is closed. Transaction aborted");
        }
    }

    
}
