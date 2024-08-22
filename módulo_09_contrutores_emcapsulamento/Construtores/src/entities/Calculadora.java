package entities;

public class Calculadora {
    private String name;
    private double price;
    private int quantity;


    // Construtores
    public Calculadora(){
    }

    public Calculadora(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public Calculadora(String name, double price){
        this.name = name;
        this.price = price;
    }

    //Encapsulamento
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getQuantity(){
        return quantity;
    }

    // Métodos
    public double totalValueInStock() {
    return price * quantity;
    }
    public void addProducts(int quantity) {
    this.quantity += quantity;
    }
    public void removeProducts(int quantity) {
    this.quantity -= quantity;
    }

    // toString
    public String toString() {
    return name
    + ", $ "
    + String.format("%.2f", price)
    + ", "
    + quantity
    + " units, Total: $ "
    + String.format("%.2f", totalValueInStock());
    }
}
