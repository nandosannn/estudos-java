# Bibliotecas de Persistence (JPA e Jakarta)

Essa biblioteca é parte do Jakarta EE, a evolução do Java EE. Ela oferece a API para mapear classes Java para tabelas em bancos de dados relacionais (ORM – Object Relational Mapping). No caso, ela fornece as anotações e funcionalidades necessárias para realizar esse mapeamento e persistência dos objetos Java como registros no banco de dados.



**`@Entity:`** Essa anotação indica que a classe User é uma entidade JPA. Cada instância dessa classe será mapeada para uma linha de uma tabela do banco de dados.

**`@Table(name = "tb_user"):`** Especifica a tabela do banco de dados onde essa entidade será mapeada. No caso, a tabela será chamada tb_user. Se essa anotação não fosse usada, o JPA adotaria o nome da classe (User) como nome da tabela.

**`@Id:`** Define o atributo id como a chave primária da entidade, ou seja, cada objeto User será identificado de forma única pelo seu id.

**`@GeneratedValue(strategy = GenerationType.IDENTITY):`** Essa anotação indica que o valor do campo id será gerado automaticamente pelo banco de dados (normalmente usando auto-increment). O GenerationType.IDENTITY especifica que o banco de dados controla a geração do identificador, como no caso de campos auto-incrementáveis no MySQL ou H2.