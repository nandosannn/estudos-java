## Delimitador Super

Com Delimitador Super é possível acessar qualquer super classe de um tipo específico.

- Exemplo:

        List<Object> myObjs = new ArrayList<Object>();
        myObjs.add("Maria");
        myObjs.add("Alex");
        List<? super Number> myNums = myObjs;

- Note que com o Delimitador Super é possóvel copiar uma lista pra outro, pois ``myObjs``é do tipo Object, super classe de ``Number``

- Além disso é possível adicionar elementos à lista tanto do tipo ``Number`` como super tipo como ``String``.

