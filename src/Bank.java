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
    public void removeCustomer(String customerId){
        if(customers.isEmpty()){
            System.out.println("There are no customer registered!");
            return;
        }
        for (Customer c: customers){
            if(c.getCustomerId().equals(customerId)){
                customers.remove(c);
                System.out.println("Successfully removed "+ c.getCustomerName());
                return;
            }
        }
        System.out.println("Customer not found!");
        return;
    }
    public Customer getCustomer(String costumerId){
        if(customers.isEmpty()){
            System.out.println("There are no customer registered!");
            return null;
        }
        for (Customer c: customers){
            if(c.getCustomerId().equals(costumerId)){
                System.out.println("Sucessfully found customer " + costumerId);
                return c;
            }
        }
        System.out.println("Customer not found!");
        return null;
    }
    public void displayAlCustomers(){
        if(customers.isEmpty()){
            System.out.println("There are no customer registered!");
            return;
        }
        for (Customer c: customers){
            c.displayCustomerInfo();
        }
        System.out.println("Total Number of Customers Registered: " + customers.size());
    }
    public Account findAccountByNumber(String accountNumber){

    }
}
