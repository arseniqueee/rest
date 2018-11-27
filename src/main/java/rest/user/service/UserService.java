package rest.user.service;

import rest.response.Result;
import rest.user.dto.*;

import java.util.List;

/**
 * User service
 */
public interface UserService {

    /**
     * Find user by filter
     *
     * @param dto filter dto
     * @return list of users
     */
    List<UserListOutDto> findAll(UserListDto dto);

    /**
     * Find user by id
     *
     * @param id User id
     * @return item dto user
     */
    UserItemDto findId(Long id);

    /**
     * Update user
     *
     * @param dto update user dto
     * @return result
     */
    Result update(UserUpdateDto dto);

    /**
     * Save user
     *
     * @param dto save dto user
     * @return result
     */
    Result save(UserSaveDto dto);
}
