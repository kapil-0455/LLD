package Lect9Factory_Design.Factory_Method;

interface PaymentGateway {
    void pay(double amount);
}

class RazorpayUPI implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Razorpay UPI");
    }
}

class RazorpayCreditCard implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Razorpay Credit Card");
    }
}

class RazorpayNetBanking implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Razorpay Net Banking");
    }
}


class StripeUPI implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Stripe UPI");
    }
}

class StripeCreditCard implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Stripe Credit Card");
    }
}

class StripeNetBanking implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Stripe Net Banking");
    }
}

// --------- Making factory interface -------------
interface PaymentGatewayFactory{
    PaymentGateway createGateway(String paymentMethod);
}

class RazorpayFactory implements PaymentGatewayFactory {

    public PaymentGateway createGateway(String paymentMethod) {

        if(paymentMethod.equalsIgnoreCase("upi"))
            return new RazorpayUPI();

        else if(paymentMethod.equalsIgnoreCase("creditcard"))
            return new RazorpayCreditCard();

        else if(paymentMethod.equalsIgnoreCase("netbanking"))
            return new RazorpayNetBanking();

        return null;
    }
}

class StripeFactory implements PaymentGatewayFactory {

    @Override
    public PaymentGateway createGateway(String paymentMethod) {

        if(paymentMethod.equalsIgnoreCase("upi"))
            return new StripeUPI();

        else if(paymentMethod.equalsIgnoreCase("creditcard"))
            return new StripeCreditCard();

        else if(paymentMethod.equalsIgnoreCase("netbanking"))
            return new StripeNetBanking();

        return null;
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        PaymentGatewayFactory factory = new RazorpayFactory();
        PaymentGateway gateway = factory.createGateway("upi");

        if(gateway != null){
            gateway.pay(5000);
        }

    }
}
