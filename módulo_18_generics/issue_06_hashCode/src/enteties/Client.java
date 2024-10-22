package enteties;

import java.util.Objects;

public class Client {
    private String name;
    private String email;
    
    //Constructors
    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }


    //Encapsulators
    public String getName() {
        return name;
    }
    public void setName(String name) {

        this.name = name;
    }
    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Verifica se é o mesmo objeto
        if (obj == null || getClass() != obj.getClass()) return false;
        // Verifica se é nulo ou de classe diferente

        Client other = (Client) obj; // Faz o cast para Client
        if (name == null) {
            if (other.name != null) return false; // Verifica se o nome é nulo
        } else if (!name.equals(other.name)) return false; // Compara os nomes

        if (email == null) {
            if (other.email != null) return false; // Verifica se o email é nulo
        } else if (!email.equals(other.email)) return false; // Compara os emails

        return true; // Retorna true se todos os atributos são iguais
    }
}