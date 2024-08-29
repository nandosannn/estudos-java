## Delimitador Super

### Introdução
O delimitador super em Java permite acessar qualquer superclasse de um tipo específico, proporcionando maior flexibilidade ao trabalhar com coleções e herança.

📝 Exemplo:

        List<Object> myObjs = new ArrayList<Object>();
        myObjs.add("Maria");
        myObjs.add("Alex");
        List<? super Number> myNums = myObjs;

-  No exemplo acima, ``myObjs`` é uma lista de ``Object``, que é a superclasse de todos os tipos em Java. A lista ``myNums`` utiliza o delimitador ``<? super Number>``, ou seja, ela pode **aceitar qualquer tipo** que seja uma **superclasse de Number**, incluindo o próprio Number. 💡
- Isso permite que se **copie elementos de uma lista para outra**, já que ``myObjs`` é do tipo ``Object``, que é uma superclasse de ``Number``.
- Além disso, é possível adicionar elementos do tipo ``Number`` ou qualquer subtipo de ``Number`` à lista ``myNums``. 

:x: No entanto, não é possível **acessar diretamente os elementos** da lista ``myNums`` de forma tipada, pois o compilador não tem certeza do tipo exato dos elementos.

### Função *copy*

A função ``copy`` recebe como argumentos uma lista do tipo ``<? extends Number>`` e outra do tipo ``<? super Number>``. Isso permite que a função acesse os elementos da primeira lista e os adicione à segunda lista, **garantindo a flexibilidade e segurança no uso** de tipos genéricos.
     
       public static void copy(List<? extends Number> source, List<? super Number> destiny) {
		for(Number number : source) {
			destiny.add(number);
		}
	  }

- **Explicação**: A lista `source` é do tipo `<? extends Number>`, o que significa que pode ser uma lista de `Number` ou de qualquer subtipo de Number. A lista `destiny` é do tipo` <? super Number>`, permitindo que qualquer tipo que seja `superclasse` de `Number` possa ser inserido nela. Dessa forma, todos os elementos da lista source podem ser **adicionados** à lista `destiny`.




