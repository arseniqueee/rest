package rest.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.user.dao.UserDao;
import rest.user.dto.UserItemDto;
import rest.user.dto.UserListDto;
import rest.user.dto.UserListOutDto;
import rest.user.dto.UserUpdateDto;
import rest.user.mapper.UserMapper;
import rest.user.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserSerivceImpl implements UserService {

    private final UserDao dao;

    private final UserMapper mapper;

    @Autowired
    public UserSerivceImpl(UserDao dao, UserMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<UserListOutDto> findAll(UserListDto dto) {
        List<User> users = dao.findAll(dto.getOfficeId(), dto.getFirstName(), dto.getLastName(), dto.getMiddleName(), dto.getPosition(), dto.getDocCode(), dto.getCitizenshipCode());
        return mapper.mapAsList(users, UserListOutDto.class);
    }

    @Override
    public UserItemDto findId(Long id) {
        User user = dao.findById(id);
        return mapper.map(user, UserItemDto.class);
    }

    @Override
    @Transactional
    public void update(UserUpdateDto dto) {
        dao.update(mapper.map(dto, User.class));
    }
}
