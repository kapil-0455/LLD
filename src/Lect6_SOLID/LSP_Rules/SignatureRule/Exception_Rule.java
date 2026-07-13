package Lect6_SOLID.LSP_Rules.SignatureRule;

class Parent3{
    public void getException() throws RuntimeException{
        throw new RuntimeException("Parent Error");
    }
}

class Child3 extends Parent3{
    public void getException() throws ArithmeticException{
        throw new ArithmeticException("Child exception");
    }
}

// it only takes those exception who are their subclass
class Client2 {
    private Parent3 p ;
    Client2(Parent3 p){
        this.p = p;
    }

    public void getValue(){
        try{
            p.getException();
        } catch (RuntimeException e) {
            System.out.println("RuntimeException occurred: " + e.getMessage());
        }
    }
}

public class Exception_Rule {
    public static void main(String[] args) {
        Parent3 par = new Parent3();
        Child3 child = new Child3();

        Client2 client = new Client2(child);
        client.getValue();

    }
}
