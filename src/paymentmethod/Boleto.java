package paymentmethod;

public class Boleto implements PaymentMethod {
	
    public void pay(double amount) {
        System.out.println("Pagando R$ " + amount + " com boleto.");
    }
}
