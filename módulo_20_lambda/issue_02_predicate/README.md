# Expressão Lambda

## Introdução

As expressões lambda em Java são uma característica introduzida na versão 8 da linguagem, permitindo a criação de funções anônimas de forma mais concisa e expressiva. Elas são especialmente úteis para implementar interfaces funcionais, que são interfaces que contêm exatamente um método abstrato.

#### Estrutura das Expressões Lambda

Uma expressão lambda é composta por três partes principais:

- **Lista de Parâmetros:** Os parâmetros que a expressão lambda recebe, que podem ter tipos explícitos ou ser inferidos pelo compilador.
- **Operador "`->`":** Este símbolo separa os parâmetros do corpo da expressão.
- **Corpo da Expressão:** Contém a lógica que será executada. O corpo pode ser uma única expressão ou um bloco de código encapsulado em chaves {}.

**Exemplo:**

        (int a, int b) -> a + b


## O que é uma Interface Funcional?

Uma interface funcional é **uma interface que contém exatamente um método abstrato**. Isso permite que a interface seja implementada de forma concisa **usando uma expressão lambda**. A anotação `@FunctionalInterface` pode ser usada para indicar que uma interface é funcional, embora não seja obrigatória. Se uma interface é marcada com essa anotação, o compilador irá gerar um erro se houver **mais de um método abstrato**.


## Interface Funcional Predicate

- `Predicate<T>`: Representa uma função que recebe um argumento e retorna um valor booleano:


        public interface Predicate<T> {
            boolean test(T t);
        }

**Exemplo de Implementação da Interface Funcional Predicate:**

    public class MyPredicate implements Predicate<Product>{

        @Override
        public boolean test(Product p) {
            return p.getPrice() >= 100.0;
        }  
    }

**Aplicando Predicate na Main**

    public static void main(String[] args) {
            List<Product> list = new ArrayList<>();
            
            list.add(new Product("Tv", 900.00));
            list.add(new Product("Mouse", 50.00));
            list.add(new Product("Tablet", 350.50));
            list.add(new Product("HD Case", 80.90));
            
            //Usando a Classe MyPredicate com a implementação da Interface Funcional Predicate
            list.removeIf(new MyPredicate()); //Remove todos os elementos com preço maior que 100.
    }

#### Outras formas de aplicar Predicate na Main:

- **Expressão lambda declarada:**

Uma forma de utilizar um Predicate é declará-lo como uma variável antes de usá-lo. Isso pode ser útil quando você deseja reutilizar o mesmo critério em diferentes partes do código.

        //Predicate<Product> pred = p -> p.getPrice() >= 100.0;
        list.removeIf(pred);


- **Expressão lambda inline:**

Outra forma de aplicar um Predicate é utilizando uma expressão lambda inline diretamente no método removeIf(). Essa abordagem é mais concisa e pode ser preferida quando o critério é simples e não precisa ser reutilizado.

        //Expressão lambda Inline
        list.removeIf(p -> p.getPrice() >= 100.0);



#### Por que Expressões Lambda Funcionam Apenas com Interfaces Funcionais?
- **Simplicidade e Clareza:** As expressões lambda foram introduzidas para simplificar a sintaxe ao implementar interfaces funcionais. Se uma interface tivesse múltiplos métodos abstratos, não haveria uma maneira clara de determinar qual método a expressão lambda deveria implementar. Com uma única função, a intenção é clara.
- **Flexibilidade e Reutilização:** As expressões lambda permitem que você crie implementações de métodos de forma rápida e reutilizável. Isso é especialmente útil em APIs que utilizam programação funcional, como a Stream API, onde você pode passar comportamentos como argumentos.
- **Compatibilidade com Programação Funcional**: As expressões lambda são uma forma de programação funcional, que enfatiza a utilização de funções como valores. As interfaces funcionais são a base para essa abordagem, permitindo que funções sejam passadas como parâmetros, retornadas de métodos e armazenadas em variáveis.


