package rest.organization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.organization.model.Organization;
import rest.organization.service.OrganizationService;
import rest.organization.view.DataView;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/organization")
public class OrganizationController {

    private final OrganizationService service;

    @Autowired
    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @PostMapping(value = "/list")
    @ResponseBody
    public Map getAll(@RequestParam(value = "inn", required = false) String inn, @RequestParam(value = "name", required = true) String name,
                           @RequestParam(value = "isActive", required = false) boolean isActive) {
        Map a = new HashMap();
        List<Organization> list = service.findAll(inn, name, isActive);
        a.put("data", list);
        return a;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Map getById(@PathVariable(value = "id") Long id) {
        Map a = new HashMap();
        Organization organization = service.findById(id);
        a.put("data", organization);
        return a;
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public String save(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "full_name", required = true) String fullName,
                       @RequestParam(value = "inn", required = true) String inn, @RequestParam(value = "kpp", required = true) String kpp,
                       @RequestParam(value = "address", required = true) String address, @RequestParam(value = "phone", required = true) String phone) {
        Organization organization = new Organization(name, fullName, inn, kpp, address, phone, true);
        String response = "";
        try {
            service.save(organization);
            response = "result: success";
        }catch (Exception e){
            response = "result: "+e.toString();
        }
        return  response;
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public String update(@RequestParam(value = "id", required = true) Long id,
                         @RequestParam(value = "name", required = true) String name, @RequestParam(value = "full_name", required = true) String fullName,
                         @RequestParam(value = "inn", required = true) String inn, @RequestParam(value = "kpp", required = true) String kpp,
                         @RequestParam(value = "address", required = true) String address, @RequestParam(value = "phone", required = true) String phone){
        Organization organization = service.findById(id);
        organization.setName(name);
        organization.setFullName(fullName);
        organization.setInn(inn);
        organization.setKpp(kpp);
        organization.setAddress(address);
        organization.setPhone(phone);
        String response = "";
        try {
            service.save(organization);
            response = "result: success";
        }catch (Exception e){
            response = "result: "+e.toString();
        }
        return response;
    }
}
