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

    @Override
    public List<Office> findByIdOrg(Long id, String name, String phone, boolean isActive) {
        String query = "SELECT o from Office o where o.orgId = :orgId and o.isActive = :isActive ";
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
        result.setParameter("isActive", isActive);
        return result.getResultList();
    }

    @Override
    public Office findById(Long id) {
        return em.find(Office.class, id);
    }

    @Override
    public void save(Office office) {
        em.persist(office);
    }

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
