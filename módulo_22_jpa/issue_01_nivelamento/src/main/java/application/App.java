package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;

import dominio.Pessoa;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
        
        /* //Inserir Dados no Banco de Dados
        em.getTransaction().begin();

        em.persist(p1);
        em.persist(p2);
        em.persist(p3);

        em.getTransaction().commit();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3); */

        /* // Procurar um dado na tabla e converter para objeto
        Pessoa p = em.find(Pessoa.class, 2);

        System.out.println(p);
        */

        //Remover elemento do banco de dados
        // Objeto monitorado: é o objeto que acabou de ser inserido ou encontrado
        Pessoa p = em.find(Pessoa.class, 2);
        em.getTransaction().begin();
        // A função remove só deleta do banco de dados um objeto monitorado
        em.remove(p);
        em.getTransaction().commit();

        System.out.println("Pronto!");
        em.close();
        emf.close();
    }
}
