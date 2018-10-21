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

@Repository
public class UserDaoImpl implements  UserDao {

    private final EntityManager manager;



    @Autowired
    public UserDaoImpl(EntityManager manager) {
        this.manager = manager;

    }


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

    @Override
    public User findById(Long id) {
        return manager.find(User.class, id);
    }

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


}
