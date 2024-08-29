
## Curinga Delimitado Extends 

Os curingas podem ser **delimitados por extends ou super**. Curinga com extends: permite que você trabalhe com uma lista de um tipo específico ou de seus subtipos.

- O método ``totalArea`` do programa é um exemplo da aplicação: 

        Public static double totalArea(List<? extends Shape> list) {
        double sum = 0.0;
        for (Shape s : list) {
            sum += s.area();
        }

- Note que por o método utilizar ``List<? extends Shape> list`` ele aceita trabalhar com listas do tipo ``Shape`` como também de suas subclasses: ``Rectangle`` e ``Circle``.

- Quando se uso o tipo delimitador extends não é possível adicionar elemento à coleção é possível apenas acessar os elementos.

> Compilar o programa através do arquivo ``Makefile`` com o comando ``make``no terminal do linux.