package paymentmethod;

public class TransactionLogger {
    public void logTransaction(String paymentType, double amount) {
        System.out.println("Transação logada: " + paymentType + " R$ " + amount);
    }

}
