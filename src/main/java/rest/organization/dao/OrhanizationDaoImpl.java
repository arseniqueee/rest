package rest.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rest.organization.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class OrhanizationDaoImpl implements OrganizationDao {

    private final EntityManager entityManager;

    @Autowired
    public OrhanizationDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Organization> getAll(String inn, String name, boolean isActive) {
        String query = "SELECT h from Organization h where h.name = :name and h.isActive = :isActive ";
        if (inn != null) {
            query += "and h.inn = :inn";
        }
        TypedQuery<Organization> queryfinal = entityManager.createQuery(query, Organization.class);
        if (inn != null) {
            queryfinal.setParameter("inn", inn);
        }
        queryfinal.setParameter("name", name);
        queryfinal.setParameter("isActive", isActive);
        return queryfinal.getResultList();
    }

    @Override
    public Organization getById(Long id) {
        return entityManager.find(Organization.class, id);
    }

    @Override
    public void save(Organization organization) {
        entityManager.persist(organization);
    }
}
