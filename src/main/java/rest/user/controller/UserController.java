package rest.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rest.user.dto.UserItemDto;
import rest.user.dto.UserListDto;
import rest.user.dto.UserListOutDto;
import rest.user.dto.UserUpdateDto;
import rest.user.service.UserService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(value = "/list")
    public List<UserListOutDto> list(@RequestBody UserListDto dto){
       return service.findAll(dto);
    }

    @GetMapping(value = "/{id}")
    public UserItemDto getById(@PathVariable(value = "id") Long id){
        return service.findId(id);
    }

    @PostMapping(value = "update", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public void update(@RequestBody @Validated UserUpdateDto dto){
        service.update(dto);
    }
}
