package rest.user.dao;

import rest.user.model.User;

import java.util.List;

/**
 * User repository
 */
public interface UserDao {

    /**
     * Find users by filter
     * @param officeId office id
     * @param firstName full name user
     * @param lastName last name user
     * @param middleName middle name user
     * @param position position of user
     * @param docCode document code user
     * @param citizenshipCode city code
     * @return
     */
    List<User> findAll(Long officeId, String firstName, String lastName, String middleName, String position, Long docCode, Long citizenshipCode);

    /**
     * Find user by id
     * @param id User id
     * @return User entity
     */
    User findById(Long id);

    /**
     * Update user
     * @param user User entity
     */
    void update(User user);

    /**
     * Save user
     * @param user User entity
     */
    void save(User user);




}
