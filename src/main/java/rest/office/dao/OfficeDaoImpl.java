package rest.office.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rest.office.model.Office;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Find offices
     * @param id Office id
     * @param name Office name
     * @param phone Office phone
     * @param active Office active
     * @return list offices
     */
    @Override
    public List<Office> findByIdOrg(Long id, String name, String phone, boolean active) {
        String query = "SELECT o from Office o where o.orgId = :orgId and o.active = :active ";
        if (name != null){
            query += "and o.name = :name ";
        }
        if (phone != null){
            query += "and o.phone = :phone ";
        }
        TypedQuery<Office> result = em.createQuery(query, Office.class);
        if (name != null){
            result.setParameter("name", name);
        }
        if (phone != null){
            result.setParameter("phone", phone);
        }
        result.setParameter("orgId", id);
        result.setParameter("active", active);
        return result.getResultList();
    }

    /**
     * Find office by id
     * @param id Office id
     * @return Office entity
     */
    @Override
    public Office findById(Long id) {
        return em.find(Office.class, id);
    }

    /**
     * Save office
     * @param office Office entity
     */
    @Override
    public void save(Office office) {
        em.persist(office);
    }

    /**
     * Update office
     * @param office Office entity
     */
    @Override
    public void update(Office office) {
        Office of = em.find(Office.class, office.getId());
        of.setName(office.getName());
        of.setPhone(office.getPhone());
        of.setAddress(office.getAddress());
        of.setActive(office.isActive());
        of.setOrgId(office.getOrgId());
        em.persist(of);
    }
}
