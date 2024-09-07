package issue_03_function.src.application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import issue_03_function.src.util.UpperCaseName;
import issue_03_function.src.entities.Product;

public class Program {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));
        
        /*
        // Usando um instância da Classe UpperCaseName
        List<String> newList = list.stream()
                .map(new UpperCaseName())
                .collect(Collectors.toList());
        */
        
        /* 
        //Usando declaração de expressão Lambda
        Function<Product, String> func = p -> p.getName().toUpperCase();
        List<String> newList = list.stream()
                .map(func)
                .collect(Collectors.toList());
        */

        //Expressão Lambda Inline
        List<String> newList = list.stream()
                .map(p -> p.getName().toUpperCase())
                .collect(Collectors.toList());
        
        //Imprimir a nova lista de nomes em maiúsculas
        newList.forEach(System.out::println);
        

        // Opcional: imprimir a lista original de produtos
        list.forEach(System.out::println);
    }
}

