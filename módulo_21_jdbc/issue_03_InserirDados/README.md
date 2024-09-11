# Inserir Dados

## A interface **`PreparedStatement`**

A interface PreparedStatement é uma subinterface da interface Statement na API JDBC (Java Database Connectivity). Ela é utilizada para executar consultas SQL parametrizadas, o que oferece várias vantagens em relação ao uso de Statement simples.

#### Características da Interface PreparedStatement
- **Pré-compilação:** Quando um PreparedStatement é criado, a consulta SQL é pré-compilada e armazenada no objeto. Isso significa que a mesma instrução SQL pode ser executada várias vezes com diferentes parâmetros, sem a necessidade de recompilação, o que melhora a eficiência.
- **Segurança:** O uso de PreparedStatement ajuda a prevenir ataques de injeção de SQL. Isso ocorre porque os parâmetros são definidos através de métodos específicos, como setInt(), setString(), etc., em vez de concatenar strings diretamente na consulta SQL.
#### Métodos Importante
  - **`executeQuery()`**: Executa uma consulta SQL e retorna um `ResultSet`.
  - **`executeUpdate()`**: Executa uma instrução SQL que altera o banco de dados (como INSERT, UPDATE ou DELETE). Retorna um valor inteiro que representa o número de linhas que foram afetadas pela execução da instrução SQL
  - **`setXXX()`**: Métodos para **definir os valores dos parâmetros**, onde XXX representa o tipo de dado (por exemplo, setInt, setString).

## Análise do código

#### Preparação da Instrução SQL (EXAMPLE 1)

Note que: 

    conn = DB.getConnection();

    st = conn.prepareStatement(
                        "INSERT INTO seller "
                        + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                        + "VALUES "
                        + "(?, ?, ?, ?, ?)", 
                        Statement.RETURN_GENERATED_KEYS);

- **`conn = DB.getConnection();`**: Obtém uma conexão com o banco de dados através de um método g`etConnection()` da classe DB.
- A instrução SQL é preparada usando `conn.prepareStatement(...)`. A instrução insere dados na tabela seller com colunas para `Name, Email, BirthDate, BaseSalary e DepartmentId`.
- **`Statement.RETURN_GENERATED_KEYS`** é uma constante utilizada em JDBC (Java Database Connectivity) para indicar que as chaves geradas automaticamente pelo banco de dados devem ser retornadas após a execução de um comando SQL INSERT.

##### O método `setXXX()` no código

Note que:

    st.setString(1, "Carl Purple");
                st.setString(2, "carl@gmail.com");
                st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
                st.setDouble(4, 3000.0);
                st.setInt(5, 4);

Essas linhas de código são usadas para definir os **valores que serão inseridos** na tabela **seller** do banco de dados. O `PreparedStatement (st)` permite que você insira valores de forma segura e eficiente usando parâmetros marcados com `?` na instrução SQL. A seguir, explico cada linha:

**`st.setString(1, "Carl Purple");`**:

  - Este comando define o valor do primeiro parâmetro `(?)` na instrução SQL.
  - Aqui, `"Carl Purple"` é definido como o valor para a coluna **Name** da tabela **seller**.
  - `1` indica que este é o primeiro parâmetro na ordem dos `?` na instrução SQL.

A mesma lógica é seguida para os outros dados.

## Métodos `st.executeUpdate()` e `st.getGeneratedKeys()`

Note que:

    int rowsAffected = st.executeUpdate();

Executa a instrução SQL preparada no `PreparedStatement (st)` e retorna o número de linhas afetadas pela execução da instrução.

Já aqui:

    ResultSet rs = st.getGeneratedKeys();
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        System.out.println("Done! Id: " + id);
                    }

A linha ResultSet `rs = st.getGeneratedKeys()`; está sendo usada para recuperar as chaves geradas automaticamente pelo banco de dados como resultado da execução de um comando `SQL INSERT`. É usado o método `rs.next()` para acessar todas as chaves retornadas pelo método anterior.