package paymentmethod;

public class CreditCard implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Pagando R$ " + amount + " com cartão de crédito.");
    }

}
