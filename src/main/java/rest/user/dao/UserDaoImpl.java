package rest.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rest.docs.dao.DocsDataDao;
import rest.docs.model.DocsData;
import rest.exception.DocsDataNotFoundException;
import rest.exception.UserNotFoundException;
import rest.user.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * User repository
 */
@Repository
public class UserDaoImpl implements  UserDao {

    private final EntityManager manager;



    @Autowired
    public UserDaoImpl(EntityManager manager) {
        this.manager = manager;

    }

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
    @Override
    public List<User> findAll(Long officeId, String firstName, String lastName, String middleName, String position, Long docCode, Long citizenshipCode) {
        String query = "SELECT u FROM User u WHERE u.officeId = :officeId ";
        if (firstName != null){
            query += "and u.firstName = :firstName ";
        }
        if (lastName != null){
            query += "and u.lastName = :lastName ";
        }
        if (middleName!= null){
            query += "and u.middleName = :middleName ";
        }
        if (position!= null){
            query += "and u.position = :position ";
        }
        if (docCode != null){
            query += "and u.docCode = :docCode ";
        }
        if (citizenshipCode != null){
            query += "and u.citizenshipCode = :citizenshipCode ";
        }
        TypedQuery<User> result = manager.createQuery(query, User.class);
        if (firstName != null){
            result.setParameter("firstName", firstName);
        }
        if (lastName != null){
            result.setParameter("lastName", lastName);
        }
        if (middleName!= null){
            result.setParameter("middleName", middleName);
        }
        if (position!= null){
            result.setParameter("position", position);
        }
        if (docCode != null){
            result.setParameter("docCode", docCode);
        }
        if (citizenshipCode != null){
            result.setParameter("citizenshipCode", citizenshipCode);
        }
        result.setParameter("officeId", officeId);
        return result.getResultList();
    }

    /**
     * Find user by id
     * @param id User id
     * @return User entity
     */
    @Override
    public User findById(Long id) {
        return manager.find(User.class, id);
    }

    /**
     * Update user
     * @param user User entity
     */
    @Override
    public void update(User user) {
        User us = new User();
        us = manager.find(User.class, user.getId());
        if (us == null){
            throw new UserNotFoundException("User not found");
        }
        us.setFirstName(user.getFirstName());
        us.setMiddleName(user.getMiddleName());
        us.setSecondName(user.getSecondName());
        us.setPosition(user.getPosition());
        DocsData data = manager.find(DocsData.class, user.getDocCode());
        if (data != null) {
            us.setDocCode(user.getDocCode());
        }
        else {
            throw new DocsDataNotFoundException("DocsData not found");
        }
        us.setCitizenshipCode(user.getCitizenshipCode());
        us.setOfficeId(user.getOfficeId());
        us.setIdentified(user.isIdentified());
        manager.persist(us);
    }


    /**
     * Save user
     * @param user User entity
     */
    @Override
    public void save(User user) {
        User userNew = new User();
        userNew.setFirstName(user.getFirstName());
        userNew.setMiddleName(user.getMiddleName());
        userNew.setSecondName(user.getSecondName());
        userNew.setOfficeId(user.getOfficeId());
        userNew.setDocCode(user.getDocCode());
        userNew.setPosition(user.getPosition());
        userNew.setCitizenshipCode(user.getCitizenshipCode());
        userNew.setIdentified(user.isIdentified());
        userNew.setLastName(user.getLastName());
        manager.persist(userNew);
    }

    @Override
    public User findLast() {
        String query = "select u from User u order by u.id desc";
        TypedQuery<User> result = manager.createQuery(query, User.class);
        return result.getResultList().get(0);
    }


}
