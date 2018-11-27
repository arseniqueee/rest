package rest.organization.service;

import rest.organization.dto.*;
import rest.organization.model.Organization;
import rest.response.Result;

import java.util.List;

/**
 * Organization service
 */
public interface OrganizationService {

    /**
     * Get organizations by filter
     * @param dto filter dto
     * @return list dto items
     */
    List<OrganizationItemDto> findAll(OrganizationListDto dto);

    /**
     * Get organization by id
     * @param id Organization id
     * @return dto item organization
     */
    OrganizationFullDto findById(Long id);

    /**
     * Save organization
     * @param organization save dto organization
     * @return result
     */
    Result save(OrganizationSaveDto organization);

    /**
     * Update organization
     * @param dto update dto organization
     * @return result
     */
    Result update(OrganizationUpdateDto dto);
}
