package rest.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rest.organization.dto.*;
import rest.organization.model.Organization;
import rest.organization.service.OrganizationService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/organization")
public class OrganizationController {

    private final OrganizationService service;

    @Autowired
    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @PostMapping(value = "/list", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public List<OrganizationItemDto> getAll(@RequestBody @Validated OrganizationListDto dto) {
        List<OrganizationItemDto> list = service.findAll(dto);
        return list;
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public OrganizationFullDto getById(@PathVariable(value = "id") Long id) {
        OrganizationFullDto organization = service.findById(id);
        return organization;
    }

    @PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public void save(@RequestBody @Validated OrganizationSaveDto dto) {
        service.save(dto);
    }

    @PostMapping(value = "/update", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public void update(@RequestBody @Validated OrganizationUpdateDto dto) {
        service.update(dto);
    }

}
