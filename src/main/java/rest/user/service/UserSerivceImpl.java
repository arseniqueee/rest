package rest.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.user.dao.UserDao;

@Service
public class UserSerivceImpl implements UserService {

    private final UserDao dao;

    @Autowired
    public UserSerivceImpl(UserDao dao) {
        this.dao = dao;
    }
}
