# Expressões Lambda como Parâmetro

## Introdução

As **expressões lambda em Java** são uma maneira poderosa de implementar interfaces funcionais de forma concisa. Elas permitem que você passe comportamentos como parâmetros, o que pode tornar seu código mais flexível e legível. Neste exemplo, vamos aprimorar a classe ProductService para demonstrar como usar expressões lambda como parâmetros de forma eficaz.

## Classe ProductService

A classe ProductService possui um método chamado `filteredSum`, que calcula a soma dos preços de produtos em uma lista, aplicando um critério de filtragem definido por uma expressão lambda.



    public class ProductService {
    
        public double filteredSum(List<issue_o5_functions.src.entities.Product> list, Predicate<Product> criteria) {
            double sum = 0.0;
            for (Product p : list) {
                if (criteria.test(p)) {
                    sum += p.getPrice();
                }
            }
            return sum;
        }
    }

#### O método filteredSum recebe dois parâmetros:
- **`List<Product> list`**: uma lista de objetos Product que serão processados.
- **`Predicate<Product>`** criteria: um objeto Predicate que define um critério de filtragem para os produtos que **pode ser definido como uma expressão lambda**.

## Uso na Main

Aqui está um exemplo de como você pode usar a classe ProductService com expressões lambda:

    ProductService ps = new ProductService();
            
    double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');

#### Explicando o código:

- O código fornecido cria uma instância da classe `ProductService `chamada `ps` e, em seguida, chama o método `filteredSum` dessa instância, passando uma lista de produtos `(list) `e uma **expressão lambda** como segundo parâmetro.
- A expressão lambda `p -> p.getName().charAt(0) == 'T'` é um objeto `Predicate<Product>` implícito, que define o **critério de filtragem**. Ela verifica se o primeiro caractere do nome de cada produto `(p.getName().charAt(0))` é igual a `'T'`.
- Note que o critério de filtragem poderia ser facilmente mudado por causa da **flexibilidade das expressões lambda**.