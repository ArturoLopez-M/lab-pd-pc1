package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
private final List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public double CalculateTotal(){
       double total = 0.0;
       for (Product product : products){
           total += product.getPrice();
       }
       return total;
    }

    public List<Product>getProducts(){
        return products;
    }
}
