package issue_02_predicate.src.application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import issue_02_predicate.src.util.MyPredicate;
import issue_02_predicate.src.entities.*;;

public class Program {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));
        
        //Usando a Classe MyPredicate com a implementação da Interface Funcional Predicate
        //list.removeIf(new MyPredicate());

        
        //Expressão lambda declarada
        //Predicate<Product> pred = p -> p.getPrice() >= 100.0;
        //list.removeIf(pred);

        //Expressão lambda Inline
        list.removeIf(p -> p.getPrice() >= 100.0);

        for(Product l : list){
            System.out.println(l);
        }
    }
}
