package paymentmethod;

public class PayPal implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Pagando R$ " + amount + " via PayPal.");
    }
}
