package rest.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rest.user.dto.UserListDto;
import rest.user.model.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements  UserDao {

    private final EntityManager manager;


    @Autowired
    public UserDaoImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<User> findAll(UserListDto dto) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return manager.find(User.class, id);
    }

    @Override
    public void update(User user) {
        User us = manager.find(User.class, user.getId());
        us.setFirstName(user.getFirstName());
        us.setMiddleName(user.getMiddleName());
        us.setSecondName(user.getSecondName());
        us.setPosition(user.getPosition());
        us.setDocCode(user.getDocCode());
        us.setCitizenshipCode(user.getCitizenshipCode());
        us.setOfficeId(user.getOfficeId());
        us.setIdentified(user.isIdentified());
        manager.persist(us);
    }


}
