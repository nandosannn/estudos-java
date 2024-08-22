import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        try {
            String[] vect = input.nextLine().split(" ");
            int position = input.nextInt();
            System.out.println(vect[position]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid position!");
            e.printStackTrace();
        }
        catch(InputMismatchException e){
            System.out.println("Input Error");
        }

        System.out.println("End of Program!");
    }
}
