# Introdução ao Spring Boot

## Inicialização da Aplicação

A **classe `SpringApplication`** é projetada para ser usada a partir do método `main()` de uma aplicação Java. Ao chamar o método estático `run(Class<?> primarySource, String... args)`, ela realiza uma série de etapas para configurar e iniciar a aplicação:

- **Criação do ApplicationContext:** Dependendo do classpath, a classe cria uma instância apropriada de `ApplicationContext`, que é o contêiner central onde os beans da aplicação são gerenciados.
- **Registro de CommandLinePropertySource:** Registra um `CommandLinePropertySource` que expõe os argumentos da linha de comando como propriedades `Spring`.
- **Carregamento de Beans:** O contexto da aplicação é atualizado, carregando todos os beans singleton definidos.
- **Execução de CommandLineRunner:** Se houver beans que implementam a interface `CommandLineRunner`, eles são executados após a inicialização do contexto.

#### Método `run`

O método run da classe SpringApplication é um dos componentes centrais do Spring Boot, responsável por inicializar e executar uma aplicação Spring a partir do método main(). A seguir, explicamos detalhadamente o que esse método faz e como ele funciona.

- **Criação do ApplicationContext:** O método cria uma instância apropriada de `ApplicationContext`, que é o contêiner onde os beans da aplicação serão gerenciados. O tipo de contexto criado depende das dependências disponíveis no classpath (por exemplo, um contexto web se o Spring MVC estiver presente).
- **Registro de CommandLinePropertySource:** Ele registra um `CommandLinePropertySourc`e que expõe os argumentos da linha de comando como propriedades da Spring. Isso permite que você acesse esses argumentos dentro da sua aplicação.
- **Carregamento de Beans:** O contexto da aplicação é atualizado, carregando todos os beans singleton definidos nas classes de configuração. Isso inclui a análise de anotações como `@Component, @Service, e @Repository`.
- **Atualização do Contexto:** Após o carregamento dos beans, o contexto é "refrescado", o que significa que todos os beans são inicializados e prontos para uso.
- **Execução de CommandLineRunner e ApplicationRunner:** Se houver beans que implementam as interfaces CommandLineRunner ou `ApplicationRunner`, seus métodos `run()` são chamados após a inicialização do contexto. Isso permite que você execute código específico logo após a aplicação estar pronta.

## A claase `SpringBootApplication`


