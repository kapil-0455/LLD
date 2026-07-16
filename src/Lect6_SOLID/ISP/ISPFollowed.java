package Lect6_SOLID.ISP;

/**
  Interface Segregation Principle (ISP) states that a class should
  not be forced to implement methods it does not use.

 Instead of creating one large interface, split it into small, specific interfaces so that
 each class implements only the functionality it requires.
 **/




/// Interface for employees who can cook
interface Cook1 {
    void cookFood();
}

// Interface for employees who can serve customers
interface Serve1 {
    void serveCustomer();
}

// Interface for employees who can wash dishes
interface Clean1 {
    void washDishes();
}

// Chef only implements Cook1
class Chef1 implements Cook1 {

    @Override
    public void cookFood() {
        System.out.println("Chef is cooking food.");
    }
}

// Waiter only implements Serve1
class Waiter1 implements Serve1 {

    @Override
    public void serveCustomer() {
        System.out.println("Waiter is serving customers.");
    }
}

// Cleaner only implements Clean1
class Cleaner1 implements Clean1 {

    @Override
    public void washDishes() {
        System.out.println("Cleaner is washing dishes.");
    }
}

public class ISPFollowed {
    public static void main(String[] args) {

        Cook1 chef = new Chef1();
        Serve1 waiter = new Waiter1();
        Clean1 cleaner = new Cleaner1();

        chef.cookFood();
        waiter.serveCustomer();
        cleaner.washDishes();
    }
}