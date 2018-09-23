package rest.docs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rest.docs.service.DocsService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/docs")
public class DocsController {

    private final DocsService service;

    @Autowired
    public DocsController(DocsService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    public Map getList(){
        Map a = new HashMap();
        a.put("data", service.findAll());
        return a;
    }
}
