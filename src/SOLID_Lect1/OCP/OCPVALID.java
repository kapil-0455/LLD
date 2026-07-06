package SOLID_Lect1.OCP;


import java.util.ArrayList;
import java.util.List;

class ProductSolved1{
    String name;
    int price;

    public ProductSolved1(String name, int price) {
        this.name = name;
        this.price = price;
    }
}


class ShoppingCart2{
    private List<ProductSolved1> products = new ArrayList<>();

    public void addProduct(ProductSolved1 p) {
        products.add(p);
    }

    public List<ProductSolved1> getProducts() {
        return products;
    }

    // Calculates total price in cart.
    public double calculateTotal() {
        double total = 0;
        for (ProductSolved1 p : products) {
            total += p.price;
        }
        return total;
    }
}


class InvoicePrinter2{
    private ShoppingCart cart;

    InvoicePrinter2(ShoppingCart cart){
        this.cart = cart;
    }

    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for (ProductSolved p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotal());
    }
}


// Now we make interface so we can any extension in future when we want
interface Persistence {
    void save(ShoppingCart2 cart);
}
class SQLPersistence implements Persistence {
    @Override
    public void save(ShoppingCart2 cart) {
        System.out.println("Saving shopping cart to SQL DB...");
    }
}

class MongoPersistence implements Persistence {
    @Override
    public void save(ShoppingCart2 cart) {
        System.out.println("Saving shopping cart to MongoDB...");
    }
}
public class OCPVALID {
    public static void main(String[] args) {
        ShoppingCart2 cart2 = new ShoppingCart2();

        cart2.addProduct(new ProductSolved1("Laptop", 50000));
        cart2.addProduct(new ProductSolved1("Mouse", 2000));


        Persistence storage1 = new MongoPersistence();
        storage1.save(cart2);

    }
}
