package rest.office.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rest.office.dto.*;
import rest.office.mapper.OfficeMapper;
import rest.office.model.Office;
import rest.office.service.OfficeService;
import rest.organization.service.OrganizationService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/office")
public class OfficeController {

    private final OfficeService service;

    private final OrganizationService organizationService;

    private final OfficeMapper mapper;

    @Autowired
    public OfficeController(OfficeService service, OrganizationService organizationService, OfficeMapper mapper) {
        this.service = service;
        this.organizationService = organizationService;
        this.mapper = mapper;
    }

    @PostMapping(value = "/list", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public List<OfficeListOutDto> getList(@RequestBody OfficeListDto dto){
        List<OfficeListOutDto> list = service.findByIdOrg(dto);
        return list;
    }

    @GetMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE)
    public OfficeItemDto getOffice(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }

    @PostMapping("/update")
    public void updateOffice(@RequestBody  OfficeUpdateDto dto){
        service.update(dto);
    }

    @PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE)
    public void saveOffice(@RequestBody OfficeSaveDto dto){
        service.save(dto);
    }
}
