package entities;

public class ImporteProduct extends Product {
    private Double customsFee;

    //Construtores
    public ImporteProduct() {
        super();
    }

    public ImporteProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    //Encapsuladores
    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    //Métodos
    public Double totalPrice(){
        return price + customsFee;
    }

    @Override
    public String priceTag(){
        StringBuilder text = new StringBuilder();
        text.append(name + " $ " + totalPrice() + " (Customs fee: $ " + customsFee + ")");
        return text.toString();
    }

    

    
}
