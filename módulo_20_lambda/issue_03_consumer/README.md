# Expressão Lambda

## Introdução

Imagine que você deseja implementar **um aumento de 10%** nos preços dos produtos da sua loja para refletir melhor os custos operacionais e garantir a sustentabilidade do negócio. Os produtos da loja estão em uma **lista e o programa deve passar por cada elemento** implementando 10% no preço de cada produto.

## Usando `list.forEach`

O método list.forEach em Java é utilizado para realizar uma operação específica em cada elemento de uma lista, como um ArrayList.

#### Funcionamento do `forEach`:

- **Iteração:** O método `forEach()` percorre cada elemento da lista até que todos tenham sido processados ou até que uma exceção seja lançada durante a execução da ação especificada.
- **Parâmetro:** O método aceita um único parâmetro, que é **uma instância da interface funcional Consumer**.
- **Sintaxe:**

        list.forEach(new PriceUpdate());

## Classe `PriceUpdate`

#### A Interface Funcional Consumer:

- A classe `PriceUpdate` implementa a Interface Funcional Consumer:


        public interface Consumer<T> {
            void accept(T t);
        }


- A interface funcional Consumer em Java é parte do pacote `java.util.function` e é usada para representar uma operação que **aceita um único argumento e não retorna nenhum resultado**. Essa interface é especialmente útil em contextos onde você deseja e**xecutar uma ação em um objeto**, como imprimir, modificar ou processar dados, sem a necessidade de retornar um valor.

#### Uso na Main

        //Usando uma instância da Classe PriceUpdate
        //list.forEach(new PriceUpdate());

- Quando você usa `list.forEach(new PriceUpdate())`, o método `forEach` itera sobre cada elemento da lista e chama o método `accept` da instância de PriceUpdate para cada elemento. Isso faz com que a **lógica de atualização de preço seja aplicada a cada produto na lista**.
- A classe PriceUpdate pode ter mais de um método, e isso não afetaria sua funcionalidade como uma implementação da `interface funcional Consumer`.

## Outras Formas de Usar Consumer na Main

#### Usando uma declaração de expressão Lambda

Você pode declarar uma **variável Consumer** e atribuir a ela uma **expressão lambda**. Isso permite reutilizar o Consumer em diferentes partes do código.


        double factor = 1.1;
                
        Consumer<Product> cons = p -> {
            p.setPrice(p.getPrice() * factor);
        };

- Neste exemplo, uma expressão lambda é atribuída à `variável cons`, que pode ser aplicada a cada produto na lista usando `forEach`.

#### Usando expressão lambda inline

Você também pode usar **uma expressão lambda diretamente no método** `forEach` para aplicar o Consumer a cada elemento da lista.

        double factor = 1.1;
                
        list.forEach(p -> p.setPrice(p.getPrice() * factor));

Neste exemplo, uma expressão `lambda inline` é passada diretamente para o método `forEach`, atualizando o preço de cada produto na lista.




