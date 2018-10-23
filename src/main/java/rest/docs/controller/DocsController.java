package rest.docs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rest.docs.model.Docs;
import rest.docs.service.DocsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/docs")
@Api(tags = "Document controller")
public class DocsController {

    private final DocsService service;

    @Autowired
    public DocsController(DocsService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value = "Get doc`s list")
    public List<Docs> getList(){
        return service.findAll();
    }
}
