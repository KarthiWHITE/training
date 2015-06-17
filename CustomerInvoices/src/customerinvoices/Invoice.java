
package customerinvoices;

public class Invoice {
    
    private final Customer customer;
    
    private final Vehicle vehicle;
    
    private final double amount_total;
    
    private final Employee employee_assigned;
    
    public Invoice(Customer customer,Vehicle vehicle,Employee employee_assigned){
        this.customer=customer;
        this.vehicle=vehicle;
        this.amount_total=vehicle.getServiceCharge();
        this.employee_assigned=employee_assigned;
    }
    
    public void printInvoice(){
        customer.printCutomer();
        employee_assigned.printEmployee();
        vehicle.printVehicle();
                
    }
}
