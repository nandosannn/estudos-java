# Introdução ao Spring Boot

## Inicialização da Aplicação

A **classe `SpringApplication`** é projetada para ser usada a partir do método `main()` de uma aplicação Java. Ao chamar o método estático `run(Class<?> primarySource, String... args)`, ela realiza uma série de etapas para configurar e iniciar a aplicação:

- **Criação do ApplicationContext:** Dependendo do classpath, a classe cria uma instância apropriada de `ApplicationContext`, que é o contêiner central onde os beans da aplicação são gerenciados.
- **Registro de CommandLinePropertySource:** Registra um `CommandLinePropertySource` que expõe os argumentos da linha de comando como propriedades `Spring`.
- **Carregamento de Beans:** O contexto da aplicação é atualizado, carregando todos os beans singleton definidos.
- **Execução de CommandLineRunner:** Se houver beans que implementam a interface `CommandLineRunner`, eles são executados após a inicialização do contexto.

## Método `run`

O método run da classe SpringApplication é um dos componentes centrais do Spring Boot, responsável por inicializar e executar uma aplicação Spring a partir do método main(). A seguir, explicamos detalhadamente o que esse método faz e como ele funciona.

- **Criação do ApplicationContext:** O método cria uma instância apropriada de `ApplicationContext`, que é o contêiner onde os beans da aplicação serão gerenciados. O tipo de contexto criado depende das dependências disponíveis no classpath (por exemplo, um contexto web se o Spring MVC estiver presente).
- **Registro de CommandLinePropertySource:** Ele registra um `CommandLinePropertySourc`e que expõe os argumentos da linha de comando como propriedades da Spring. Isso permite que você acesse esses argumentos dentro da sua aplicação.
- **Carregamento de Beans:** O contexto da aplicação é atualizado, carregando todos os beans singleton definidos nas classes de configuração. Isso inclui a análise de anotações como `@Component, @Service, e @Repository`.
- **Atualização do Contexto:** Após o carregamento dos beans, o contexto é "refrescado", o que significa que todos os beans são inicializados e prontos para uso.
- **Execução de CommandLineRunner e ApplicationRunner:** Se houver beans que implementam as interfaces CommandLineRunner ou `ApplicationRunner`, seus métodos `run()` são chamados após a inicialização do contexto. Isso permite que você execute código específico logo após a aplicação estar pronta.

## A anotação `@SpringBootApplication`


A anotação `@SpringBootApplication` é uma parte fundamental do Spring Boot, e sua importação através de `import org.springframework.boot.autoconfigure.SpringBootApplication;` é necessária para que você possa usar essa funcionalidade em sua aplicação.

#### Estrutura da Anotação

A anotação @SpringBootApplication é uma meta-anotação que inclui as seguintes anotações:
- **`@Configuration`**:
Indica que a classe pode ser usada como uma fonte de definições de beans. Isso significa que você pode definir métodos dentro dessa classe que retornam objetos a serem gerenciados como beans pelo contêiner Spring.
- **`@EnableAutoConfiguration`**:
Habilita o mecanismo de auto-configuração do Spring Boot. Isso significa que o Spring Boot tentará automaticamente configurar sua aplicação com base nas dependências presentes no classpath. Por exemplo, se você adicionar a dependência do Spring Data JPA, o Spring Boot configurará automaticamente um EntityManager e um DataSource, desde que não haja configurações conflitantes definidas pelo desenvolvedor.
- **`@ComponentScan`**:
Permite que o Spring escaneie o pacote onde a classe está localizada (e seus subpacotes) em busca de componentes, serviços e repositórios anotados com @Component, `@Service, @Repository`, etc. Isso facilita a detecção automática de beans que devem ser gerenciados pelo contêiner.

## *Demonstração*


    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;

    @SpringBootApplication
    public class AulaApplication {

        public static void main(String[] args) {
            SpringApplication.run(AulaApplication.class, args);
        }
    }


<br>

