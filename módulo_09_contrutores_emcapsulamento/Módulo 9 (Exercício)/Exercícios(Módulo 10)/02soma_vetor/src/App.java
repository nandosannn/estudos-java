
import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        
        System.out.print("Quantos números você vai digitar? ");
        int n = input.nextInt();

        double[] vetor = new double[n];

        double soma = 0;
        for(int i = 0; i<vetor.length; i++){
            System.out.printf("Digite o %d° nome: ", i+1);
            vetor[i] = input.nextDouble();
            soma += vetor[i];
        }

        System.out.print("VALORES = ");
        for(int i =0; i<vetor.length; i++){
            System.out.print(vetor[i]);
            if (i != vetor.length-1) {
                System.out.print(" ");
            }
            else {
                System.out.printf("\n");
            }
        }
        System.out.println();
        System.out.println("SOMA = " + soma);
        System.out.println("MÉDIA = " + soma/n);
        
        
        
        
        input.close();
        
    }
}
