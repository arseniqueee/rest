package rest.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.organization.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager entityManager;

    @Autowired
    public OrganizationDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> getAll(String inn, String name, boolean active) {
        String query = "SELECT h from Organization h where h.name = :name and h.active = :active ";
        if (inn != null) {
            query += "and h.inn = :inn";
        }
        TypedQuery<Organization> queryfinal = entityManager.createQuery(query, Organization.class);
        if (inn != null) {
            queryfinal.setParameter("inn", inn);
        }
        queryfinal.setParameter("name", name);
        queryfinal.setParameter("active", active);
        return queryfinal.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization getById(Long id) {
        return entityManager.find(Organization.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Organization organization){
        entityManager.persist(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Organization organization) {
        Organization org = entityManager.find(Organization.class, organization.getId());
        org.setPhone(organization.getPhone());
        org.setAddress(organization.getAddress());
        org.setKpp(organization.getKpp());
        org.setInn(organization.getInn());
        org.setFullName(organization.getFullName());
        org.setName(organization.getName());
        org.setActive(organization.isActive());
        entityManager.persist(org);
    }
}
