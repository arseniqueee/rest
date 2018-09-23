package rest.organization.service;

import rest.organization.model.Organization;
import java.util.List;

public interface OrganizationService {

    List<Organization> findAll(String inn, String name, boolean isActive);

    Organization findById(Long id);

    void save(Organization organization);
}
