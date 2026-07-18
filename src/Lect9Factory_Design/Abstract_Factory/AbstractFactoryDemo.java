package Lect9Factory_Design.Abstract_Factory;

// -------------------- Product Interfaces --------------------

interface Payment {
    void pay(double amount);
}

interface Refund {
    void refund(double amount);
}

interface Invoice {
    void generateInvoice();
}

// -------------------- Razorpay Products --------------------

class RazorpayPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Razorpay.");
    }
}

class RazorpayRefund implements Refund {

    @Override
    public void refund(double amount) {
        System.out.println("Refunded ₹" + amount + " using Razorpay.");
    }
}

class RazorpayInvoice implements Invoice {

    @Override
    public void generateInvoice() {
        System.out.println("Generating Razorpay Invoice.");
    }
}

// -------------------- Stripe Products --------------------

class StripePayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Stripe.");
    }
}

class StripeRefund implements Refund {

    @Override
    public void refund(double amount) {
        System.out.println("Refunded ₹" + amount + " using Stripe.");
    }
}

class StripeInvoice implements Invoice {

    @Override
    public void generateInvoice() {
        System.out.println("Generating Stripe Invoice.");
    }
}

// -------------------- Abstract Factory --------------------

interface PaymentFactory {

    Payment createPayment();

    Refund createRefund();

    Invoice createInvoice();
}

// -------------------- Concrete Factories --------------------

class RazorpayFactory implements PaymentFactory {

    @Override
    public Payment createPayment() {
        return new RazorpayPayment();
    }

    @Override
    public Refund createRefund() {
        return new RazorpayRefund();
    }

    @Override
    public Invoice createInvoice() {
        return new RazorpayInvoice();
    }
}

class StripeFactory implements PaymentFactory {

    @Override
    public Payment createPayment() {
        return new StripePayment();
    }

    @Override
    public Refund createRefund() {
        return new StripeRefund();
    }

    @Override
    public Invoice createInvoice() {
        return new StripeInvoice();
    }
}

// -------------------- Main --------------------

public class AbstractFactoryDemo {

    public static void main(String[] args) {

        PaymentFactory factory = new RazorpayFactory();

        Payment payment = factory.createPayment();
        Refund refund = factory.createRefund();
        Invoice invoice = factory.createInvoice();

        payment.pay(5000);
        refund.refund(1000);
        invoice.generateInvoice();
    }
}
