package rest.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.office.dao.OfficeDao;
import rest.office.dto.*;
import rest.office.mapper.OfficeMapper;
import rest.office.model.Office;
import rest.response.Result;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Office service
 */
@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao dao;

    private final OfficeMapper mapper;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao, OfficeMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    /**
     * List offices with filter dto
     * @param dto filter dto
     * @return list dto
     */
    @Override
    public List<OfficeListOutDto> findByIdOrg(OfficeListDto dto) {
        List<Office> offices = dao.findByIdOrg(dto.getOrgId(), dto.getName(), dto.getPhone(), dto.isActive());
        return mapper.mapAsList(offices, OfficeListOutDto.class);
    }

    /**
     * Find office by id
     * @param id Office id
     * @return dto office item
     */
    @Override
    public OfficeItemDto findById(Long id) {
        Office office = dao.findById(id);
        return mapper.map(office, OfficeItemDto.class);
    }

    /**
     * Update office
     * @param dto update dto
     * @return result
     */
    @Override
    @Transactional
    public Result update(OfficeUpdateDto dto) {
        dao.update(mapper.map(dto, Office.class));
        return new Result("success");
    }

    /**
     * Save office
     * @param office save dto
     * @return result
     */
    @Override
    @Transactional
    public Result save(OfficeSaveDto office) {
        dao.save(mapper.map(office, Office.class));
        return new Result("success");
    }
}
