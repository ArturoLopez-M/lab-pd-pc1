package strategy;

public class FixedAmountDiscountStrategy implements DiscountStrategy {
    private double amount;

    public FixedAmountDiscountStrategy(double amount) {
        this.amount = amount;
    }

    @Override
    public double applyDiscount(double total) {
        return Math.max(0.0, total - amount);
    }
}
