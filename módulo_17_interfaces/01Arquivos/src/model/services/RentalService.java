package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;

    private TaxServer taxService;

    //Builders
    public RentalService(){

    }

    public RentalService(Double pricePerHour, Double pricePerDay, TaxServer taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    //Encapsulators
    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public TaxServer getTaxService() {
        return taxService;
    }

    public void setTaxService(TaxServer taxService) {
        this.taxService = taxService;
    }

    //Methods
    public void processInvoice(CarRental carRental){
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hour = minutes / 60.0;
        double basicPayment;
        if (hour <= 12.0) {
            basicPayment = pricePerHour * Math.ceil(hour);
        }
        else{
            double day = hour / 24;
            basicPayment = pricePerDay * Math.ceil(day);
        }

        double taxFinal = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, taxFinal));

    }

    

    



   



    
}
