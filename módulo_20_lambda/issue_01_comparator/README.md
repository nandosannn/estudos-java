# *Interface Comparable*

## Introdução

Suponha uma classe Product com os atributos name e price. Podemos implementar a comparação de produtos por meio da
implementação da interface `Comparable<Produc t>`.

#### Classe `Product`

  
- Implemento da Interface `Compable<Product>`
    
        Public class Product implements Comparable<Product>

- Implemento do método `compareTo` da `Interface ComparableTo`

        @Override
            public int compareTo(Product p){
                return name.toUpperCase().compareTo(p.getName().toUpperCase());
            }

#### Uso na `Main`

- Exemplo:
  

        List<Product> list = new ArrayList<>();
                
        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));
                
        Collections.sort(list); // Ordenar a lista comparadando os elemtnos
                
        for (Product p : list) {
            System.out.println(p);
        }


Entretanto, desta forma nossa classe não fica fechada para alteração: se o critério de comparação mudar, precisaremos **alterar a classe `Product`**.

## Usando *`list.sort`*

Para resolver esse problema podemos usar o `default method sort` da interface List: `default void sort(Comparator<? super E> c)`.

- O `default method sort` usa como argumento um `Comparator`, que é uma interface funcional, ou seja, uma interface que possui apenas **um método**. O método a ser implementado na interface é o `compare(T o1, T o2)`.

**Exemplo da implementação**:


        public class myComparetle implements Comparator<Product>{

            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
            }
        }

#### Uso na Main

        import entities.myComparetle; //importar biblioteca

        list.sort(new MyComparator()); //usando myCOmparator como argumento

## Implementação do Comparator em uma Classe anônima

É possível implementar a classe Comparator em uma classe anônima:

**Exemplo:**

            //Implementação de uma classe anônima
		Comparator<Product> comp = new Comparator<Product>(){
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
			}
		};

## Implementação da Classe anônima com Lambda

A implementação com Lambda é uma maneira moderna e eficiente de definir comparadores em Java. Ela melhora a legibilidade e a manutenção do código, tornando-o mais alinhado com as práticas contemporâneas de programação em Java.

#### Implementação da Classe Comparator com Lambda

        Comparator<Product> comp = (p1, p2) -> { return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()); };

##### Analise do código

- `(p1, p2)` são os parâmetros da função, representando os dois objetos `Product` que você deseja comparar.
- `->` é o operador que separa os parâmetros da implementação do método.
- O resultado de `compareTo()` é retornado diretamente como resultado da comparação. Se `p1 é menor que p2`, o método retorna um valor negativo; se são iguais, retorna zero; e se p1 é maior, retorna um valor positivo.

