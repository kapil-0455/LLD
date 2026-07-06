package SOLID_Lect1.LiskovesSubsitonP;


import java.util.ArrayList;
import java.util.List;

interface BankAccount{
    void deposit(double amount);
    void withDraw(double amount);

}

class SavingAccount implements BankAccount{
    private double balance;

    SavingAccount(){
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

class CurrentAccount implements BankAccount{
    private double balance;

    CurrentAccount(){
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

class FixedAccount implements BankAccount{
    private double balance;

    public FixedAccount() {
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


class BankClient {
    private List<BankAccount> accounts;

    public BankClient(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public void processTransactions() {
        for (BankAccount acc : accounts) {
            acc.deposit(1000);  // All accounts allow deposits

            // Assuming all accounts support withdrawal (LSP Violation)
            try {
                acc.withDraw(500);
            } catch (UnsupportedOperationException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
public class Liskovs_wrongly_implemented {

    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new FixedAccount());
        accounts.add(new CurrentAccount());
        accounts.add(new SavingAccount());

        BankClient client = new BankClient(accounts);
        client.processTransactions();
    }

}
