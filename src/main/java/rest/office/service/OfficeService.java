package rest.office.service;

import rest.office.dto.*;
import rest.office.model.Office;

import java.util.List;

public interface OfficeService {

    List<OfficeListOutDto> findByIdOrg(OfficeListDto dto);

    OfficeItemDto findById(Long id);

    void update(OfficeUpdateDto dto);

    void save(OfficeSaveDto office);


}
