package paymentmethod;

public class Main {

	public static void main(String[] args) {

		Checkout checkout = new Checkout(new CreditCard());
		checkout.processPayment(100.0);

		checkout = new Checkout(new PayPal());
		checkout.processPayment(200.0);

		checkout = new Checkout(new Boleto());
		checkout.processPayment(300.0);

		PaymentMethod creditCard = new CreditCard();
		PaymentValidator creditCardValidator = new CreditCardValidator();

		PaymentController creditPayment = new PaymentController(creditCard, creditCardValidator);
		creditPayment.processPayment(150.0);

		PaymentMethod debit = new Debit();
		PaymentController debitPayment = new PaymentController(debit, (PaymentValidator) debit);
		debitPayment.processPayment(200.0);

		Debit debito = new Debit();
		debito.pay(100.0); // Usa o método com um parâmetro
		debito.pay(200.0, "Pagamento de Aluguel");

	}

}
