package adapter;

public class CreditCardPaymentProcessor implements PaymentProcessor{

    @Override
    public void pay(double amount) {
        System.out.println("Pago realizado con Tarjeta de Credito: PEN " + amount);
    }
}
