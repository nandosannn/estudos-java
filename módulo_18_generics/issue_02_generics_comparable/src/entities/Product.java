package entities;

/*Para usar o CompareTo na classe CalculationService é preciso implementar a Interface Comparable*/
public class Product implements Comparable<Product>{

	private String name;
	private Double price;
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

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

	@Override
	public String toString() {
		return name + ", " + String.format("%.2f", price);
	}

    /*Para usar a interface Comparable é preciso implementar o método compareTo especificando qual atributo vai ser comparado*/
    @Override
    public int compareTo(Product other) {
        return price.compareTo(other.getPrice());
    }
}