package rest.countries.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rest.countries.serivce.CountriesService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/countries")
public class CountriesController {

    private final CountriesService service;

    @Autowired
    public CountriesController(CountriesService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    public Map getList(){
        Map a = new HashMap();
        a.put("data", service.getList());
        return a;
    }
}
