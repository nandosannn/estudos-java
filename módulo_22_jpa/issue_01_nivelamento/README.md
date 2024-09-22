# Mapeamento Objeto-Relacional

## Introdução

O **Mapeamento Objeto-Relacional (ORM)** é uma técnica fundamental que permite a interação entre sistemas orientados a objetos, como Java, e bancos de dados relacionais. O Hibernate é um dos frameworks mais populares para implementar ORM em Java, enquanto a Java Persistence API (JPA) é uma especificação que define como gerenciar a persistência de dados em aplicações Java.

## JPA: A Especificação

A JPA é uma especificação que fornece uma interface comum para frameworks ORM, como o Hibernate. Ela define um conjunto de regras e anotações que facilitam o mapeamento entre entidades Java e tabelas do banco de dados. A JPA permite que os desenvolvedores utilizem um modelo consistente para persistência de dados, independentemente da implementação específica do ORM.

#### Vantagens do Uso de ORM

- **Produtividade**: Reduz a quantidade de código necessário para manipulação de dados.
- **Abstração**: Permite trabalhar com objetos em vez de lidar diretamente com SQL.
- **Facilidade na Manutenção**: A estrutura orientada a objetos facilita a manutenção e evolução do código.
- **Portabilidade**: O uso da JPA permite trocar facilmente entre diferentes implementações ORM sem grandes alterações no código.

## O que é Hibernate?

O **Hibernate é um framework ORM** que facilita o mapeamento de classes Java para tabelas em bancos de dados relacionais. Ele permite que os desenvolvedores trabalhem com objetos Java em vez de escrever consultas SQL diretamente, simplificando o processo de persistência de dados.

#### Principais Características do Hibernate

- **Mapeamento de Classes**: O Hibernate mapeia classes Java para tabelas do banco de dados, permitindo que os desenvolvedores manipulem objetos como se fossem entidades reais.
- **Gerenciamento de Transações**: O framework cuida do gerenciamento de transações, garantindo a integridade e consistência dos dados durante as operações.
- **Consultas HQL**: O Hibernate oferece uma linguagem de consulta chamada HQL (Hibernate Query Language), que é semelhante ao SQL, mas mais integrada ao modelo orientado a objetos.
- **Suporte a Anotações JPA**: O Hibernate suporta anotações JPA, facilitando o mapeamento e as associações entre entidades. As anotações como @OneToMany, @ManyToOne e @ManyToMany permitem definir relacionamentos complexos entre as classes.

## Principais Classes do JPA

#### EntityManager

O **EntityManager** é a interface central da **Java Persistence API (JPA)** e é responsável por gerenciar as operações de persistência de entidades. Ele atua como uma ponte entre a aplicação e o banco de dados, permitindo que os desenvolvedores realizem operações como criar, ler, atualizar e excluir entidades.

##### Principais Funcionalidades do EntityManager:
- **Persistência de Entidades**: O método `persist(Object entity)` é utilizado para salvar uma nova entidade no banco de dados.
- **Busca de Entidades**: O método `find(Class<T> entityClass, Object primaryKey)` permite recuperar uma entidade com base na sua chave primária.
- **Remoção de Entidades**: O método `remove(Object entity)` é usado para excluir uma entidade existente do banco de dados.
- **Gerenciamento de Transações**: O `EntityManager` também gerencia transações através dos métodos `getTransaction().begin()`, `commit()` e `rollback()`, permitindo que as operações sejam realizadas dentro de um contexto transacional.

#### EntityManagerFactory

O **EntityManagerFactory** é uma interface que cria instâncias de `EntityManager`. Ele é responsável pela configuração inicial da unidade de persistência, que define como as entidades serão mapeadas para o banco de dados.

##### Principais Características do EntityManagerFactory:

- **Criação de EntityManagers:** O método `createEntityManager()` cria uma nova instância do `EntityManager`. Cada chamada a este método retorna um novo objeto, permitindo múltiplas operações simultâneas.
- **Configurações da Unidade de Persistência:** O `EntityManagerFactory` é configurado através do arquivo `persistence.xml`, onde são especificadas as propriedades do banco de dados, como URL, usuário e senha, além das classes que representam as entidades.
- **Gerenciamento de Recursos:** É fundamental fechar o `EntityManagerFactory` ao final da aplicação usando o método `close()`, garantindo que todos os recursos sejam liberados adequadamente.

## O que é Maven?

**Maven** é uma ferramenta de automação de construção e gerenciamento de projetos amplamente utilizada na comunidade Java. Ela simplifica o processo de gerenciamento de dependências, construção, testes e documentação de projetos, permitindo que os desenvolvedores se concentrem mais na lógica da aplicação do que na configuração do ambiente.

#### Principais Características do Maven

