
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
