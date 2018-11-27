package rest.countries.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rest.countries.model.Countries;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class CountriesDaoImpl implements CountriesDao {

    private final EntityManager manager;

    @Autowired
    public CountriesDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Countries> findAll() {
        TypedQuery<Countries> query = manager.createQuery("SELECT h from Countries h", Countries.class);
        return query.getResultList();
    }
}
