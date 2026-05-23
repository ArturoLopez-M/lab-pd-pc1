package service;

import model.Cart;
import strategy.DiscountStrategy;
import observer.OrderObserver;
import adapter.PaymentProcessor;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private DiscountStrategy discountStrategy;
    private final List<OrderObserver> observers;


    public OrderService() {
        this.observers = new ArrayList<>();
    }


    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }


    public double processPayment(Cart cart, PaymentProcessor paymentProcessor) {
        double total = discountStrategy.applyDiscount(cart.CalculateTotal());
        paymentProcessor.pay(total);
        return total;
    }


    public void confirmOrder(double total) {
        System.out.println("Compra confirmada por: S/ " + total);
    }


    public void notifyAllObservers() {
        for (OrderObserver observer : observers) {
            observer.update("Orden procesada exitosamente");
        }
    }
}
