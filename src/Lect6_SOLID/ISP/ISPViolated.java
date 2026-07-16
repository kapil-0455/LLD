package Lect6_SOLID.ISP;

// One interface for all restaurant employees (Violates ISP)
interface RestaurantEmployee {
    void cookFood();
    void serveCustomer();
    void washDishes();
}

// Chef only cooks, but is forced to implement other methods
class Chef implements RestaurantEmployee {

    @Override
    public void cookFood() {
        System.out.println("Chef is cooking food.");
    }

    @Override
    public void serveCustomer() {
        throw new UnsupportedOperationException("Chef does not serve customers.");
    }

    @Override
    public void washDishes() {
        throw new UnsupportedOperationException("Chef does not wash dishes.");
    }
}

// Waiter only serves customers
class Waiter implements RestaurantEmployee {

    @Override
    public void cookFood() {
        throw new UnsupportedOperationException("Waiter does not cook food.");
    }

    @Override
    public void serveCustomer() {
        System.out.println("Waiter is serving customers.");
    }

    @Override
    public void washDishes() {
        throw new UnsupportedOperationException("Waiter does not wash dishes.");
    }
}

// Cleaner only washes dishes
class Cleaner implements RestaurantEmployee {

    @Override
    public void cookFood() {
        throw new UnsupportedOperationException("Cleaner does not cook food.");
    }

    @Override
    public void serveCustomer() {
        throw new UnsupportedOperationException("Cleaner does not serve customers.");
    }

    @Override
    public void washDishes() {
        System.out.println("Cleaner is washing dishes.");
    }
}

public class ISPViolated {
    public static void main(String[] args) {

        RestaurantEmployee chef = new Chef();
        RestaurantEmployee waiter = new Waiter();
        RestaurantEmployee cleaner = new Cleaner();

        chef.cookFood();
        waiter.serveCustomer();
        cleaner.washDishes();

        try {
            chef.serveCustomer(); // Exception
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}