- **Gerenciamento de Dependências:** Maven permite que você declare as bibliotecas necessárias para o seu projeto em um arquivo chamado pom.xml. Ele automaticamente baixa essas dependências de repositórios online, como o Maven Central, e as inclui no seu projeto.
- **Modelo de Projeto:** O Maven utiliza um modelo padronizado para organizar a estrutura dos projetos. Isso inclui convenções sobre onde colocar o código fonte, recursos e testes, facilitando a colaboração entre desenvolvedores.
- **Ciclo de Vida da Construção:** Maven define um ciclo de vida de construção que inclui fases como validate, compile, test, package, verify, install e deploy. Cada fase executa uma série de tarefas específicas, permitindo uma automação eficiente do processo de construção.
- **Plugins:** Maven suporta uma ampla gama de plugins que podem ser usados para estender suas funcionalidades, como plugins para realizar testes automatizados, gerar relatórios, empacotar aplicativos e muito mais.
- **Integração com Ferramentas:** Maven se integra facilmente com várias ferramentas e frameworks populares, como JPA (Java Persistence API) e Hibernate. Isso permite que os desenvolvedores configurem rapidamente suas aplicações para usar essas tecnologias sem a necessidade de configuração manual extensa.

#### Relação com JPA e Hibernate

- **JPA:** É uma especificação para a persistência de dados em Java. O Maven facilita a inclusão das bibliotecas necessárias para usar JPA em um projeto Java através do **gerenciamento automático das dependências** no `pom.xml`.
- **Hibernate:** É uma implementação popular da JPA que fornece funcionalidades adicionais para o mapeamento objeto-relacional. Com o Maven, você pode incluir Hibernate como uma dependência e configurar rapidamente sua aplicação para utilizar suas funcionalidades de persistência.

## Código Main

#### Criação do `EntityManagerFactory`

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");

- **`Persistence.createEntityManagerFactory("exemplo-jpa")`**: Este método estático da classe Persistence cria uma instância de EntityManagerFactory para a unidade de persistência especificada, que neste caso é "exemplo-jpa".
- **`EntityManagerFactory`**: É uma fábrica que gerencia instâncias de EntityManager. Cada EntityManagerFactory é associado a uma unidade de persistência (definida em um arquivo persistence.xml) que contém as configurações necessárias para se conectar ao banco de dados, como URL, usuário, senha e outras propriedades.

#### Criação do `EntityManager`

        EntityManager em = emf.createEntityManager();

- **`emf.createEntityManager()`**: Este método cria uma nova instância de EntityManager a partir da fábrica criada anteriormente.
- **`EntityManager`**: É a interface principal utilizada para interagir com o contexto de persistência. Ele permite realizar operações como inserir, atualizar, remover e consultar entidades no banco de dados.

#### Início da Transação

        em.getTransaction().begin();

- **`getTransaction()`**: Este método retorna um objeto EntityTransaction, que é usado para gerenciar transações em um contexto de persistência.
- **`begin()`**: Chama o método begin() no objeto EntityTransaction, que inicia uma nova transação. A partir deste ponto, todas as operações de persistência realizadas (como inserções, atualizações ou remoções) serão parte dessa transação.

#### Persistência de Objetos

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

- **`persist()`**: Este método é utilizado para marcar os objetos `p1, p2 e p3` (que são instâncias da classe Pessoa) para serem inseridos no banco de dados. Quando você chama `persist()`, o estado do objeto é gerenciado pelo `EntityManager`, e ele será salvo na base de dados quando a transação for confirmada (committed).
- Os objetos são adicionados ao contexto de persistência, mas ainda não são efetivamente salvos no banco até que a transação seja confirmada.

#### Confirmação da Transação

        em.getTransaction().commit();


- **`commit()`**: Este método é chamado no objeto `EntityTransaction` para confirmar a transação. Quando você chama `commit()`, todas as operações de persistência realizadas durante a transação (neste caso, as chamadas a `persist()`) são efetivamente aplicadas ao banco de dados.
- Se não houver erros durante o processo, os dados dos objetos p1, p2 e p3 serão salvos no banco de dados.

#### Explicação do Método find()

        Pessoa p = em.find(Pessoa.class, 2);

- O método **`find()`** é utilizado para recuperar uma entidade a partir do banco de dados usando sua chave primária. Neste caso, ele está buscando uma instância da classe `Pessoa` com o ID igual a 2.
- **`Pessoa.class:`** Este é o tipo da entidade que se deseja recuperar. Passar a classe permite que o método saiba qual tipo de objeto deve ser retornado.
- **`2`**: este é o valor da chave primária que está sendo procurada na tabela correspondente à entidade Pessoa. Se uma entidade com esse ID existir no banco de dados, ela será retornada.
- O método retorna um objeto do tipo `Pessoa`. Se uma entidade com a chave primária especificada não for encontrada, ele retornará `null`. Isso significa que é importante verificar se o resultado é null antes de tentar usar o objeto retornado para evitar exceções de ponteiro nulo.
- A entidade retornada pelo método **`find()`** está em um estado gerenciado pelo contexto de persistência, o que significa que qualquer alteração feita nesse objeto será rastreada e persistida no banco de dados quando a transação for confirmada **`(commit)`**.

#### Remoção da Entidade

        em.remove(p);

- **`em.remove(p)`**: Este método marca o objeto p para remoção do banco de dados. A operação não é executada imediatamente; em vez disso, o objeto será removido quando a transação for confirmada.
- É importante ressaltar que o método **`remove()`** só pode ser chamado em um objeto que está no estado gerenciado (ou seja, que foi recuperado anteriormente pelo **`find()`** ou persistido).