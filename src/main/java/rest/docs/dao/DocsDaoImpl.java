package rest.docs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rest.docs.model.Docs;
import rest.docs.model.DocsData;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


/**
 * {@inheritDoc}
 */
@Repository
public class DocsDaoImpl implements DocsDao {

    private final EntityManager em;

    @Autowired
    public DocsDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Docs> getList() {
        String query = "SELECT h from Docs h";
        TypedQuery<Docs> result = em.createQuery(query, Docs.class);
        return result.getResultList();
    }




    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void saveDocs(Docs docs) {
        Docs docsNew = new Docs();
        docsNew.setCode(docs.getCode());
        docsNew.setName(docs.getName());
        em.persist(docsNew);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Docs findByCode(Long code) {
        return em.find(Docs.class, code);
    }


}
