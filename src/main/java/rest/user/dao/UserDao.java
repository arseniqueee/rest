package rest.user.dao;

import rest.user.dto.UserListDto;
import rest.user.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll(Long officeId, String firstName, String lastName, String middleName, String position, Long docCode, Long citizenshipCode);

    User findById(Long id);

    void update(User user);

    void save(User user);

    User findLast();


}
