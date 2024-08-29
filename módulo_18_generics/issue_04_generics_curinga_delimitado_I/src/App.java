
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

        // Por causa do tipo curinga delimitador List<? extends Shape> é possível que a função totalArea funcione para sub classes de shape
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
}