package rest.organization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.organization.dto.*;
import rest.organization.mapper.OrganizationMapper;
import rest.organization.model.Organization;
import rest.organization.dao.OrganizationDao;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao dao;

    private final OrganizationMapper mapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, OrganizationMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<OrganizationItemDto> findAll(OrganizationListDto dto) {
        List<Organization> a = dao.getAll(dto.getInn(), dto.getName(), dto.getActive());
        return mapper.mapAsList(a, OrganizationItemDto.class);
    }

    @Override
    public OrganizationFullDto findById(Long id) {
        return mapper.map(dao.getById(id), OrganizationFullDto.class);
    }

    @Override
    @Transactional
    public void save(OrganizationSaveDto organization)
    {
        Organization organization1 = mapper.map(organization, Organization.class);
        dao.save(organization1);
    }

    @Override
    @Transactional
    public void update(OrganizationUpdateDto dto) {
        Organization organization = mapper.map(dto, Organization.class);
        dao.save(organization);
    }
}
