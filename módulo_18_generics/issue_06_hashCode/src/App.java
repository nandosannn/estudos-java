import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import enteties.Product;

import enteties.Client;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * ////////HASHCODE E EQUALS////////
         * Client c1 = new Client("Fernando", "Fernando@gmail.com");
         * Client c2 = new Client("Fernando", "Alex@gmail.com");
         * 
         * System.out.println(c1.hashCode());
         * System.out.println(c2.hashCode());
         * System.out.println(c1.equals(c2));
         */

        /*
         * ///////set////////
         * Set<String> set = new HashSet<>();
         * set.add("TV");
         * set.add("Notebook");
         * set.add("Tablet");
         * System.out.println(set.contains("Notebook"));
         * for (String p : set) {
         * System.out.println(p);
         * }
         */

        /*
         * ///////// OPERAÇÕES COM CONJUNTOS////////
         * Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
         * Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));
         * // union
         * Set<Integer> c = new TreeSet<>(a);
         * c.addAll(b);
         * System.out.println(c);
         * // intersection
         * Set<Integer> d = new TreeSet<>(a);
         * d.retainAll(b);
         * System.out.println(d);
         * // difference
         * Set<Integer> e = new TreeSet<>(a);
         * e.removeAll(b);
         * System.out.println(e);
         */

        /* 
        //////////// SET IGUALDADE///////////
        
        //A classe product precisa ter a implementação da função hashcode e equels para as comparações funcionarem
        Set<Product> set = new HashSet<>();
        set.add(new Product("TV", 900.0));
        set.add(new Product("Notebook", 1200.0));
        set.add(new Product("Tablet", 400.0));
        
        Product prod = new Product("Notebook", 1200.0);
        
        System.out.println(set.contains(prod));
        
        */

        ////COMO O TREESET COMPARA ELEMENTOS

        Set<Product> set = new TreeSet();
        set.add(new Product("TV", 900.0));
        set.add(new Product("Notebook", 1200.0));
        set.add(new Product("Tablet", 400.0));
        
       for(Product lista : set){
            System.out.println(lista);
       }
    }
}
