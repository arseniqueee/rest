package rest.organization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.organization.dto.*;
import rest.organization.mapper.OrganizationMapper;
import rest.organization.model.Organization;
import rest.organization.dao.OrganizationDao;
import rest.response.Result;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Organization service
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationDao dao;

    private final OrganizationMapper mapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao, OrganizationMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    /**
     * Get organizations by filter
     * @param dto filter dto
     * @return list dto items
     */
    @Override
    public List<OrganizationItemDto> findAll(OrganizationListDto dto) {
        List<Organization> a = dao.getAll(dto.getInn(), dto.getName(), dto.isActive());
        return mapper.mapAsList(a, OrganizationItemDto.class);
    }

    /**
     * Get organization by id
     * @param id Organization id
     * @return dto item organization
     */
    @Override
    public OrganizationFullDto findById(Long id) {
        return mapper.map(dao.getById(id), OrganizationFullDto.class);
    }

    /**
     * Save organization
     * @param organization save dto organization
     * @return result
     */
    @Override
    @Transactional
    public Result save(OrganizationSaveDto organization)
    {
        Organization organization1 = mapper.map(organization, Organization.class);
        dao.save(organization1);
        return new Result("success");
    }

    /**
     * Update organization
     * @param dto update dto organization
     * @return result
     */
    @Override
    @Transactional
    public Result update(OrganizationUpdateDto dto) {
        Organization organization = mapper.map(dto, Organization.class);
        dao.update(organization);
        return new Result("success");
    }
}
