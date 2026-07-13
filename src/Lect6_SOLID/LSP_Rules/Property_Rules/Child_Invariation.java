package Lect6_SOLID.LSP_Rules.Property_Rules;

class Account{
    protected double balance;

    Account(double b){
        if(b < 0) throw new IllegalArgumentException("Balance cannot be negative");
        balance = b;
    }

    public void withDraw(double amount) {
        if (balance - amount < 0) throw new RuntimeException("Insufficient funds");
        balance -= amount;
        System.out.println("Amount withdrawn. Remaining balance is " + balance);
    }

}

// int this class it override the fxn it voilate the condition written in Parent
class FarziAccount extends Account{
    FarziAccount(double balance){
        super(balance);
    }

    public void withDraw(double amount) {
        balance -= amount;
        System.out.println("Amount withdrawn. Remaining balance is " + balance);
    }
}
public class Child_Invariation {
    public static void main(String[] args) {
        Account bankAccount = new Account(1000);
        bankAccount.withDraw(100);
    }
}
