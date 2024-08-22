package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;
import services.CalculationService;

public class Program {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		String path = "D:\\Desenvolvimento Web\\Java\\Modulo 18\\in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] felds = line.split(",");
				list.add(new Product(felds[0], Double.parseDouble(felds[1])));
				line = br.readLine();
			}
			
			Product x = CalculationService.max(list);
			System.out.println("Max:");
			System.out.println(x);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}