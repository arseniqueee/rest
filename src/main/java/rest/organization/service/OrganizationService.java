package rest.organization.service;

import rest.organization.dto.*;
import rest.organization.model.Organization;
import java.util.List;

public interface OrganizationService {

    List<OrganizationItemDto> findAll(OrganizationListDto dto);

    OrganizationFullDto findById(Long id);

    void save(OrganizationSaveDto organization);

    void update(OrganizationUpdateDto dto);
}
