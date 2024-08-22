package application;

import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

import entities.ImporteProduct;
import entities.Product;
import entities.UsedProduct;


public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.print("Enter the number of products: ");
        int n = input.nextInt();

        for(int i = 1; i<=n; i++){
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char typeProduct = input.next().charAt(0);
            System.out.print("Name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Price: ");
            Double price = input.nextDouble();
            if(typeProduct == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                input.nextLine();
                String moment = input.nextLine();
                LocalDate date = LocalDate.parse(moment, f1);
                products.add( new UsedProduct(name, price, date));
            }
            else if(typeProduct == 'i'){
                System.err.print("Customs fee: ");
                Double fee = input.nextDouble();
                products.add(new ImporteProduct(name, price, fee));
            }
            else{
                products.add(new Product(name, price));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");
        for(Product list : products){
            System.out.println(list.priceTag());
        }

        input.close();
    }
}
