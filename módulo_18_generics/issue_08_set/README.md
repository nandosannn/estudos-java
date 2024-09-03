# HashCode e Equals
## Introdução
As operações hashCode e equals são métodos fundamentais da classe Object em Java, utilizados para comparar objetos e determinar sua igualdade. Compreender como e quando utilizá-los é crucial para garantir a integridade e a eficiência de estruturas de dados, como conjuntos e mapas.

- **Equals**: Método que compara se dois objetos são iguais, retornando true ou false. É uma operação mais lenta, mas fornece uma resposta definitiva.
- **HashCode**: Método que gera um valor inteiro (código hash) a partir dos dados do objeto. É uma operação mais rápida, mas uma resposta positiva não garante que os objetos sejam iguais.
- Tipos comuns (String, Date, Integer, Double, etc.) já possuem implementações padrão para esses métodos. Classes personalizadas, por outro lado, precisam sobrescrever esses métodos para garantir a comparação correta.

## Equals
O método equals é utilizado para verificar se um objeto é igual a outro. A implementação padrão em Object compara referências de memória, mas é comum sobrescrevê-lo para comparar os atributos relevantes da classe.

📝 Exemplo de Uso do Equals:

    String a = "Maria";
    String b = "Alex";
    System.out.println(a.equals(b)); // Retorna false, pois as strings não são iguais.

## HashCode
O método hashCode retorna um número inteiro que representa um código gerado a partir das informações do objeto. Esse código é utilizado em estruturas de dados, como HashMap, para otimizar a busca e a inserção.

📝 **Exemplo de Uso do HashCode:**

    String a = "Maria";
    String b = "Alex";
    System.out.println(a.hashCode()); // Retorna um código hash para a string "Maria".
    System.out.println(b.hashCode()); // Retorna um código hash para a string "Alex".

## Implementação Personalizada de HashCode e Equals
Para classes personalizadas, é importante implementar os métodos `hashCode e equals` de forma consistente. Abaixo está um exemplo de como você pode fazer isso na classe Client.
Exemplo de Implementação do HashCode na Classe Client:


    @Override
    public int hashCode() {
    final int prime = 31;
    int result = 1;
    
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    
    return result;
    }

## Exemplo de Implementação do Equals na Classe Client:

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

## Chamando os Métodos na Main

Aqui está um exemplo de como você pode utilizar os métodos hashCode e equals em sua classe Client.

    Client c1 = new Client("Fernando", "Fernando@gmail.com");
    Client c2 = new Client("Fernando", "Fernando@gmail.com");
    
    System.out.println(c1.hashCode()); // Retorna o código hash de c1
    System.out.println(c2.hashCode()); // Retorna o código hash de c2
    System.out.println(c1.equals(c2)); // Retorna true, pois os atributos são iguais

## Observações Importantes

- Caso c1 == c2, o programa retornará false, pois == compara referências de memória, que são diferentes.
- Para strings literais, como:


    String s1 = "Teste";
    String s2 = "Teste";

O programa retorna true, pois o Java utiliza internamento de strings, fazendo com que ambas referenciem o mesmo objeto na memória.
- Se você instanciar novas strings:

    
    String s1 = new String("Teste");
    String s2 = new String("Teste");

O programa retornará false, pois s1 e s2 são referências a objetos diferentes na memória.

## Conclusão

A implementação correta dos métodos hashCode e equals é essencial para garantir a funcionalidade adequada de coleções em Java. Ao sobrescrever esses métodos, você assegura que os objetos sejam comparados de forma lógica, com base em seus atributos, e não apenas em suas referências de memória.