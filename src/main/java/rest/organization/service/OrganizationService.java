package rest.organization.service;

import rest.organization.dto.*;
import rest.organization.model.Organization;
import rest.response.Result;

import java.util.List;

public interface OrganizationService {

    List<OrganizationItemDto> findAll(OrganizationListDto dto);

    OrganizationFullDto findById(Long id);

    Result save(OrganizationSaveDto organization);

    Result update(OrganizationUpdateDto dto);
}
