# Deletar Dados

## Preparação do Statement SQL

    st = conn.prepareStatement(
        "DELETE FROM department WHERE Id = ?");

Aqui, a aplicação prepara um comando SQL do tipo `DELETE` para remover um registro da tabela department onde o campo `Id` tem um valor específico. O uso de `?` indica que será utilizado um parâmetro para o valor do `Id`.

## Definição do Parâmetro

    st.setInt(1, 5);

Nesta linha, o parâmetro `?` do comando SQL é definido com o valor 5. Isso significa que a aplicação irá deletar o registro com `Id = 5`.

    int rowsAffected = st.executeUpdate();

O comando `executeUpdate()` é chamado para executar o comando `DELETE`no banco de dados. Ele retorna um valor inteiro que indica o número de linhas afetadas pela operação.

## Tratamento de Exceções

    catch (SQLException e) {
        throw new DbIntegrityException(e.getMessage());
    }

Se ocorrer uma exceção de SQL (por exemplo, se o registro com `Id = 5` não existir ou algum dado tiver como chave estrangeiro o `Id = 5`), o código captura essa exceção e a lança novamente como uma `DbIntegrityException`. Essa classe é uma exceção personalizada para indicar problemas de integridade referencial no banco de dados.