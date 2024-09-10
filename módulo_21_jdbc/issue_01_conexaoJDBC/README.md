# A Classe `DB`

É uma implementação de uma classe para gerenciar conexões com um banco de dados em Java. A classe se chama DB e contém métodos para obter e fechar conexões, além de carregar propriedades de um arquivo.

## Método `loadProperties()`

Responsável por carregar as propriedades da conexão com o Banco de Dados.

    private static Properties loadProperties() throws Exception {
            try (FileInputStream fs = new FileInputStream("db.properties")) {
                Properties props = new Properties();
                props.load(fs);
                return props;
            }
            catch (IOException e) {
                throw new Exception(e.getMessage());
            }
    }

- **Método Privado para Carregar Propriedades:** Este método é responsável por carregar as propriedades de configuração do banco de dados a partir de um arquivo.
- **Leitura do Arquivo:** Utiliza um `FileInputStream` para ler o arquivo `db.properties`. As propriedades são carregadas em um objeto `Properties props` através do método `props.load(fs)`;
- **Tratamento de Exceções:** Se ocorrer uma IOException (por exemplo, se o arquivo não for encontrado), uma nova Exception é lançada com a mensagem de erro.

# Método `getConnection()`

É responsável por estabelecer a conexão com o banco de dados.

    public static Connection getConnection() throws Exception {
            if (conn == null) {
                try {
                    Properties props = loadProperties();
                    String url = props.getProperty("dburl");
                    conn = DriverManager.getConnection(url, props);
                }
                catch (SQLException e) {
                    throw new Exception(e.getMessage());
                }
            }
            return conn;
    }

- **Método Estático:** Este método é responsável por fornecer uma conexão ao banco de dados. Ele é declarado como static, permitindo que seja chamado sem criar uma instância da classe.
- **Verificação de Conexão:** O método verifica se a variável conn é null `conn == null`. Se for, isso significa que não há uma conexão ativa.
- **Carregamento das Propriedades:** O método `loadProperties()` é chamado para carregar as propriedades de conexão a partir de um arquivo *(geralmente contendo a URL do banco de dados, usuário e senha)*.
- **Estabelecimento da Conexão:** Utiliza DriverManager.getConnection(url, props) para criar a conexão com o banco de dados.
- **Tratamento de Exceções:** Se ocorrer uma `SQLException`, uma nova Exception é lançada com a mensagem de erro.

# Método `closeConnection()`

É responsável por finalizar a conexão do banco de dados.

    public static void closeConnection() throws Exception {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new Exception(e.getMessage());
                }
            }
        }

- **Método para Fechar a Conexão:** Este método é responsável por fechar a conexão com o banco de dados, se ela estiver aberta.
- **Verificação da Conexão:** O método verifica se a variável `conn` não é null `conn != null`, ou seja, se existe uma conexão ativa.
- **Fechamento da Conexão:** Tenta fechar a conexão com `conn.close()`. Se ocorrer uma `SQLException,` uma nova Exception é lançada com a mensagem de erro.

