import java.util.ArrayList;
public class Bank {
    private String bankName;
    private ArrayList <Customer> customers;

    public Bank (String bankName){
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
        System.out.println("Successfully added "+ customer.getCustomerName());

    }

}
