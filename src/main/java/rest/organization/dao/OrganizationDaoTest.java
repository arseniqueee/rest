package rest.organization.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.organization.model.Organization;

public interface OrganizationDaoTest extends JpaRepository<Organization, Long> {
}
