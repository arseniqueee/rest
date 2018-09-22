package rest.organization.service;

import org.aspectj.weaver.ast.Or;
import rest.organization.model.Organization;
import rest.organization.view.OrganizationSaveView;

import java.util.List;

public interface OrganizationService {

    List<Organization> findAll(String inn, String name, boolean isActive);

    Organization findById(Long id);

    void save(Organization organization);
}
