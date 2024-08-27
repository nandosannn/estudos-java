# Generics

## Introdução

Estruturas que aceitam qualquer tipo de variável e faz a segurança de tipos, ou seja, só aceita um mesmo tipo de variável. É uma solução eficiente para usar a mesma implementação para diferentes tipos de variáveis.


## Programas
#### [issue_01_generics](https://github.com/nandosannn/estudos-java/tree/main/m%C3%B3dulo_18_generics/issue_01_generics)
Esse programa é um exemplo de **aplicação de classe e métodos genéricos**.
<br>
- Note que uma classe genérica é definida por ``<T>`` onde ``T`` é uma variável genérica. Exemplo:

        public class PrintService<T>{}
- Métodos genéricos com argumento genérico:

        public void addValue(T value) { }
- Meótodo que retorna um atributo genérico:
        
        public T first() { return T }
- O tipo **genérico** é usado para fazer operações que independem do tipo do atributo como trabalhar com métodos void.
<br>
- Ao instanciar uma classe genérica é obrigatório especificar o tipo que vai ser trabalhado. Exemplo:

        PrintService<Integer> ps = new PrintService<>();
    - *Obs:* Para trabalhar com inteiros na classe.
<br>

> Compilar o programa através do arquivo ``Makefile`` com o comando ``make``no terminal do linux.

#### [issue_02_generics]()

Esse programa é um exemplo da aplicação de generics na **Interface Comparable**.

<br>

- Para que o método **compareTo** funcione com um tipo T genérico é preciso que o **método tenha uma herança da Classe Comparable** de um tipo genérico T.

        public static <T extends Comparable<T>> T max(List<T> list){ }
-  Tipo **genérico T** é limitado a *classes que implementam a interface ``Comparable<T>``.

        public class Product implements Comparable<Product>{ }
- Para usar a **interface Comparable** é preciso implementar o método **compareTo** especificando qual atributo vai ser comparado.

        @Override
        public int compareTo(Product other) { }

- Desse modo é possível usar normalmente o **Método compareTo**, por exemplo:

        if (item.compareTo(max) > 0) {
			max = item;
		}
- Uso na main:

        Product x = CalculationService.max(list);

    - Por ser um método ``static``não é necessário instanciar o objeto para usar o método ``max``.

<br>

> Compilar o programa através do arquivo ``Makefile`` com o comando ``make``no terminal do linux.

#### [issue_03_generics_coringa]()

Nesse programa é introduzido o tipo **coringa** ``?``. O tipo coringa é utilizado em situações onde você não precisa **especificar um tipo concreto**, mas ainda deseja trabalhar com **coleções ou métodos** que aceitam múltiplos tipos. 

- Exemplo de uso no programa:

        List<?> myObjs = new ArrayList<Object>();

- Note que ao executar o comando vai haver um erro de compilação:

        List<Integer> myNumbers = new ArrayList<Integer>();
        //myObjs = myNumbers; // erro de compilação

- A linha ``myObjs = myNumbers;`` gera um erro de compilação. Embora **``myObjs``** possa referenciar uma lista de qualquer tipo, o compilador não permite que você atribua uma lista de um tipo específico **``(como List<Integer>)``** a uma variável de tipo coringa ``(List<?>)``. Isso ocorre porque o compilador não pode **garantir que a lista ``myObjs`` aceitará elementos do tipo ``Integer``**.

- Além disso não é possível **adicionar elementos** a uma lista do tipo coringa. Apenas acessar os elemntos como no exemplo:

        public static void printList(List<?> list) {
            for (Object obj : list) {
                System.out.println(obj);
            }
        }

> Compilar o programa através do arquivo ``Makefile`` com o comando ``make``no terminal do linux.

    











