# Set
## Introdução
O tipo de dado Set em Java representa uma coleção de elementos únicos, similar ao conceito de conjunto da Álgebra. 
Algumas características importantes do Set:
- Não permite a adição de elementos duplicados
- A ordem dos elementos não é garantida (exceto para algumas implementações específicas)
- O acesso, inserção e remoção de elementos são operações rápidas
- Oferece operações eficientes de conjunto, como interseção, união e diferença

## Principais implementações

Java fornece três principais implementações de Set:

### HashSet
- É a implementação mais rápida, com operações em tempo constante (O(1)) usando uma tabela hash
- Não mantém a ordem original de inserção dos elementos
- Não é ordenado, a menos que você use um Comparator personalizado
### TreeSet
- Implementa uma árvore rubro-negra, portanto as operações têm complexidade logarítmica (O(log(n)))
- Mantém os elementos ordenados de acordo com seu valor natural (usando o método compareTo) ou usando um Comparator personalizado
- Acesso, inserção e remoção são mais lentos que o HashSet

### LinkedHashSet

- Combina as características de HashSet e TreeSet
- Mantém a ordem de inserção dos elementos
- Tem desempenho intermediário entre HashSet e TreeSet

## Métodos Importantes do Set
O tipo de dado Set em Java oferece uma variedade de métodos úteis para manipulação de conjuntos. Aqui estão alguns dos métodos mais importantes:

### Métodos Básicos

- `add(obj)`: Adiciona um elemento ao conjunto. Se o elemento já existir, a operação não terá efeito.


        Set<String> set = new HashSet<>();
        set.add("apple"); // Retorna true
        set.add("apple"); // Retorna false

- `remove(obj)`: Remove um elemento do conjunto, se ele estiver presente. Retorna true se a remoção foi bem-sucedida.


        set.remove("banana"); // Retorna false se "banana" não estiver no conjunto

- `contains(obj)`: Verifica se um elemento está presente no conjunto. Retorna true se o elemento existir.


        boolean hasApple = set.contains("apple"); // Retorna true

## Comparação de Elementos
- Os métodos add, remove e contains são baseados nos métodos equals e hashCode do objeto. Isso significa que, para que dois objetos sejam considerados iguais em um Set, eles devem ter a mesma implementação de equals e hashCode.
- Se os métodos equals e hashCode não forem implementados, a comparação será feita usando a referência de memória (comparação de ponteiros).

## Métodos Adicionais

- `clear()`: Remove todos os elementos do conjunto, deixando-o vazio.


        set.clear(); // O conjunto agora está vazio

- `size()`: Retorna o número de elementos presentes no conjunto.


        int numberOfElements = set.size(); // Retorna o número de elementos

- `removeIf(predicate)`: Remove todos os elementos do conjunto que satisfazem a condição especificada pelo predicado.



        set.removeIf(s -> s.startsWith("a")); // Remove todos os elementos que começam com "a"

## Operações de Conjunto

- `addAll(other)`: Realiza a união com outro conjunto, adicionando todos os elementos do conjunto fornecido, sem permitir duplicatas.


        
        Set<String> anotherSet = new HashSet<>();
        anotherSet.add("banana");
        anotherSet.add("cherry");
        set.addAll(anotherSet); // Adiciona "banana" e "cherry" ao conjunto


- `retainAll(other)`: Realiza a interseção com outro conjunto, removendo do conjunto atual todos os elementos que não estão contidos no conjunto fornecido.
        
        
        Set<String> intersectionSet = new HashSet<>();
        intersectionSet.add("apple");
        intersectionSet.add("banana");
        set.retainAll(intersectionSet); // Mantém apenas os elementos que estão em intersectionSet

- `removeAll(other)`: Realiza a diferença, removendo do conjunto atual todos os elementos que estão presentes no conjunto fornecido.

        
        Set<String> differenceSet = new HashSet<>();
        differenceSet.add("banana");
        set.removeAll(differenceSet); // Remove "banana" do conjunto

## Como as Coleções `Hash `Testam Igualdade
As coleções Hash, como HashSet e HashMap, utilizam métodos específicos para determinar a igualdade entre objetos. A seguir, explicamos como essa verificação é realizada:

### Quando `hashCode` e `equals` Estão Implementados
- **Verificação de hashCode**: Quando um objeto é adicionado a uma coleção Hash, o método `hashCode() `é chamado primeiro. Esse método retorna um valor inteiro que representa o objeto. Se dois objetos têm o mesmo valor de hash code, isso indica que eles podem ser iguais, mas não garante isso.

        
        int hash1 = obj1.hashCode();
        int hash2 = obj2.hashCode();

- **Verificação de equals**: Se os valores de hash code forem iguais, o método `equals()` é então chamado para verificar se os dois objetos são realmente iguais. O método `equals()` deve ser implementado de forma a comparar as propriedades relevantes dos objetos.

        
        if (hash1 == hash2 && !obj1.equals(obj2)) {
        // Os objetos têm o mesmo hash, mas não são iguais
        }

### Quando hashCode e equals _NÃO_ Estão Implementados

- **Comparação de Referências**: Se os métodos `hashCode() e equals()` não forem implementados, a comparação será feita usando a referência de memória dos objetos, ou seja, os ponteiros. Isso significa que apenas dois objetos que são exatamente a mesma instância (ou seja, ocupam o mesmo espaço na memória) serão considerados iguais.

        
        if (obj1 == obj2) {
        // Os objetos são a mesma instância
        }

### Considerações Importantes

- **Classes Padrão**: Classes como `String, Integer, Double`, entre outras, já possuem implementações de `equals() e hashCode()`, que são adequadas para a comparação de valores. Portanto, ao usar essas classes em coleções Hash, a igualdade será testada corretamente com base em seu conteúdo.
- **Implementação Personalizada**: Ao criar suas próprias classes que serão usadas em coleções Hash, é fundamental **implementar** corretamente os métodos `hashCode() e equals()`. Isso garante que a coleção funcione como esperado e que a comparação de igualdade seja feita de forma eficiente e correta.


### Desmonstração na `main`:


        Set<Product> set = new HashSet<>();
        set.add(new Product("TV", 900.0));
        set.add(new Product("Notebook", 1200.0));
        set.add(new Product("Tablet", 400.0));
        
        Product prod = new Product("Notebook", 1200.0);
                
        System.out.println(set.contains(prod)); // Retorna true caso prod esteja contido no set

-  Isso demonstra como os métodos `hashCode() e equals() `funcionam em conjunto para garantir a correta operação do `HashSet`.

## Como o `TreeSet` Compara Elementos

**Comparação Natural:**
- O TreeSet pode comparar elementos de forma natural, o que significa que os objetos precisam implementar a interface Comparable. Quando você adiciona um objeto a um TreeSet, o Java chama o método `compareTo()` **definido na classe do objeto** para determinar a ordem.
- Por exemplo, se a classe Product implementar `Comparable<Product>`, você deve sobrescrever o método `compareTo(Product other)` para definir **como os produtos devem ser comparados** (por exemplo, com base no preço ou no nome).

📝 **Exemplo:**

        @Override
        public int compareTo(Product other){
            return -getPrice().compareTo(other.getPrice());
        }


- O **TreeSet** não requer a implementação dos métodos `hashCode() e equals()` para funcionar corretamente, ao contrário do `HashSet`.


