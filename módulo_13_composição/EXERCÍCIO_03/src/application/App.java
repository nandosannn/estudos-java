package application;

import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Locale;
import java.util.Scanner;

import entities.Client;

public class App {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter cliente data:");
        
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String data = input.nextLine();
        LocalDate date = LocalDate.parse(data,f2);
       
        Client client = new Client(name, email, date);

        System.out.print("Time of purchase: ");
        String datePurchase = input.nextLine();
        LocalDateTime moment = LocalDateTime.parse(datePurchase, f1);

        

        System.out.println("Enter order data:");
        System.out.print("Status:");
        String s = input.nextLine();
        OrderStatus status = OrderStatus.valueOf(s);

        Order order = new Order(moment, status, client);

        System.out.print("How many items to this order? ");
        int n = input.nextInt();
        

        for(int i = 0; i<n; i++){
            System.out.printf("Enter #%d item data: \n", i+1);
            input.nextLine();
            System.out.print("Product name: ");
            String nameProduct = input.nextLine();
            System.out.print("Product Price: ");
            Double productPrice = input.nextDouble();
            System.out.print("Quantity: ");
            int quantity = input.nextInt();
            System.out.println();
            Product product = new Product(nameProduct, productPrice);
            OrderItem orderItem = new OrderItem(quantity, productPrice, product);
            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println("Order moment: " + order.getMoment());
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client: " + client.getName() + " (" + client.getDate() + ") - " + client.getEmail());
        System.out.println("Order items: ");
        
        for (OrderItem list : order.getItems()){
            System.out.println(list.getProduct().getName() + ", $" + String.format("%.2f", list.getProduct().getPrice()) + ", Quantity: " + list.getQuantity() + ",  Subtotal: " + list.subTotal());
        }
       
        System.out.println("Total price: $" + order.total());
        
        input.close();
    }
}
