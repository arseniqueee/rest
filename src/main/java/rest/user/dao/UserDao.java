package rest.user.dao;

import rest.user.dto.UserListDto;
import rest.user.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll(UserListDto dto);

    User findById(Long id);

    void update(User user);


}
