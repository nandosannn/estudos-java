package entities;

public class Product {
    protected String name;
    protected Double price;
    
    //Contrutores
    public Product(){

    }
    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    //Encapsuladores
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    //Métodos
    public String priceTag(){
        StringBuilder text = new StringBuilder();
        text.append(name + " $ " + price);
        return text.toString();
    }
    
}
