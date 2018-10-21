package rest.user.service;

import rest.response.Result;
import rest.user.dto.UserItemDto;
import rest.user.dto.UserListDto;
import rest.user.dto.UserListOutDto;
import rest.user.dto.UserUpdateDto;

import java.util.List;

public interface UserService {

    List<UserListOutDto> findAll(UserListDto dto);

    UserItemDto findId(Long id);

    Result update(UserUpdateDto dto);
}
