package br.edu.ifsul.testes;

import br.edu.ifsul.trabalho1etapa.Especialidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jessica
 */
public class TestePersistirEspecialidade {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho1EtapaPU");
        EntityManager em = emf.createEntityManager();
        Especialidade e =  new Especialidade();

        e.setNome("Bacharel");
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
