
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();

        list.add("Fernando");
        list.add("João");
        list.add("Felipe");
        list.add("Julio");
        list.add("Maria");
        
        for(String nomes : list){
            System.out.println(nomes);
        }

        System.out.println("---------------------------");

        list.add(4, "Marcelo");
        for(String nomes : list){
            System.out.println(nomes);
        }

        System.out.println("---------------------------");
        list.remove("Fernando");
        list.remove(0);
        for(String nomes : list){
            System.out.println(nomes);
        }
        
        System.out.println("---------------------------");
        System.out.println("Index of Maria: " + list.indexOf("Maria"));
        System.out.println("Index of Pedro: " + list.indexOf("Pedro"));
        
        System.out.println("---------------------------");
        List<String> result = list.stream().filter(x -> x.charAt(0)=='J').collect(Collectors.toList());
        for(String nomes : result){
            System.out.println(nomes);
        }
        
        System.out.println("---------------------------");
        String nome = list.stream().filter(x -> x.charAt(0)=='F').findFirst().orElse(null);
        System.out.println(nome);

        System.out.println("---------------------------");
        list.remove(nome);
        for(String nomes : list){
            System.out.println(nomes);
        }
    }
}
