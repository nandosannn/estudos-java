# Recuperar Dados

## A Interface `Connection`

**Connection** é uma interface fundamental na API JDBC (Java Database Connectivity) que representa uma conexão com um banco de dados. Ela fornece métodos essenciais para interagir com o banco de dados, permitindo que os desenvolvedores executem consultas SQL, gerenciem transações e manipulem dados.

#### Estabelecimento de Conexão:

- Para criar uma conexão, geralmente se utiliza a classe DriverManager e seu método getConnection(), que aceita uma URL de conexão, um nome de usuário e uma senha. 

#### Métodos Importantes:

- **`createStatement()`**: Cria um objeto `Statement` para enviar instruções SQL ao banco de dados .

**Exemplo no código**:

        Connection conn = null; 
        Statement st = null;

        conn = DB.getConnection(); // Estabelecendo a conexão com o banco de dados
        st = conn.createStatement(); // Criando um objeto Statement

## O que é um `Statement`?

- O objeto `Statement` é uma interface que permite a execução de instruções SQL, como consultas (SELECT), inserções (INSERT), atualizações (UPDATE) e exclusões (DELETE).
- Uma vez que você tenha um objeto `Statement`, pode usá-lo para executar comandos SQL e manipular dados no banco de dados.

#### Métodos importantes de `Statement`

1. **`executeQuery(String sql)`**
   - **Descrição:** Este método é utilizado para executar uma instrução SQL que retorna um conjunto de resultados, geralmente uma consulta SELECT.
   - **Retorno:** Retorna um objeto ResultSet que contém os dados retornados pela consulta.
   - **Uso:** Ideal para consultas que precisam retornar dados do banco de dados.

**Exemplo:**

    ResultSet rs = stmt.executeQuery("SELECT * FROM department");

2. **`executeUpdate(String sql)`**
   - **Descrição:** Este método é usado para executar instruções SQL que alteram os dados no banco de dados, como INSERT, UPDATE ou DELETE.
   - **Retorno:** Retorna um inteiro que representa o número de linhas afetadas pela execução da instrução SQL.
   - **Uso:** Utilizado quando se espera que a operação modifique dados e retorne a contagem de registros afetados.

**Exemplo:**

    int rowsAffected = stmt.executeUpdate("UPDATE department SET Name='New Name' WHERE Id=1");

3.**`execute(String sql)`**
   - **Descrição:** Este método é mais genérico e pode ser usado para executar qualquer instrução SQL, incluindo DDL (Data Definition Language) e DML (Data Manipulation Language).
   - **Retorno:** Retorna um booleano; true se o resultado é um ResultSet e false se é uma contagem de atualização.
   - **Uso:** Útil quando não se tem certeza se a instrução SQL retornará um conjunto de resultados ou apenas uma contagem de linhas afetadas.

**Exemplo:**

    boolean hasResultSet = stmt.execute("SELECT * FROM department");

## A Classe ResultSet

A classe ResultSet é uma parte essencial da API JDBC (Java Database Connectivity) e representa um conjunto de resultados obtidos a partir de uma consulta SQL executada em um banco de dados.

#### Definição e Estrutura

- **Representação de Dados:** Um ResultSet é uma tabela de dados que é gerada ao executar uma instrução SQL, geralmente uma consulta SELECT. Ele contém linhas e colunas, onde cada linha representa um registro do banco de dados e cada coluna representa um campo desse registro.
- **Cursor:** O ResultSet mantém um cursor que aponta para a linha atual de dados. Inicialmente, o cursor está posicionado antes da primeira linha. O método `next()` é utilizado para mover o cursor para a próxima linha, e ele retorna false quando não há mais linhas para processar.

#### Métodos Comuns

**Navegação**:
- **`first()`**: MOve o cursos para a primeira linha.
- **`next():`** Move o cursor para a próxima linha e retorna true se houver mais linhas.
- **`absolute(int row):`** Move o cursor para a linha especificada.
- **`beforeFirst():`** Move o cursor para antes da primeira linha.

**Acesso aos Dados**:
- **`getInt(int columnIndex):`** Retorna o valor da coluna especificada como um inteiro.
- **`getString(String columnName):`** Retorna o valor da coluna especificada como uma string.
- **`getObject(int columnIndex):`** Retorna o valor da coluna como um objeto 
Java.

**Atualização de Dados** (se o ResultSet for updatable):

- **`updateString(String columnName, String value):`** Atualiza o valor da coluna especificada.
- **`updateRow():`** Salva as alterações feitas na linha atual.

**Metadados**:
- **`getMetaData():`** Retorna um objeto ResultSetMetaData que fornece informações sobre as colunas do ResultSet, como nomes e tipos de dados.

## Processamento dos Dados no código

#### Execução da Consulta SQL

    rs = st.executeQuery("select * from department");

- **`st:`** Esta variável representa um objeto Statement, que é usado para enviar instruções SQL ao banco de dados.
- **`executeQuery`**: Este método é utilizado para executar uma instrução SQL que retorna um conjunto de resultados (neste caso, uma consulta SELECT).
- **`"select * from department"`**: Esta é a consulta SQL que está sendo executada. Ela seleciona todas as colunas (*) da tabela department.

#### Acesso aos Resultados

    while (rs.next()) {
        System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
    }

- **`rs`**: Esta variável representa um objeto ResultSet, que contém os dados retornados pela consulta SQL.
- **`rs.next()`**: Este método move o cursor do `ResultSet` para a próxima linha. Ele retorna `true` se houver uma linha a ser processada e `false` se não houver mais linhas. O loop while continuará enquanto houver linhas disponíveis.
- **`rs.getInt("Id")`**: Este método obtém o valor da coluna `"Id"` da linha atual do `ResultSet` como um inteiro.
- **`rs.getString("Name")`**: Este método obtém o valor da coluna `"Name"` da linha atual do `ResultSet` como uma `string`.
