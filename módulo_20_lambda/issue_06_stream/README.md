# Stream

## Introdução

Uma stream é uma sequência de elementos originada de uma fonte de dados, que permite a execução de operações agregadas. Essa fonte pode ser uma coleção, um array, uma função de iteração ou um recurso de entrada/saída. O processamento de uma stream é realizado através de um pipeline que consiste em zero ou mais operações intermediárias e uma operação terminal.

## Operações Intermediárias

As operações intermediárias produzem uma nova stream e são executadas de forma preguiçosa (lazy evaluation), ou seja, elas só são processadas quando uma operação terminal é invocada. 

#### Exemplos de operações intermediárias incluem:

- **`filter(Predicate<? super T> predicate):`** Filtra os elementos da stream com base em um **predicado fornecido**. Apenas os elementos que satisfazem a condição (onde o predicado retorna true) são incluídos na **nova stream** resultante.

**Exemplo:**


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenNumbers = numbers.stream()
                                        .filter(n -> n % 2 == 0)
                                        .collect(Collectors.toList());
        System.out.println(evenNumbers); // Output: [2, 4]

<br>

- **`map(Function<? super T,? extends R> mapper):`** **Transforma** cada elemento da stream aplicando uma função fornecida. O resultado é uma **nova stream** que contém os **elementos transformados**.
  
**Exemplo:**

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> uppercaseNames = names.stream()
                                        .map(String::toUpperCase)
                                        .collect(Collectors.toList());
        System.out.println(uppercaseNames); // Output: [ALICE, BOB, CHARLIE]
<br>

- **`distinct():`** Remove **elementos duplicados** da stream, retornando uma nova stream que contém apenas elementos únicos.
  
**Exemplo:**

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> uniqueNumbers = numbers.stream()
                                            .distinct()
                                            .collect(Collectors.toList());
        System.out.println(uniqueNumbers); // Output: [1, 2, 3, 4, 5]

<br>

- **`sorted():`** Ordena os elementos da stream de acordo com a ordem natural ou **um comparador fornecido**. Retorna uma nova stream com os elementos ordenados.

**Exemplo:**

        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
        List<String> sortedNames = names.stream()
                                        .sorted()
                                        .collect(Collectors.toList());
        System.out.println(sortedNames); // Output: [Alice, Bob, Charlie]

<br>

## Operações Terminais
As operações terminais produzem um resultado não-stream, como uma coleção ou outro valor. Elas determinam o fim do processamento da stream.

#### Exemplos de operações terminais incluem:

- **`forEach(Consumer<? super T> action)`**: Executa uma ação fornecida para cada elemento da stream. É uma operação terminal que não retorna uma nova stream.

**Exemplo:**

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
            .forEach(System.out::println);
        // Output: 1 2 3 4 5 (cada número em uma linha)
<br>

- **`toArray():`** Converte a stream em um array. Pode ser usado para criar um array de um tipo específico, como String[] ou Integer[].

**Exemplo:**

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        String[] namesArray = names.stream()
                                .toArray(String[]::new);
        System.out.println(Arrays.toString(namesArray));
        // Output: [Alice, Bob, Charlie]

<br>

- **`reduce(T identity, BinaryOperator<T> accumulator):`** Realiza uma operação de redução sobre os elementos da stream, usando um acumulador. Retorna um único valor que é o resultado da aplicação repetida do acumulador aos elementos da stream.


**Exemplo:**

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                        .reduce(0, Integer::sum);
        System.out.println(sum); // Output: 15

<br>

- **`collect(Collector<? super T, A, R> collector):`** Coleta os elementos da stream em uma coleção, como uma lista ou um conjunto. É uma operação terminal comum para transformar uma stream em uma coleção.


**Exemplo:**

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Set<String> namesSet = names.stream()
                                    .collect(Collectors.toSet());
        System.out.println(namesSet); // Output: [Alice, Bob, Charlie]

<br>

- **`min(Comparator<? super T> comparator):`** Retorna o menor elemento da stream de acordo com um comparador fornecido, encapsulado em um Optional.

- **`max(Comparator<? super T> comparator):`** Retorna o maior elemento da stream de acordo com um comparador fornecido, encapsulado em um Optional.


**Exemplo:**

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> minNumber = numbers.stream()
                                            .min(Integer::compareTo);
        Optional<Integer> maxNumber = numbers.stream()
                                            .max(Integer::compareTo);
        System.out.println(minNumber.get()); // Output: 1
        System.out.println(maxNumber.get()); // Output: 5

<br>


- **`count():`** Conta o número de elementos na stream e retorna um long representando essa contagem.


**Exemplo:**

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        long count = names.stream()
                        .count();
        System.out.println(count); // Output: 3

<br>

