package SOLID_Lect1.SRP;

import java.util.ArrayList;
import java.util.List;

public class SingleResposiblityPrincipleVOILATION
{

    // This is a bad practise cart handels all the work
    public static void main(String[] args) {
        Cart cart = new Cart();

        cart.addProduct(new Product(10000 , "Laptop"));
        cart.addProduct(new Product(34000, "Mobile"));

        cart.generateInvoice();
        cart.save();
    }
}
class Product{
    String name;
    int price;

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
    }
}

class Cart{
    private List<Product> list = new ArrayList<>();

    public void addProduct(Product product){
        list.add(product);
    }

    public List<Product> getAllProducts(){
        return list;
    }

    public void generateInvoice(){
        System.out.println("genertae the Invoice");
        for(Product p : list){
            System.out.println(p.name + " " + "Rs : " + p.price );
        }

        System.out.println("Total: Rs " + calculateTotal());
    }

    private int calculateTotal() {
        int total = 0;
        for(Product p : list){
            total += p.price;
        }

        return total;
    }

    public void save(){
        System.out.println("Save the poduct in Database");
    }


}
