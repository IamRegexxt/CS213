interface Payable {
    // Interface for objects that can be paid, defines getPaymentAmount method
    double getPaymentAmount();
}
interface Discountable {
    // Interface for objects that can receive discounts, defines getDiscount method
    double getDiscount(double discountRate);
}

class Invoice implements Payable, Discountable {
    // Unique invoice number
    private String invoiceNumber;
    // Vendor name
    private String vendorName;
    // Invoice amount
    private double amount;

    public Invoice(String invoiceNumber, String vendorName, double amount) {
        // Constructor to initialize invoice details
        this.invoiceNumber = invoiceNumber;
        this.vendorName = vendorName;
        this.amount = amount;
    }

    public String getInvoiceNumber() {
        // Get invoice number
        return invoiceNumber;
    }

    public String getVendorName() {
        // Get vendor name
        return vendorName;
    }

    @Override
    public double getPaymentAmount() {
        // Returns invoice amount for payment
        return amount;
    }

    @Override
    public double getDiscount(double discountRate) {
        // Calculates discount based on rate and invoice amount
        return amount * discountRate;
    }
}

class PurchaseOrder extends Invoice {
    // Purchase order number
    private String poNumber;

    public PurchaseOrder(String invoiceNumber, String vendorName, double amount, String poNumber) {
        // Constructor to initialize purchase order details
        super(invoiceNumber, vendorName, amount); // Call parent constructor
        this.poNumber = poNumber;
    }

    public String getPoNumber() {
        // Get purchase order number
        return poNumber;
    }
}

class PayrollEntry implements Payable {
    // Employee ID
    private String employeeId;
    // Employee name
    private String employeeName;
    // Gross pay for employee
    private double grossPay;

    public PayrollEntry(String employeeId, String employeeName, double grossPay) {
        // Constructor to initialize payroll entry details
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.grossPay = grossPay;
    }

    public String getEmployeeId() {
        // Get employee ID
        return employeeId;
    }

    public String getEmployeeName() {
        // Get employee name
        return employeeName;
    }

    @Override
    public double getPaymentAmount() {
        // Returns gross pay for payment
        return grossPay;
    }
}
public class AccountsPayable {

    public static void main(String[] args) {
        Invoice invoice = new Invoice("INV123", "Acme Inc.", 1000.0);
        PurchaseOrder po = new PurchaseOrder("PO456", "XYZ Corp", 500.0, "PO-123");
        PayrollEntry payroll = new PayrollEntry("EMP001", "John Doe", 2000.0);

        Payable[] payables = {invoice, po, payroll};

        // Polymorphism: Process each payable object
        for (Payable payable : payables) {
            // Access methods based on the actual object type
            if (payable instanceof Invoice) {
                Invoice invoiceInstance = (Invoice) payable;
                System.out.println("Invoice Number: " + invoiceInstance.getInvoiceNumber());
                System.out.println("Vendor Name: " + invoiceInstance.getVendorName());
            } else if (payable instanceof PurchaseOrder) {
                PurchaseOrder poInstance = (PurchaseOrder) payable;
                System.out.println("Purchase Order Number: " + poInstance.getPoNumber());
            } else if (payable instanceof PayrollEntry) {
                PayrollEntry payrollInstance = (PayrollEntry) payable;
                System.out.println("Employee ID: " + payrollInstance.getEmployeeId());
                System.out.println("Employee Name: " + payrollInstance.getEmployeeName());
            }

            System.out.println("Payment Amount: ₱" + payable.getPaymentAmount());
            if (payable instanceof Discountable) { // Check if discount applicable
                double discount = ((Discountable) payable).getDiscount(0.1); // Downcast and call specific method
                System.out.println("Discount: ₱" + discount);
                System.out.println("Net Amount: ₱" + (payable.getPaymentAmount() - discount));
            }
            System.out.println("------------------");
        }
    }
}