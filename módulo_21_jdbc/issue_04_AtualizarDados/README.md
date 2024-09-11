# Atualizar Dados

## Introdução

Este código Java realiza uma operação de **atualização (UPDATE)** no banco de dados para aumentar o salário base de vendedores de um determinado departamento.

## Inicialização de variáveis


    conn = DB.getConnection();
  
Essa linha obtém uma conexão com o banco de dados através de um método `DB.getConnection()`, que não está mostrado no código, mas geralmente gerencia o processo de conexão com o banco.


## Criação da instrução SQL preparada

    st = conn.prepareStatement(
        "UPDATE seller "
        + "SET BaseSalary = BaseSalary + ? "
        + "WHERE "
        + "(DepartmentId = ?)");

- Esta parte do código cria uma **instrução SQL preparada** utilizando o método `prepareStatement()`. A instrução executa um comando `UPDATE` para atualizar os dados na tabela seller.
- O comando `SET` é usado para definir o novo valor da coluna `BaseSalary`. Neste caso, o valor atual da coluna será incrementado por uma quantia representada pelo `?`, que será substituída posteriormente pelo valor real (definido com `st.setDouble()`).
- O comando `WHERE` especifica uma condição que limita quais registros serão atualizados. Somente os vendedores cujo `DepartmentId` seja igual ao valor fornecido (também representado por um `?`, a ser substituído por `st.setInt()`) terão seu salário ajustado.

Dessa forma, o uso de placeholders `(?)` permite que a mesma instrução SQL seja reutilizada com diferentes valores, tornando o código mais seguro contra injeção de SQL e mais eficiente.

## Definindo os parâmetros

    st.setDouble(1, 200.0);
    st.setInt(2, 2);


- O primeiro `?` é substituído pelo valor `200.0`, ou seja, o salário base será aumentado em 200 unidades monetárias.
- O segundo `?` é substituído pelo valor 2, indicando que a atualização será feita apenas para vendedores que pertencem ao departamento de ID 2.
