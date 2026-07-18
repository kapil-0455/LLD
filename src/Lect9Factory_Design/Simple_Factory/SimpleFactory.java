package Lect9Factory_Design.Simple_Factory;


interface PaymentGateWay{
    void processPayment(double amount);
}

class RazorPay implements PaymentGateWay{
    public void processPayment(double payment){
        System.out.println("Pay via RazorPay : " + payment);
    }
}

class PayPal implements PaymentGateWay{
    public void processPayment(double payment){
        System.out.println("Pay via PayPal : " + payment);
    }
}

class Stripe implements PaymentGateWay{
    public void processPayment(double payment){
        System.out.println("Pay via Stripe : " + payment);
    }
}

class PaymentGatewayFactory{
    public static PaymentGateWay createGateway(String type){
        if(type.equalsIgnoreCase("Razorpay") ) return new RazorPay();
        else if(type.equalsIgnoreCase("Paypal") ) return new PayPal();
        else if(type.equalsIgnoreCase("Stripe") )  return new Stripe();
        else {
            System.out.println("Invalid Payment gateway type!");
            return null;
        }

    }

}


public class SimpleFactory {
    public static void main(String[] args) {
        PaymentGateWay gateWay = PaymentGatewayFactory.createGateway("papal");
        if(gateWay != null){
            gateWay.processPayment(5000);
        }

    }
}
