package model.entities;

public class Invoice {
    private Double basicPayment;
    private Double tax;
    
    //Builders
    public Invoice(){

    }

    public Invoice(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    //Encapsulators
    public Double getBasicPayment() {
        return basicPayment;
    }


    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }


    public Double getTax() {
        return tax;
    }


    public void setTax(Double tax) {
        this.tax = tax;
    }
    
    //Methods
    public Double totalPayment(){
        return basicPayment + tax;
    }
}