- **`anyMatch(Predicate<? super T> predicate):`** Retorna true se qualquer elemento da stream corresponder ao predicado fornecido, caso contrário, retorna false.


- **`allMatch(Predicate<? super T> predicate):`** Retorna true se todos os elementos da stream corresponderem ao predicado fornecido, caso contrário, retorna false.


- **`noneMatch(Predicate<? super T> predicate):`** Retorna true se nenhum elemento da stream corresponder ao predicado fornecido, caso contrário, retorna false.


**Exemplo:**

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean hasEven = numbers.stream()
                                .anyMatch(n -> n % 2 == 0);
        boolean allPositive = numbers.stream()
                                    .allMatch(n -> n > 0);
        boolean noNegative = numbers.stream()
                                    .noneMatch(n -> n < 0);
        System.out.println(hasEven);     // Output: true
        System.out.println(allPositive);  // Output: true
        System.out.println(noNegative);   // Output: true

<br>


- **`findFirst():`** Retorna o primeiro elemento da stream, encapsulado em um Optional. Essa operação é útil quando a ordem dos elementos é importante.


- **`findAny():`** Retorna qualquer elemento da stream, encapsulado em um Optional. É útil em streams paralelas onde a ordem não é garantida.


**Exemplo:**

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Optional<String> firstNameStartsWithA = names.stream()
                                                    .filter(n -> n.startsWith("A"))
                                                    .findFirst();
        Optional<String> anyNameStartsWithC = names.stream()
                                                .filter(n -> n.startsWith("C"))
                                                .findAny();
        System.out.println(firstNameStartsWithA.orElse("Not found")); // Output: Alice
        System.out.println(anyNameStartsWithC.orElse("Not found"));   // Output: Charlie

<br>

## Métodos `stream()` e `toArray()`

Note que no código criamos uma lista de inteiros chamada `list` com os valores `[3, 4, 5, 10, 7]`. Em seguida, criamos uma stream `st1` a partir dessa lista usando o método `stream()`. Então, usamos o método `toArray()` para converter a stream de volta para um array e imprimimos o resultado usando `Arrays.toString()`. A saída será `[3, 4, 5, 10, 7]`.

**Código:**

        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
        Stream<Integer> st1 = list.stream();
        System.out.println(Arrays.toString(st1.toArray()));

## Método `streamOf()`

Aqui, criamos uma stream `st2` diretamente a partir de uma sequência de strings usando o método estático `of()` da classe Stream. Então, convertemos a stream para um array usando `toArray()` e imprimimos o resultado. A saída será `[Maria, Alex, Bob]`.

**Código:**

        Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(Arrays.toString(st2.toArray()));

## Métodos `iterate()` e `limit()`

O método iterate() da classe Stream em Java permite criar uma stream infinita aplicando repetidamente uma função a um valor inicial. Ele tem a seguinte assinatura:

        static<T> Stream<T> iterate(T seed, UnaryOperator<T> f)

**Onde:**
- `seed` é o valor inicial da stream.
- f é uma função unária `(UnaryOperator<T>)` que será aplicada **repetidamente** a cada elemento para gerar o próximo elemento da stream. Pode ser uma expressão lambda.
- Normalmente, você usaria o método `limit()` em conjunto com iterate() para limitar a stream a um número finito de elementos.

**Exemplo da aplicação dos métodos:**

        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString(st3.limit(10).toArray()));

Neste bloco, usamos o método estático `iterate()` da classe Stream para criar uma stream `st3` de inteiros. O primeiro argumento é o valor inicial `(0)`, e o segundo argumento é uma função que gera o próximo valor na sequência `(x -> x + 2)`. Isso cria uma sequência de números pares começando de 0. Usamos o método `limit(10)` para limitar a stream aos primeiros 10 elementos e então convertemos a stream para um array usando `toArray()`. A saída será `[0, 2, 4, 6, 8, 10, 12, 14, 16, 18]`.

## Sequencia de Fibonacci usando Stream

        Stream<Long> st4 = Stream.iterate(new long[] { 0L, 1L }, p -> new long[] { p[1], p[0] + p[1] }).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(10).toArray()));

<br>

Aqui, criamos uma stream `st4` de números da sequência de Fibonacci usando o método `iterate()`. O primeiro argumento é um array inicial contendo os primeiros dois números da sequência: `[0, 1]`. O segundo argumento é uma função que gera o próximo par na sequência: `p -> new long[] { p, p + p }`. Isso gera pares consecutivos de números de Fibonacci.

Em seguida, usamos o método `map(p -> p)` para extrair apenas o primeiro elemento de cada par (ou seja, os números de Fibonacci propriamente ditos). Então, limitamos a stream aos primeiros 10 elementos usando `limit(10)` e convertemos para um array usando `toArray()`. A saída será `[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]`.

