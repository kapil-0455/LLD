package Lect6_SOLID.LSP_Rules.SignatureRule;


class Car{

}

class BMW extends Car{

}

class Parent1{
    public Car getCar(){
        System.out.println("Parent Car is Calling");
        return new Car();
    }
}

// in this rule return type must be same or it must be its base class
class Child1 extends Parent1{
    public Car getCar(){
        System.out.println("Child Car is Calling");
        return new BMW();
    }
}

class Client1{
    private Parent1 p ;
    Client1(Parent1 p){
        this.p = p;
    }

    public void getMsg(){
        p.getCar();
    }
}

public class ReturnType_Rule {
    public static void main(String[] args) {
        Parent1 par = new Parent1();
        Child1 child = new Child1();

        Client1 client1 = new Client1(child);
        client1.getMsg();

    }
}
