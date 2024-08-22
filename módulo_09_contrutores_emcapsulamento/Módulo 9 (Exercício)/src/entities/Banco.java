package entities;

public class Banco {
    private int number;
    private String holder;
    private double balance;

    //contrutores
    public Banco(){

    }

    public Banco(int number, String holder, double balance){
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    //Encapsulamento
    public int getNumber(){
        return number;
    }

    public String getHolder(){
        return holder;
    }

    public double setBalance(){
        return balance;
    }

    public void setHolder(String holder){
        this.holder = holder;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    //String do Banco
    public String toString(){
        return "Account: " + number + ", holder: " + holder + ", Balance: " + balance; 
    }

    //Métodos
    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= (amount + 5);
    }


}
