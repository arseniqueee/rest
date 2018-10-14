package rest.user.service;

import rest.user.dto.UserItemDto;
import rest.user.dto.UserListDto;
import rest.user.dto.UserListOutDto;
import rest.user.dto.UserUpdateDto;

import java.util.List;

public interface UserService {

    List<UserListOutDto> findAll(UserListDto dto);

    UserItemDto findId(Long id);

    void update(UserUpdateDto dto);
}
