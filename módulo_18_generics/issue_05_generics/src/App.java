import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(10);
        intList.add(5);
        List<? extends Number> list = intList;
        Number x = list.get(0);
        // list.add(20); // erro de compilacao 
        //Com extends Number é possível acessar os valores da lista mas não é possível adicionar novos valores 

        List<Object> myObjs = new ArrayList<Object>();
        myObjs.add("Maria");
        myObjs.add("Alex");
        List<? super Number> myNums = myObjs;
        myNums.add(10);
        myNums.add(3.14);
        //Number x = myNums.get(0); // erro de compilacao
        //com super Number é possível adicionar novos valores de superclasses de Number mas não é possível acessar os valores

    }

}
