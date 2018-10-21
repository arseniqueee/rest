package rest.docs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import rest.docs.model.DocsData;

import javax.persistence.EntityManager;

public class DocsDataDaoImpl implements DocsDataDao {

    private final EntityManager manager;

    @Autowired
    public DocsDataDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public DocsData findById(Long id) {
        return manager.find(DocsData.class, id);
    }
}
