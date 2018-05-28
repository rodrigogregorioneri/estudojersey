package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import entities.Aluno;


public class AlunoRepository {
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;
        try {
            //Obtem o factory a partir da unidade de persistencia.
            factory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
            //Cria um entity manager.
            entityManager = factory.createEntityManager();
        } finally {

        }
        return entityManager;
    }

    public Aluno consultarPorId(Long id) {
        EntityManager entityManager = getEntityManager();
        Aluno aluno = null;
        try {
            aluno = entityManager.find(Aluno.class, id);
        } finally {
            entityManager.close();
        }
        return aluno;
    }

    public Aluno salvar(Aluno aluno) {
        EntityManager entityManager = getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            entityManager.getTransaction().begin();
            System.out.println("Salvando as informações do aluno.");
            // Verifica se o aluno ainda não está salvo no banco de dados.
            if(aluno.getId() == null) {
                entityManager.persist(aluno);
            } else {
                aluno = entityManager.merge(aluno);
            }
            // Finaliza a transação.
            entityManager.getTransaction().commit();
        } catch(Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
        // Retorna o aluno salvo.
        return aluno;
    }

    public void apagar(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            entityManager.getTransaction().begin();
            // Consulta o aluno na base de dados através do seu ID.
            Aluno aluno = entityManager.find(Aluno.class, id);
            System.out.println("Excluindo o cliente: " + aluno.getNome());
            // Remove o aluno da base de dados.
            entityManager.remove(aluno);
            // Finaliza a transação.
            entityManager.getTransaction().commit();
        } catch(Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}