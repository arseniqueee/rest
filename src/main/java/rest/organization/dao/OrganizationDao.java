package rest.organization.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.organization.model.Organization;

import java.util.List;

public interface OrganizationDao {

    public List<Organization> getAll(String inn, String name, boolean active);

    public Organization getById(Long id);

    public void save(Organization organization);

    public void update(Organization organization);

}
