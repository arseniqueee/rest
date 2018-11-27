package rest.office.dao;

import rest.office.model.Office;
import java.util.List;

/**
 * Office repository
 */
public interface OfficeDao {

    /**
     * Find offices
     * @param id Office id
     * @param name Office name
     * @param phone Office phone
     * @param active Office active
     * @return list offices
     */
    public List<Office> findByIdOrg(Long id, String name, String phone, boolean active);


    /**
     * Find office by id
     * @param id Office id
     * @return Office entity
     */
    public Office findById(Long id);


    /**
     * Save office
     * @param office Office entity
     */
    public void save(Office office);

    /**
     * Update office
     * @param office Office entity
     */
    public void update(Office office);
}
