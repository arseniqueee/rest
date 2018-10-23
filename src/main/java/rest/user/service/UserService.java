package rest.user.service;

import rest.response.Result;
import rest.user.dto.*;

import java.util.List;

public interface UserService {

    List<UserListOutDto> findAll(UserListDto dto);

    UserItemDto findId(Long id);

    Result update(UserUpdateDto dto);

    Result save(UserSaveDto dto);
}
