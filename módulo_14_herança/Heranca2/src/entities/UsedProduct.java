package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
    private LocalDate date;

    //Construtores
    public UsedProduct(){

    }
    
    public UsedProduct(String name, Double price, LocalDate date) {
        super(name, price);
        this.date = date;
    }

    //Encapsuladores
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    //Metodos
    @Override
    public String priceTag(){
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        StringBuilder text = new StringBuilder();
        text.append(super.priceTag() + " (Manufacture date: " + f1.format(date) + ")");
        return text.toString();
    }



    

    

}
