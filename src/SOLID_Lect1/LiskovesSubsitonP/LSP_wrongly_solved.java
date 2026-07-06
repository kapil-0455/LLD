package SOLID_Lect1.LiskovesSubsitonP;



import java.util.ArrayList;
import java.util.List;

interface BankAccount1{
    void deposit(double amount);
    void withDraw(double amount);

}

class SavingAccount1 implements BankAccount1{
    private double balance;

    SavingAccount1(){
        balance = 0;
    }


    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount credited to your Account");
    }

    @Override
    public void withDraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
    }
}

class CurrentAccount1 implements BankAccount1{
    private double balance;

    CurrentAccount1(){
        balance = 0;
    }


    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Current Account. New Balance: " + balance);
    }

    @Override
    public void withDraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Current Account!");
        }
    }
}

class FixedAccount1 implements BankAccount1{
    private double balance;

    public FixedAccount1() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Fixed Term Account. New Balance: " + balance);
    }


    @Override
    public void withDraw(double amount) {
        throw new UnsupportedOperationException("Withdrawal not allowed in Fixed Term Account!");
    }
}

// In this we change logic in client side not from our side
class BankClient1 {
    private List<BankAccount1> accounts;

    public BankClient1(List<BankAccount1> accounts) {
        this.accounts = accounts;
    }

    public void processTransactions() {
        for (BankAccount1 acc : accounts) {
            acc.deposit(1000);

            // Checking account type explicitly
            if (acc instanceof FixedAccount) {
                System.out.println("Skipping withdrawal for Fixed Term Account.");
            } else {
                try {
                    acc.withDraw(500);
                } catch (UnsupportedOperationException e) {
                    System.out.println("Exception: " + e.getMessage());
                }
            }
        }
    }
}
public class LSP_wrongly_solved {

    public static void main(String[] args) {
        List<BankAccount1> accounts = new ArrayList<>();
        accounts.add(new CurrentAccount1());
        accounts.add(new SavingAccount1());
        accounts.add(new FixedAccount1());

        BankClient1 client = new BankClient1(accounts);
        client.processTransactions();
    }
}
