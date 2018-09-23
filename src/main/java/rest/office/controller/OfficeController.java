package rest.office.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.office.model.Office;
import rest.office.service.OfficeService;
import rest.organization.service.OrganizationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/office")
public class OfficeController {

    private final OfficeService service;

    private final OrganizationService organizationService;

    @Autowired
    public OfficeController(OfficeService service, OrganizationService organizationService) {
        this.service = service;
        this.organizationService = organizationService;
    }

    @PostMapping(value = "/list/{id}")
    @ResponseBody
    public Map getList(@PathVariable(value = "id", required = true) Long orgId, @RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "phone", required = false) String phone, @RequestParam(value = "is_active", required = false) Boolean isActive){
        Map response = new HashMap();
        try {
            List<Office> list = service.findByIdOrg(orgId, name, phone, isActive);
            response.put("data", list);
        }catch (Exception e){
            response.put("error", e);
        }
        return response;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Map getOffice(@PathVariable(value = "id") Long id){
        Map a = new HashMap();
        a.put("data", service.findById(id));
        return a;
    }

    @PostMapping("/update")
    @ResponseBody
    public Map updateOffice(@RequestParam(value = "id", required = true) Long id, @RequestParam(value = "name") String name,
                            @RequestParam(value = "address") String address, @RequestParam(value = "phone") String phone){
        Office office = service.findById(id);
        office.setName(name);
        office.setAddress(address);
        office.setPhone(phone);
        office.setIsActive(true);
        Map a = new HashMap();
        try {
            service.save(office);
            a.put("result", "success");
        }catch (Exception e){
            a.put("error", e);
        }
        return a;
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public Map saveOffice(@RequestParam(value = "org_id") Long orgId, @RequestParam(value = "name") String name,
    @RequestParam(value = "address") String address, @RequestParam(value = "phone") String phone){
        Office office = new Office(orgId, name, address, phone, true);
        Map a = new HashMap();
        if (organizationService.findById(orgId) != null){
            service.save(office);
            a.put("result", "success");
        }else {
            a.put("error", "Organization id not found.");
        }
        return a;
    }
}
