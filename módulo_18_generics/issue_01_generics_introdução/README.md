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