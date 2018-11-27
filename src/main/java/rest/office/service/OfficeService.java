package rest.office.service;

import rest.office.dto.*;
import rest.office.model.Office;
import rest.response.Result;

import java.util.List;

/**
 * Office service
 */
public interface OfficeService {

    /**
     * List offices with filter dto
     * @param dto filter dto
     * @return list dto
     */
    List<OfficeListOutDto> findByIdOrg(OfficeListDto dto);

    /**
     * Find office by id
     * @param id Office id
     * @return dto office item
     */
    OfficeItemDto findById(Long id);

    /**
     * Update office
     * @param dto update dto
     * @return result
     */
    Result update(OfficeUpdateDto dto);

    /**
     * Save office
     * @param office save dto
     * @return result
     */
    Result save(OfficeSaveDto office);


}
