package paymentmethod;

public class PaymentController {
	 private PaymentMethod paymentMethod;
	    private PaymentValidator validator;
	    private TransactionLogger logger = new TransactionLogger();

	    public PaymentController(PaymentMethod paymentMethod, PaymentValidator validator) {
	        this.paymentMethod = paymentMethod;
	        this.validator = validator;
	    }

	    public void processPayment(double amount) {
	        if (validator.validatePaymentDetails()) {
	            paymentMethod.pay(amount);
	            logger.logTransaction(paymentMethod.getClass().getSimpleName(), amount);
	        } else {
	            System.out.println("Falha na validação do pagamento.");
	        }
	    }

}
