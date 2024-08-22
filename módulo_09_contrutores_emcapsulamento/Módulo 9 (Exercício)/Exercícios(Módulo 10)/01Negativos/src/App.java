
import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        
        System.out.print("Quantos números você vai digitar? ");
        int n = input.nextInt();
        
        //Declaração de vetor
        int[] vect = new int[n];

        //Leitura do vetor
        for(int i=0; i<n; i++){
            System.out.printf("Digite o %d° número: ", i+1);
            vect[i]=input.nextInt();
        }

        //Análise e impressão dos valores negativos 
        System.out.println("NÚMEROS NEGATIVOS:");
        for(int i=0; i<n; i++){
            if(vect[i]<0){
                System.out.println(vect[i]);
            }
        }

        input.close();
    }
}
