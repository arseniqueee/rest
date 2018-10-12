package rest.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDaoImpl implements  UserDao {

    private final EntityManager manager;


    @Autowired
    public UserDaoImpl(EntityManager manager) {
        this.manager = manager;
    }
}
