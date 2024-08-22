package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class App {
    public static void main(String[] args) throws Exception {
       Locale.setDefault(Locale.US);
       Scanner input = new Scanner(System.in);
       List<Shape> shape = new ArrayList<>();
       System.out.print("Enter the number of shaps: ");
       int n = input.nextInt();
       
       for (int i = 1; i <=n; i++){
            System.out.println("Shape #" + i + " data: ");
            System.out.print("Rectangle or Circle (r/c)? ");
            char obj = input.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(input.next());
            if(obj == 'r'){
                System.out.print("Width: ");
                Double width = input.nextDouble();
                System.out.print("Height: ");
                Double height = input.nextDouble();
                shape.add(new Rectangle(color, width, height));
            }
            else{
                System.out.print("Radius: ");
                Double radius = input.nextDouble();
                shape.add(new Circle(color, radius));
            }
       }

       System.out.println();
       System.out.println("SHAPE AREAS: ");
       for(Shape list : shape){
            System.out.println(list.area());
       }

       input.close(); 
    }
}
