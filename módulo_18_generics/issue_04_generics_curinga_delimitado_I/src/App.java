
//Aula - Tipos Coringa Delimitados//

import java.util.ArrayList;
import java.util.List;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;

public class App {

    public static void main(String[] args) {

        List<Shape> myShapes = new ArrayList<>();
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));

        List<Circle> myCircles = new ArrayList<>();
        myCircles.add(new Circle(2.0));
        myCircles.add(new Circle(3.0));
        // O método totalArea só funciona para o tipo shape, mas não funciona para as
        // subclasses
        System.out.println("Total area: " + totalArea(myCircles));
    }

    // ? extends Shape -> significa que a lista é do tipo shape ou qualquer sub tipo
    // da classe shape
    public static double totalArea(List<? extends Shape> list) {
        double sum = 0.0;
        for (Shape s : list) {
            sum += s.area();
        }
        return sum;
    }

    List<Integer> intList = new ArrayList<Integer>();
    intList.add(10);
    intList.add(5);
    List<? extends Number> list = intList;
    Number x = list.get(0);
    // list.add(20); // erro de compilacao 
    //Com extends Number é possível acessar os valores da lista mas não é possível adicionar novos valores 

}