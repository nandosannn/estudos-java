package issue_03_consumer.src.application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


import issue_03_consumer.src.util.PriceUpdate;
import issue_03_consumer.src.entities.Product;

public class Program {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));
        
        //Usando uma instância da Classe PriceUpdate
        //list.forEach(new PriceUpdate());

        /* 
        //Usando uma declaração de expressão Lambda

        double factor = 1.1;
		
		Consumer<Product> cons = p -> {
			p.setPrice(p.getPrice() * factor);
		};
        */

        //Usando expressão lambda inline
        double factor = 1.1;
		
		list.forEach(p -> p.setPrice(p.getPrice() * factor));




        for(Product l : list){
            System.out.println(l);
        }
        
    }
}
