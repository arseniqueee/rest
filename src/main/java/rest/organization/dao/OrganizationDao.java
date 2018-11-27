package rest.organization.dao;

import rest.organization.model.Organization;

import java.util.List;

/**
 * Organization repository
 */
public interface OrganizationDao {

    /**
     * Get list organizations
     * @param inn inn of organization
     * @param name name of organization
     * @param active active of organization
     * @return list organizations
     */
    public List<Organization> getAll(String inn, String name, boolean active);

    /**
     * Get organization by id
     * @param id Organization id
     * @return Organization entity
     */
    public Organization getById(Long id);

    /**
     * Save organization
     * @param organization Organization entity
     */
    public void save(Organization organization);

    /**
     * Update organization
     * @param organization Organization entity
     */
    public void update(Organization organization);

}
