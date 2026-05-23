import model.*;
import strategy.*;
import adapter.*;
import observer.*;
import service.OrderService;

public class Main {
    public static void main(String[] args) {
        // 1. Crear productos
        Product p1 = new Product("Mortal Kombat 1", 100.0);
        Product p2 = new Product("Mortal Kombat 1: Khaos Reign", 20.0);

        // 2. Agregar productos al carrito
        Cart cart = new Cart();
        cart.addProduct(p1);
        cart.addProduct(p2);

        System.out.println("Subtotal en carrito: S/ " + cart.CalculateTotal());

        // 3. Aplicar estrategia de descuento
        OrderService orderService = new OrderService();
        // Usamos NoDiscountStrategy para mantener el monto de 120.0
        orderService.setDiscountStrategy(new NoDiscountStrategy());

        // Configuración de los observadores
        orderService.addObserver(new EmailNotificationObserver());
        orderService.addObserver(new InventoryObserver());
        orderService.addObserver(new AdminNotificationObserver());

        // 4. Procesar pago usando Tarjeta de Crédito (PayPal Adapter)
        PaymentProcessor creditCard = new CreditCardPaymentProcessor();
        double montoFinal = orderService.processPayment(cart, creditCard);

        // 5. Confirmar orden
        orderService.confirmOrder(montoFinal);

        // 6. Notificar observadores
        orderService.notifyAllObservers();
    }
}