### Referências
[Class SpringApplication](https://docs.spring.io/spring-boot/api/java/org/springframework/boot/SpringApplication.html) <br>
[Usando a anotação @SpringBootApplication](https://docs.spring.io/spring-boot/reference/using/using-the-springbootapplication-annotation.html) <br>
[ Configuração automática](https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/using-boot-auto-configuration.html)


# A classe `UserResource`

## *Demonstração*

    package com.springestudos.aula.resources;

    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import com.springestudos.aula.entities.User;


    @RestController
    @RequestMapping(value = "/users")
    public class UserResource {
        
        @GetMapping
        public ResponseEntity<User> findAll(){
            User u = new User(1L, "Maria", "Maria@gmail", "999999", "1234");
            return ResponseEntity.ok().body(u);
            
        }
    }

A classe UserResource é um componente fundamental em uma aplicação Spring Boot, responsável por gerenciar as requisições HTTP relacionadas a usuários. Vamos analisar cada parte dela:
#### Anotações
- **`@RestController:`**
Esta anotação indica que a classe é um controlador onde cada método retorna um objeto diretamente como resposta HTTP. Isso significa que os dados retornados serão convertidos automaticamente em JSON (ou outro formato apropriado) e enviados ao cliente.
- **`@RequestMapping(value = "/users")`**:
Define a URL base para todas as requisições que este controlador irá manipular. Neste caso, todas as requisições que começam com /users serão tratadas por esta classe.
#### Método findAll()
- **@GetMapping**:
  - Esta anotação indica que o método **`findAll()`** responderá a requisições HTTP do tipo GET. Ou seja, quando um cliente fizer uma solicitação para `/users`, este método será invocado.
- **Retorno do Método**:
  -   O método retorna um objeto do tipo **`ResponseEntity<User>`**. O ResponseEntity é uma classe do Spring que representa toda a resposta HTTP, incluindo o corpo da resposta e os códigos de status.
  - Dentro do método, um novo objeto User é criado com alguns dados fictícios `(ID, nome, email, telefone e senha)`. Este objeto é então retornado como parte da resposta HTTP com o código de status 200 (OK).
#### Exemplo de Uso
Quando um cliente faz uma solicitação GET para `/users`, o seguinte acontece:
- O método `findAll()` é chamado.
- Um novo usuário `(User)` é criado.
- O usuário é enviado como resposta em formato JSON.

## A classe `ResponseEntity`

A classe ResponseEntity<T> no Spring Framework é uma ferramenta poderosa que representa uma resposta HTTP completa. Ela encapsula três componentes principais: o corpo da resposta, os cabeçalhos e o código de status HTTP.

#### Principais Funcionalidades
- **Composição Completa:**
`ResponseEntity` combina o corpo da resposta, cabeçalhos e um código de status em um único objeto, permitindo que desenvolvedores configurem a resposta HTTP de forma abrangente.
- **Extensão de HttpEntity:**
É uma extensão da classe **`HttpEntity<T>`**, que representa apenas o corpo e os cabeçalhos da resposta. A ResponseEntity adiciona a capacidade de incluir um código de status HTTP, tornando-a mais completa para uso em APIs RESTful.
- **Suporte a Tipos Genéricos:**
A classe é genérica, permitindo que você defina o tipo do corpo da resposta, o que proporciona maior flexibilidade ao trabalhar com diferentes tipos de dados, como JSON ou XML.
- **Personalização da Resposta:**
Com ResponseEntity, é possível personalizar o código de status (como 200 OK, 404 Not Found) e adicionar cabeçalhos personalizados (como Content-Type ou Cache-Control), permitindo que a resposta seja adaptada às necessidades específicas do cliente.

#### Exemplos de Uso

- **Retornando uma Resposta Simples**

        @GetMapping("/example")
        public ResponseEntity<String> getExample() {
            return ResponseEntity.ok("Hello World");
        }

Neste exemplo, um corpo simples é retornado com um código de status 200.

- **Personalizando Cabeçalhos e Status**

        @GetMapping("/custom")
        public ResponseEntity<String> getCustom() {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "Value");
            return new ResponseEntity<>("Custom Response", headers, HttpStatus.CREATED);
        }


Aqui, além do corpo da resposta, um cabeçalho personalizado é adicionado e o código de status é definido como 201 (Criado).


#### Quando Usar ResponseEntity

- **Manipular Códigos de Status**: Quando a operação pode resultar em diferentes estados (sucesso, erro, etc.).
- **Adicionar Cabeçalhos Personalizados**: Quando informações adicionais são necessárias na resposta.
- **Retornar Tipos Diversos**: Quando o corpo da resposta pode variar em tipo ou estrutura.

## A anotação `@GetMapping` 

A anotação `@GetMapping` no Spring Framework é uma forma simplificada de mapear requisições HTTP do tipo GET para métodos específicos em controladores. Ela foi introduzida na versão 4.3 do Spring e serve como um atalho para a anotação `@RequestMapping(method = RequestMethod.GET)`.

#### Exemplo de Uso
Um exemplo típico de uso da anotação seria:

        @GetMapping("/users")
        public List<User> getAllUsers() {
            return userService.findAll();
        }

- O método **`getAllUsers()`** é mapeado para responder a requisições GET na URL /users.
- Quando um cliente faz uma solicitação GET para essa URL, o método é invocado e retorna uma lista de usuários.

## A anotação `@RequestMapping`

A anotação `@RequestMapping` no Spring Framework é uma das principais ferramentas para mapear requisições HTTP a métodos de controle em aplicações web. Ela pode ser aplicada tanto em classes quanto em métodos, permitindo uma configuração flexível e organizada dos endpoints da API.

#### Mapeamento de Requisições: 
`@RequestMapping` é usada para associar uma URL específica ou um padrão de URL a um método ou a uma classe de controlador. Isso permite que o Spring saiba qual método deve ser chamado quando uma requisição correspondente é recebida.

#### Exemplo de Uso

        @Controller
        @RequestMapping("/api")
        public class ApiController {
            @GetMapping("/users")
            public ResponseEntity<String> getUsers() {
                return ResponseEntity.ok("Hello World");
            }
        }

Neste exemplo, quando uma requisição GET é feita para /api/users, o método `getUsers()` será chamado.


## A anotação `@RestController`

A anotação `@RestController` no Spring Framework é uma especialização da anotação `@Controller`, projetada especificamente para o desenvolvimento de APIs REST. Ela combina a funcionalidade de um controlador com a capacidade de retornar dados diretamente no corpo da resposta, geralmente em formato JSON ou XML, sem a necessidade de uma visualização HTML.

#### Principais Características

- **Combinação de Anotações:** `@RestController` é uma meta-anotação que combina as funcionalidades de `@Controller` e `@ResponseBody`. Isso significa que, ao usar `@RestController`, não é necessário adicionar `@ResponseBody` em cada método, pois todos os métodos já retornam diretamente o corpo da resposta.
- **Foco em APIs REST:** É ideal para aplicações que precisam expor serviços web que retornam dados ao invés de páginas HTML. Quando um cliente (como um navegador ou aplicativo) faz uma solicitação a um endpoint anotado com `@RestController`, o resultado é automaticamente serializado em JSON ou XML, dependendo das configurações do projeto.
- **Tratamento Simplificado de Respostas:** Com `@RestController`, você pode retornar objetos Java diretamente, e o Spring cuida da conversão desses objetos para o formato apropriado (geralmente JSON). Isso simplifica o desenvolvimento de APIs RESTful.

#### Exemplo de Uso

        @RestController
        @RequestMapping("/api")
        public class UserController {

            @GetMapping("/users")
            public List<User> getUsers() {
                return userService.findAll();
            }
        }

Neste exemplo:

- A classe `UserController` é anotada com `@RestController`, indicando que ela lida com requisições REST.
- O método `getUsers()` responde a uma solicitação GET na URL /api/users e retorna uma lista de usuários. O Spring automaticamente converte essa lista em JSON.


### Referências

[ResponseEntity](https://docs.spring.io/spring-framework/docs/4.1.0.RC1_to_4.1.0.RC2/Spring%20Framework%204.1.0.RC2/org/springframework/http/ResponseEntity.html) <br>
[@GetMapping](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/GetMapping.html) <br>
[@RequestMapping](https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-controller/ann-requestmapping.html)




        

