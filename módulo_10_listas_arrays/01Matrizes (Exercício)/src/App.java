import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        
        System.out.print("Qual a ordem da Matriz? ");
        int n = input.nextInt();
        
        int[][] matriz = new int[n][n];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<n;j++){
                matriz[i][j]=input.nextInt();
            }
        }

        System.out.println("Matriz: ");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Diagonal principal:");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n;j++){
                if (i==j) {
                    System.out.print(matriz[i][j]);
                    if (i != n-1) {
                        System.out.print(", ");
                    }
                }
            }
            if (i == n-1) {
                System.out.println();
            }
        }

        System.out.println("Números negativos: ");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n;j++){
                if (matriz[i][j]<0) {
                    System.out.print(matriz[i][j]);
                    if (i != n-1) {
                        System.out.print(", ");
                    }
                }
            }
            if (i == n-1) {
                System.out.println();
            }
        }
        input.close();
    }
}
