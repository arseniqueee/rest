package rest.organization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.organization.model.Organization;
import rest.organization.dao.OrganizationDao;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao dao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Organization> findAll(String inn, String name, boolean isActive) {
        return dao.getAll(inn, name, isActive);
    }

    @Override
    public Organization findById(Long id) {
        return dao.getById(id);
    }

    @Override
    @Transactional
    public void save(Organization organization) {
        dao.save(organization);
    }
}
