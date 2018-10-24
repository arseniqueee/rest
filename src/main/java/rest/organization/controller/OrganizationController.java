package rest.organization.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rest.organization.dto.*;
import rest.organization.model.Organization;
import rest.organization.service.OrganizationService;
import rest.response.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Organization controller
 */
@RestController
@RequestMapping(value = "/organization")
@Api(tags = "Organization controller")
public class OrganizationController {

    private final OrganizationService service;

    @Autowired
    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @PostMapping(value = "/list", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get organization`s list")
    public List<OrganizationItemDto> getAll(@RequestBody  OrganizationListDto dto) {
        List<OrganizationItemDto> list = service.findAll(dto);
        return list;
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get organization by id")
    public OrganizationFullDto getById(@PathVariable(value = "id") Long id) {
        OrganizationFullDto organization = service.findById(id);
        return organization;
    }

    @PostMapping(value = "/save", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save organization")
    public Result save(@RequestBody  OrganizationSaveDto dto) {
        return service.save(dto);
    }

    @PostMapping(value = "/update", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update organization")
    public Result update(@RequestBody OrganizationUpdateDto dto) {
        return service.update(dto);
    }

}
