package paymentmethod;

public class CreditCardValidator implements PaymentValidator{

    public boolean validatePaymentDetails() {
        System.out.println("Validando detalhes do cartão de crédito...");
        // Aqui entrariam verificações de número de cartão, CVV, data de validade, etc.
        return true;  // Simplificação para exemplo
    }
}
