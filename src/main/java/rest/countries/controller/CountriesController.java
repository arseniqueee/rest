package rest.countries.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rest.countries.model.Countries;
import rest.countries.serivce.CountriesService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/countries")
@Api(tags = "Countries controller")
public class CountriesController {

    private final CountriesService service;

    @Autowired
    public CountriesController(CountriesService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "Get countrie`s list")
    public List<Countries> getList(){
        return service.getList();
    }
}
