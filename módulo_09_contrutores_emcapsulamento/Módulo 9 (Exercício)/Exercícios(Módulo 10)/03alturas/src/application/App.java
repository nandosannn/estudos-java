package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Pessoa;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        System.out.println("Quantas pessoas seão digitadas?");
        int n = input.nextInt();
        Pessoa[] vetor = new Pessoa[n];

        double soma = 0.0;
        int menores = 0;
        for (int i = 0; i<vetor.length; i++){
            input.nextLine();
            String nome = input.nextLine();
            int idade = input.nextInt();
            double altura = input.nextDouble();
            vetor[i] = new Pessoa(nome, idade, altura);
            if (vetor[i].getIdade()<16) {
                menores +=1;
            }
            soma += vetor[i].getAltura();
        }

        double media = soma/vetor.length;
        double porcentagem = (double)(menores*100.0)/n;

        System.out.println("Altura média: " + media);
        System.out.printf("Pessoas com menos de 16 anos: %.2f", porcentagem);
        for(int i = 0; i<vetor.length; i++){
            if (vetor[i].getIdade()<16) {
                System.out.println(vetor[i].getNome());
            }
        }


        input.close();
    }
}
