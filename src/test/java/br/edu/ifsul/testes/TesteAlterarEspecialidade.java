
package br.edu.ifsul.testes;

import br.edu.ifsul.trabalho1etapa.Especialidade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jessica
 */
public class TesteAlterarEspecialidade {

    
     public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho1EtapaPU");
        EntityManager em = emf.createEntityManager();
        Especialidade e = em.find(Especialidade.class, 1);
        e.setNome("Mestre");
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
