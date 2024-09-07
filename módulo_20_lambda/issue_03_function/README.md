# Expressão Lambda FUnctions

## Introdução

A **interface Function em Java** é uma das interfaces funcionais mais importantes e amplamente utilizadas. Ela faz parte do pacote `java.util.function` introduzido no Java 8 para suportar programação funcional.
#### Características da Interface Function
- Representa uma função que **recebe um argumento de entrada** do tipo `T` e produz um resultado do tipo `R`.
- Possui um único método abstrato chamado `apply()` que recebe um argumento do `tipo T` e retorna um resultado do `tipo R`.
- Pode ter métodos default e estáticos, mas apenas um método abstrato.
- Pode ser implementada usando expressões **lambda ou referências** de método.

## A Classe UpperCaseName
A classe UpperCaseName implementa a interface `Function<Product, String>` e define uma função que recebe um objeto `Product`, obtém o nome do produto usando o método `getName()`, converte o nome para maiúsculas e retorna o resultado.

- **Declaração da Classe:** A classe `UpperCaseName` é declarada como uma implementação da interface `Function<Product, String>`. Isso significa que ela implementará o método abstrato `apply()` da interface `Function`, recebe um atributo do tipo `Product` e retorna um atributo do tipo `String`.

        public class UpperCaseName implements Function<Product, String> {

                //Implementação do método apply() da interface Function
                @Override
                public String apply(Product p) {
                        return p.getName().toUpperCase();
                }
        }

## Aplicação na Main

O objetivo da aplicação da interface **Function** na main é pegar uma lista de `Product` e, a partir dela, criar uma outra lista de `String` com os nomes da lista anterior em maiúsculo:

        List<String> newList = list.stream()
                .map(new UpperCaseName())
                .collect(Collectors.toList());

#### Explicação do Código:
1. **`list.stream()`**
   - **Objetivo:** Cria um fluxo (stream) a partir da lista list, que é uma lista de objetos do tipo Product.
   - **O que é um Stream:** Um Stream é uma **sequência de elementos** que pode ser processada de forma **funcional**. Ele permite operações como filtragem, mapeamento e redução de forma declarativa e concisa.
2. **`.map(new UpperCaseName())`**
   - **Objetivo:** Aplica uma função a cada elemento do fluxo.
   - **O que é map:** O método map é uma operação intermediária que transforma ***cada elemento do fluxo original em um novo elemento***. Ele recebe uma ***função como argumento***, que é aplicada a cada elemento do fluxo.
   - **`new UpperCaseName()`**: Aqui, é criando uma nova instância da classe `UpperCaseName`, que implementa a interface `Function<Product, String>`. Essa função transforma um objeto `Product` em uma `String` que representa o nome do produto em maiúsculas, utilizando o método `apply()` que você implementou na classe `UpperCaseName`.
3. **`.collect(Collectors.toList())`**
   - **Objetivo:** Coleta os resultados do fluxo transformado em uma nova lista.
   - **O que é collect:** O método `collect` é uma operação terminal que transforma o ***fluxo em uma coleção, como uma lista***, conjunto ou mapa. Ele consome o fluxo e produz um resultado.
   - **`Collectors.toList():`** Este é um coletor que acumula os elementos do fluxo em uma nova lista. O resultado é uma lista do tipo `List<String>`, onde cada elemento é o ***nome de um produto em maiúsculas***.

## Outras Formas de aplicar Function na Main

#### Declaração de expressão Lambda

Nesta abordagem, você declara uma variável do tipo Function<Product, String> e a inicializa com uma expressão lambda que define a transformação desejada.

        Function<Product, String> func = p -> p.getName().toUpperCase();
                List<String> newList = list.stream()
                        .map(func)
                        .collect(Collectors.toList());

- **`Function<Product, String> func`**: Aqui, estamos declarando uma variável `func` que é uma função que aceita um objeto `Product` e retorna uma `String`.
- **`p -> p.getName().toUpperCase()`**: Esta é a expressão lambda que define a transformação. Para cada objeto `Product`, ela chama o método `getName()` e converte o resultado para maiúsculas.
- **`map(func)`**: O método map aplica a função `func` a cada elemento do fluxo, transformando cada `Product` em seu nome em maiúsculas.

#### Expressão Lambda Inline

Nesta abordagem, você utiliza uma expressão lambda diretamente dentro do método map, sem a necessidade de declarar uma variável separada.

        List<String> newList = list.stream()
                        .map(p -> p.getName().toUpperCase())
                        .collect(Collectors.toList());


- **`p -> p.getName().toUpperCase()`**: Neste caso, a expressão lambda é passada diretamente para o método map. Para cada objeto `Product`, ela chama `getName()` e converte o resultado para maiúsculas.
- **`map(p -> p.getName().toUpperCase())`**: O método map aplica a transformação inline a cada elemento do fluxo.








