import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import entities.Product;

// Maps é uma coleção de pares chave / valor
public class App {
    public static void main(String[] args) throws Exception {
        /*
        //Demonstrações dos método Map
        //A Classe String já possui implementação do HashCode e da Classe Comparable
        //para usar a Classe Genérica TreeMap
        Map<String, String> cookies = new TreeMap<>();

        cookies.put("username", "maria");
        cookies.put("email", "maria@gmail.com");
        cookies.put("phone", "99771122");

        //Remove um par com base na chave
        cookies.remove("email");

        //Map não aceita chaves repetidas então sobrescreve o valor
        cookies.put("phone", "99771133");

        System.out.println("ALL COOKIES:");

        //Verificar se o Map contem a chabe 'phone'
        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));

        //Pegar o valor da chave
        System.out.println("Phone number: " + cookies.get("phone"));

        //Quando o elemento não existe o método retorna null
        System.out.println("Email: " + cookies.get("email"));

        //Retorna o tamanho do Map
        System.out.println("Size: " + cookies.size());


        for (String key : cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }
        */

        Map<Product, Double> stock = new HashMap<>();

        Product p1 = new Product("Tv", 900.0);
        Product p2 = new Product("Notebook", 1200.0);
        Product p3 = new Product("Tablet", 400.0);

        stock.put(p1, 10000.0);
        stock.put(p2, 20000.0);
        stock.put(p3, 15000.0);

        Product ps = new Product("Tv", 900.0);

        //O método containsKey se basea no hash code para verificar se o Map possui a chave inserida como argumento
        //Como o hash code não foi implementado na Classe inicialmente, containsKey retorna false pois a verificação acontece com o endereço de memória
        System.out.println("Contains 'ps' key: " + stock.containsKey(ps));

    }

}
