package SOLID_Lect1.SRP;


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

// ShopingCart has only one responsiblity to calcuate the things
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

// InvoicePrinter has only one responsilblity to Print the Invoice
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


// 3. ShoppingCartStorage: Only responsible for saving cart to DB
class ShoppingCartStorage {
    private ShoppingCart cart;

    public ShoppingCartStorage(ShoppingCart cart) {
        this.cart = cart;
    }

    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }
}




public class SRPValid {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new ProductSolved("Laptop" , 10000));
        cart.addProduct(new ProductSolved("Mobile" , 34000));

        InvoicePrinter printer = new InvoicePrinter(cart);
        printer.printInvoice();


        ShoppingCartStorage storage = new ShoppingCartStorage(cart);
        storage.saveToDatabase();
    }
}
