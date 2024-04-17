package paymentmethod;

public class Debit implements PaymentMethod, PaymentValidator {
    @Override
    public void pay(double amount) {
        pay(amount, "Pagamento padrão");
    }

    // Método sobrecarregado com um parâmetro adicional
    public void pay(double amount, String description) {
        if (validatePaymentDetails()) {
            System.out.println(description + ": Debitando R$ " + amount + " da conta bancária.");
        } else {
            System.out.println("Falha na validação dos detalhes da conta bancária.");
        }
    }

    @Override
    public boolean validatePaymentDetails() {
        System.out.println("Validando detalhes da conta bancária...");
        return true;
    }
}
