package Lect8Startergic_Design;

// -------- Strategy Interface for Payment --------
interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Payment Strategies
class UPIPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI.");
    }
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}

class CashPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Cash.");
    }
}

// -------- Strategy Interface for Authentication --------
interface AuthenticationStrategy {
    void authenticate();
}

//Concrete Authentication Strategies
class OTPAuthentication implements AuthenticationStrategy {
    public void authenticate() {
        System.out.println("Authenticating using OTP...");
    }
}

class PINAuthentication implements AuthenticationStrategy {
    public void authenticate() {
        System.out.println("Authenticating using PIN...");
    }
}

class NoAuthentication implements AuthenticationStrategy {
    public void authenticate() {
        System.out.println("No Authentication Required.");
    }
}

// -------- Strategy Interface for Receipt --------
interface ReceiptStrategy {
    void sendReceipt();
}

//Concrete Receipt Strategies
class EmailReceipt implements ReceiptStrategy {
    public void sendReceipt() {
        System.out.println("Receipt sent via Email.");
    }
}

class SMSReceipt implements ReceiptStrategy {
    public void sendReceipt() {
        System.out.println("Receipt sent via SMS.");
    }
}

class NoReceipt implements ReceiptStrategy {
    public void sendReceipt() {
        System.out.println("Receipt not requested.");
    }
}

// -------- Base Payment Class --------
abstract class Payment {

    protected PaymentStrategy paymentStrategy;
    protected AuthenticationStrategy authenticationStrategy;
    protected ReceiptStrategy receiptStrategy;

    public Payment(PaymentStrategy paymentStrategy,
                   AuthenticationStrategy authenticationStrategy,
                   ReceiptStrategy receiptStrategy) {

        this.paymentStrategy = paymentStrategy;
        this.authenticationStrategy = authenticationStrategy;
        this.receiptStrategy = receiptStrategy;
    }

    public void makePayment(double amount) {
        authenticationStrategy.authenticate();
        paymentStrategy.pay(amount);
        receiptStrategy.sendReceipt();
    }

    public abstract void paymentType();
}

// -------- Online Payment --------
class OnlinePayment extends Payment {

    public OnlinePayment(PaymentStrategy paymentStrategy,
                         AuthenticationStrategy authenticationStrategy,
                         ReceiptStrategy receiptStrategy) {

        super(paymentStrategy, authenticationStrategy, receiptStrategy);
    }

    @Override
    public void paymentType() {
        System.out.println("Online Payment");
    }
}

// -------- Offline Payment --------
class OfflinePayment extends Payment {

    public OfflinePayment(PaymentStrategy paymentStrategy,
                          AuthenticationStrategy authenticationStrategy,
                          ReceiptStrategy receiptStrategy) {

        super(paymentStrategy, authenticationStrategy, receiptStrategy);
    }

    @Override
    public void paymentType() {
        System.out.println("Offline Payment");
    }
}

// -------- Main Class --------
public class StrategyDesignPattern {

    public static void main(String[] args) {

        Payment payment1 = new OnlinePayment(
                new UPIPayment(),
                new OTPAuthentication(),
                new EmailReceipt()
        );

        payment1.paymentType();
        payment1.makePayment(2500);

        System.out.println("-------------------------");

        Payment payment2 = new OfflinePayment(
                new CashPayment(),
                new NoAuthentication(),
                new NoReceipt()
        );

        payment2.paymentType();
        payment2.makePayment(1000);
    }
}