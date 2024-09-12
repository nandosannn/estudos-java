# Transações

## Introdução

ACID é um acrônimo que se refere a quatro propriedades fundamentais de transações em sistemas de gerenciamento de banco de dados: Atomicidade, Consistência, Isolamento e Durabilidade. Essas propriedades garantem que as transações sejam processadas de forma confiável e que os dados permaneçam consistentes, mesmo em caso de falhas.

- **Atomicidade:** A atomicidade assegura que todas as operações de uma transação sejam tratadas como uma única unidade de trabalho. 
- **Consistência:** A consistência garante que os dados estejam em um estado válido antes e depois da transação. 
- **Isolamento:** O isolamento assegura que o estado intermediário de uma transação não seja visível para outras transações.
- **Durabilidade:** A durabilidade garante que, uma vez que uma transação é concluída com sucesso, as alterações feitas nos dados persistem, mesmo em caso de falhas no sistema.

## Métodos Importantes

Os métodos setAutoCommit(false), commit() e rollback() pertencem à interface Connection da biblioteca JDBC (Java Database Connectivity) e são fundamentais na gestão de transações em bancos de dados, especialmente ao utilizar JDBC (Java Database Connectivity). Cada um desses métodos desempenha um papel crucial na forma como as transações são controladas e garantem a integridade dos dados.

#### `setAutoCommit(false)`
- O método `setAutoCommit(false)` desativa o modo de autocommit para a conexão com o banco de dados. Quando o autocommit está habilitado (o que é o padrão), cada instrução SQL é tratada como uma transação individual que é automaticamente confirmada após a execução. Ao definir `setAutoCommit(false)`, o desenvolvedor assume o controle sobre quando as transações começam e terminam. Isso é essencial para operações que envolvem múltiplas instruções SQL que precisam ser tratadas como uma única unidade de trabalho, garantindo que todas as operações sejam bem-sucedidas antes de serem confirmadas.
#### `commit()`
- O método `commit()` é utilizado para confirmar todas as alterações realizadas na transação atual. Quando chamado, ele grava todas as operações executadas desde o último setAutoCommit(false) ou desde o início da transação. Se todas as operações forem bem-sucedidas, o `commit()` garante que as alterações sejam permanentes no banco de dados. Por exemplo, em uma transferência de fundos entre contas, o `commit()` assegura que tanto a retirada quanto o depósito sejam aplicados.
#### `rollback()`
- O método `rollback()` é utilizado para reverter todas as alterações realizadas na transação atual, caso ocorra um erro ou exceção. Isso é crucial para manter a integridade dos dados, pois garante que, se uma parte da transação falhar, nenhuma das alterações realizadas seja aplicada. Por exemplo, se a retirada de uma conta for bem-sucedida, mas a adição à outra conta falhar, o `rollback()` pode ser chamado para desfazer a retirada, evitando inconsistências.

## Analise do Código

#### Desativando o Modo de Autocommit

Note que:

    conn.setAutoCommit(false);

- O modo de autocommit é desativado, o que significa que as alterações feitas na conexão não serão automaticamente confirmadas após cada operação. O desenvolvedor agora deve gerenciar manualmente quando confirmar (commit) ou reverter (rollback) as transações.

#### Executando a Primeira Atualização

Note que:

    int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

Esta linha executa uma instrução SQL que atualiza o salário base dos vendedores no departamento com `DepartmentId = 1`. O método `executeUpdate()` retorna o número de linhas afetadas pela operação, que é armazenado na variável `rows1`.

#### Comentário sobre o Tratamento de Erros

    //int x = 1;
    //if (x < 2) {
    //	throw new SQLException("Fake error");
    //}

Este trecho de código está comentado, mas ele ilustra como um erro pode ser simulado. Se a variável `x` fosse menor que 2, uma exceção `SQLException` seria lançada. Isso poderia ser utilizado para testar o comportamento do código em caso de falha.

#### Confirmando a Transação

    conn.commit();

Se ambas as atualizações forem bem-sucedidas, o método `commit()` é chamado para confirmar todas as alterações feitas na transação. Isso torna as mudanças permanentes no banco de dados.

#### Tratamento de Exceções

    catch (SQLException e) {
        try {
            conn.rollback();
            throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
        } 
        catch (SQLException e1) {
            throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
        }
    }

Se ocorrer uma SQLException durante a execução das instruções SQL, o bloco catch é acionado. Dentro dele:
- O método `rollback()` é chamado para reverter todas as alterações feitas na transação, garantindo que o banco de dados permaneça em um estado consistente.
- Se o `rollback()` falhar, uma nova exceção (DbException) é lançada, indicando que houve um erro ao tentar reverter a transação.