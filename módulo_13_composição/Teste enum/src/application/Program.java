package application;

import java.util.Date;

import entities.Order;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {

		Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
		
		System.out.println(order);

		String nome = "DELIVERED";
		
		OrderStatus os1 = OrderStatus.DELIVERED;
		
		OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

		OrderStatus os3 = OrderStatus.valueOf(nome);
		
		System.out.println(os1);
		System.out.println(os2);
		System.out.println(os3);

	}
}