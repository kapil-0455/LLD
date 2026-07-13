package Lect6_SOLID.LSP_Rules.SignatureRule;


class Parent{
    public void doSomething(String str){
        System.out.println("Parent : " + str);
    }
}

// child arguments must be same as parent class
class Child extends Parent{
    public void doSomething(String str){
        System.out.println("Child : " + str);
    }
}

class Client{
    private Parent p ;

    Client(Parent p){
        this.p = p;
    }

    public void printMsg(){
        p.doSomething("Study");
    }

}
public class Method_argument {
    public static void main(String[] args) {
        Parent par = new Parent();
        Child child = new Child();

        Client client = new Client(child);
        client.printMsg();
    }
}
