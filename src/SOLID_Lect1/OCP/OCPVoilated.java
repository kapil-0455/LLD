package SOLID_Lect1.OCP;

import java.util.ArrayList;
import java.util.List;

class ProductSolved{
    String name;
    int price;

    public ProductSolved(String name, int price) {
        this.name = name;
        this.price = price;
    }
}


class ShoppingCart {
    private List<ProductSolved> products = new ArrayList<>();

    public void addProduct(ProductSolved p) {
        products.add(p);
    }

    public List<ProductSolved> getProducts() {
        return products;
    }

    // Calculates total price in cart.
    public double calculateTotal() {
        double total = 0;
        for (ProductSolved p : products) {
            total += p.price;
        }
        return total;
    }
}


class InvoicePrinter{
    private ShoppingCart cart;

    InvoicePrinter(ShoppingCart cart){
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


// OCP principle breaks we modify our code rather than make our class open for extensions
class ShoppingCartStorage {
    private ShoppingCart cart;

    public ShoppingCartStorage(ShoppingCart cart) {
        this.cart = cart;
    }

    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }

    public void saveInMongoDB(){
        System.out.println("Saved in MongoDb");
    }

    public void saveInCassendra(){
        System.out.println("Saved in Cassendra");
    }

}


public class OCPVoilated {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new ProductSolved("Laptop", 50000));
        cart.addProduct(new ProductSolved("Mouse", 2000));

        InvoicePrinter printer = new InvoicePrinter(cart);
        printer.printInvoice();

        ShoppingCartStorage db = new ShoppingCartStorage(cart);
        db.saveInMongoDB();
    }
}
