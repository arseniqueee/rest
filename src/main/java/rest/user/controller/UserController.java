package rest.user.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rest.response.Response;
import rest.response.Result;
import rest.user.dto.*;
import rest.user.service.UserService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/user")
@Api(tags = "User controller")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(value = "/list")
    @ApiOperation(value = "Get user`s list")
    public List<UserListOutDto> list(@RequestBody UserListDto dto){
        return service.findAll(dto);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get user by id")
    public UserItemDto getById(@PathVariable(value = "id") Long id){
        return service.findId(id);
    }

    @ApiOperation(value = "Update user")
    @PostMapping(value = "update", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public Result update(@RequestBody @Validated UserUpdateDto dto){
        return service.update(dto);
    }

    @PostMapping(value = "/save", consumes = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save user")
    public Result save(@RequestBody @Validated UserSaveDto dto){
        return service.save(dto);
    }
}
