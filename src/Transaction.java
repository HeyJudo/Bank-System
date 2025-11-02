import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private LocalDateTime date;
    private String transactionType;
    private double amount;
    private String description;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Transaction(String transactionType, double amount, String description) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.description = description;
    }

    public String getTransactionType(){
        return this.transactionType;
    }
    public double getAmount (){
        return this.amount;
    }
    public LocalDateTime getDate(){
        return this.date;
    }
    public String getDescription(){
        return this.description;
    }
    public void displayTransaction(){
        System.out.println("======= TRANSACTION DETAILS =======");
        System.out.printf("[%s]\n", this.date.format(formatter));
        System.out.println("Transaction Type: " + this.transactionType);
        System.out.println("Amount: " + this.amount);
        System.out.println("Description: " + this.description);
        System.out.println("===================================");
    }
}
