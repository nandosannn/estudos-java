package application;
import entities.Banco;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int auxNum;
        String auxHol;
        double auxBal;
        char condicao;
        
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter account number: ");
        auxNum = input.nextInt();
        System.out.print("Enter account holder: ");
        input.nextLine();
        auxHol = input.nextLine();
        System.out.print("Is there na initial deposit? ");
        condicao = input.next().charAt(0);
        
        if(condicao == 'y'){
            System.out.print("Enter initial deposit value: ");
            auxBal = input.nextDouble();
        }
        else{
            auxBal = 0;
        }
        
        Banco conta = new Banco(auxNum, auxHol, auxBal);
        
        System.out.println("Account data:");
        System.out.println(conta);

        System.out.print("Enter a deposit value: ");
        double amount = input.nextDouble();
        conta.deposit(amount);

        System.out.println("Updated account data:");
        System.out.println(conta);

        System.out.print("Enter a withdraw value: ");
        amount = input.nextDouble();
        conta.withdraw(amount);

        System.out.println("Updated account data:");
        System.out.println(conta);

        input.close();

        
    }
}
