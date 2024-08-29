
#### [issue_03_generics_curinga]()

Nesse programa é introduzido o tipo **curinga** ``?``. O tipo coringa é utilizado em situações onde você não precisa **especificar um tipo concreto**, mas ainda deseja trabalhar com **coleções ou métodos** que aceitam múltiplos tipos. 

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
