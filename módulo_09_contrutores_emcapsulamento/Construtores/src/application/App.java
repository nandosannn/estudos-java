package application;
import java.util.Locale;
import java.util.Scanner;
import entities.Calculadora;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        Calculadora product = new Calculadora(name, price);


        System.out.println();
        System.out.println("Product data: " + product);

        product.setName("Computador");
        product.setPrice(1200.00);
        System.out.println("Alteração no nome do produto para: " + product.getName());
        System.out.println("Alteração no valor do produto para: " + product.getPrice());
        

        System.out.println();
        System.out.print("Enter the number of products to be added in stock: ");
        int quantidade = sc.nextInt();
        product.addProducts(quantidade);

        System.out.println();
        System.out.println("Updated data: " + product);

        System.out.println();
        System.out.print("Enter the number of products to be added in stock: ");
        quantidade = sc.nextInt();
        product.addProducts(quantidade);

        System.out.println();
        System.out.println("Updated data: " + product);

        System.out.println();
        System.out.print("Enter the number of products to be removed from stock: ");
        quantidade = sc.nextInt();
        product.removeProducts(quantidade);

        System.out.println();
        System.out.println("Updated data: " + product);

















        
        sc.close();
    }
}
