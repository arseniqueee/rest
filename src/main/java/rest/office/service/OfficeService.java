package rest.office.service;

import rest.office.dto.*;
import rest.office.model.Office;
import rest.response.Result;

import java.util.List;

public interface OfficeService {

    List<OfficeListOutDto> findByIdOrg(OfficeListDto dto);

    OfficeItemDto findById(Long id);

    Result update(OfficeUpdateDto dto);

    Result save(OfficeSaveDto office);


}
