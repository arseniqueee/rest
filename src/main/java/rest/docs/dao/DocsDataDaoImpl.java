package rest.docs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rest.docs.model.DocsData;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class DocsDataDaoImpl implements DocsDataDao {

    private final EntityManager manager;

    @Autowired
    public DocsDataDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    /**
     * Find DocsData by id
     * @param id document data id
     * @return DocsData entity
     */
    @Override
    public DocsData findById(Long id) {
        return manager.find(DocsData.class, id);
    }

    /**
     * Save DocsData
     * @param data Entity for save
     */
    @Override
    @Transactional
    public void save(DocsData data) {
        DocsData dataNew = new DocsData();
        dataNew.setDate(data.getDate());
        dataNew.setDocsCode(data.getDocsCode());
        dataNew.setUserId(data.getUserId());
        manager.persist(dataNew);
    }

    /**
     * Find last row in DocsData table
     * @return DocsData entity
     */
    @Override
    public DocsData findLast() {
        String query = "select u from DocsData u order by u.id desc";
        TypedQuery<DocsData> result = manager.createQuery(query, DocsData.class);
        return result.getResultList().get(0);
    }
}
