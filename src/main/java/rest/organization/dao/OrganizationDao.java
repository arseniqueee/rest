package rest.organization.dao;

import rest.organization.model.Organization;

import java.util.List;

public interface OrganizationDao {

    public List<Organization> getAll(String inn, String name, boolean isActive);

    public Organization getById(Long id);

    public void save(Organization organization);
}
