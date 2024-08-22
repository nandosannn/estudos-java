import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception{
        String[] line = new String[] {"Good Morning", "Good Nights"};
        
        String path = "D:\\Desenvolvimento Web\\Java\\Módulo 16\\arquivoEscrita\\arquivoEscrita\\teste.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            for (String lines : line){
                bw.write(lines);
                bw.newLine();
            }
        }
        catch(IOException e){
            e.getStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String liness = br.readLine();
            while (liness != null){
                System.out.println(liness);
                liness = br.readLine();
            }
        }
        catch(IOException e){
            e.getStackTrace();
        }
    }
}
