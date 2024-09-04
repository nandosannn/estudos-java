# O que é um Map em Java?
Um Map em Java é uma coleção de pares chave/valor. Ele permite armazenar e recuperar dados de forma eficiente usando uma chave única para cada valor. Algumas características importantes de um Map:
- Não permite duplicatas de chaves, mas pode ter valores duplicados
- As chaves devem ser únicas, mas os valores podem ser duplicados
- O acesso, inserção e remoção de elementos são rápidos
- Comumente usado para armazenar dados como cookies, configurações, cache, etc.
## Principais implementações de Map
Java fornece três principais implementações de Map:

- **HashMap:** Implementação mais rápida, com operações O(1) em média Não mantém a ordem de inserção dos elementos
Não é sincronizada, então não é thread-safe.
- **TreeMap:** Implementação ordenada, mantém os elementos em ordem natural (definida pelo Comparator ou compareTo)
Operações de acesso, inserção e remoção são O(log(n))
Thread-safe, mas não sincronizada.
- **LinkedHashMap:** Mantém a ordem de inserção dos elementos
Velocidade intermediária entre HashMap e TreeMap
Útil quando a ordem de inserção é importante.

## Métodos Importantes da Interface Map

A interface Map em Java fornece uma variedade de métodos para manipular coleções de pares chave/valor. Aqui estão alguns dos métodos mais importantes:
- `put(key, value)` :Adiciona um par chave/valor ao mapa. Se a chave já existir, o valor associado a essa chave será atualizado.

    📝 **Exemplo**:
   

        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1); // Adiciona a chave "apple" com o valor 1
        map.put("banana", 2); // Adiciona a chave "banana" com o valor 2
        map.put("apple", 3); // Atualiza o valor da chave "apple" para 3

- `remove(key)`: remove o par chave/valor associado à chave especificada. Retorna o valor que foi removido ou null se a chave não existir.
  
    📝 **Exemplo:**


        Integer removedValue = map.remove("banana"); // Remove a chave "banana" e retorna 2

- `containsKey(key)`: Descrição: Verifica se o mapa contém a chave especificada. Retorna true se a chave existir, caso contrário, retorna false.
  
    📝 **Exemplo**:
   

        boolean hasApple = map.containsKey("apple"); // true
        boolean hasBanana = map.containsKey("banana"); // false, se já removido

- `get(key)`: Retorna o valor associado à chave especificada. Retorna null se a chave não existir no mapa.

    📝 **Exemplo:**


        Integer appleValue = map.get("apple"); // 3
        Integer bananaValue = map.get("banana"); // null, se já removido

- `clear():` Remove todos os pares chave/valor do mapa, deixando-o vazio.
   
    📝 **Exemplo:**


        map.clear(); // O mapa agora está vazio

- `size():` Retorna o número de pares chave/valor presentes no mapa.

    📝 **Exemplo:**


        int size = map.size(); // Retorna o número de elementos no mapa

- `keySet():` Retorna um Set contendo todas as chaves do mapa. As chaves são únicas.
    
    📝 **Exemplo:**

        
        Set<String> keys = map.keySet(); // Obtém um conjunto de todas as chaves
        for (String key : keys) {
            System.out.println(key);
        }
- `values(): `Retorna uma Collection contendo todos os valores do mapa. Os valores podem ser duplicados.

    📝 **Exemplo:**

        
        Collection<Integer> values = map.values(); // Obtém uma coleção de todos os valores
        for (Integer value : values) {
            System.out.println(value);
        }

## Considerações sobre equals e hashCode

- A implementação dos métodos `put, remove, containsKey e get `em um Map é baseada nos métodos e`quals e hashCode` das chaves.
- Se esses métodos não forem implementados, a comparação de ponteiros será utilizada, o que pode levar a comportamentos inesperados, especialmente quando se utiliza objetos como chaves.

