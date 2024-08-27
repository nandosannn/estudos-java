
// Aula - Tipos coringa//

//Introdução ao Tipo Coringa//

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        //O tipo ? é o super tipo que engloba todos os tipos//

        List<?> myObjs = new ArrayList<Object>();
        List<Integer> myNumbers = new ArrayList<Integer>();
        //myObjs = myNumbers; // erro de compilação

        List<Integer> myInts = Arrays.asList(5, 2, 10);
        printList(myInts);
        
        //Não é possível add elementos a uma lista do tipo coringa//
        public static void printList(List<?> list) {
            for (Object obj : list) {
                System.out.println(obj);
            }
        }
    }
}
