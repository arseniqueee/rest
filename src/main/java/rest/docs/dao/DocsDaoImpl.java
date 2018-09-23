package rest.docs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rest.docs.model.Docs;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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
}
