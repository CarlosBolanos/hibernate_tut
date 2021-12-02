package guru.springframework.spring5webapp.hibernate;

import guru.springframework.spring5webapp.hibernate.domain.AuthorEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

@Component
public class HibernateAuthorDaoImpl implements HibernateAuthorDao {

    private final EntityManagerFactory emf;

    public HibernateAuthorDaoImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public AuthorEntity getById(Long id) {
        return getEntityManager().find(AuthorEntity.class, id);
    }

    @Override
    public AuthorEntity findAuthorByName(String username) {
        TypedQuery<AuthorEntity> query = getEntityManager().createQuery("SELECT a FROM AuthorEntity a " +
            "WHERE a.username = :username", AuthorEntity.class);
        query.setParameter("username", username);

        return query.getSingleResult();
    }

    @Override
    public AuthorEntity saveNewAuthor(AuthorEntity author) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(author);
        em.flush();
        em.getTransaction().commit();
        return author;
    }

    @Override
    public AuthorEntity updateAuthor(AuthorEntity author) {
        EntityManager em = getEntityManager();
        em.joinTransaction();
        em.merge(author);
        em.flush();
        em.clear();
        return em.find(AuthorEntity.class, author.getId());
    }

    @Override
    public void deleteAuthorById(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        AuthorEntity author = em.find(AuthorEntity.class, id);
        em.remove(author);
        em.flush();
        em.getTransaction().commit();
    }

    private EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
