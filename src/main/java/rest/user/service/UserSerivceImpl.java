package rest.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.docs.dao.DocsDao;
import rest.docs.dao.DocsDataDao;
import rest.docs.model.Docs;
import rest.docs.model.DocsData;
import rest.exception.DocsDataNotFoundException;
import rest.response.Result;
import rest.user.dao.UserDao;
import rest.user.dto.*;
import rest.user.mapper.UserMapper;
import rest.user.model.User;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
public class UserSerivceImpl implements UserService {

    private final UserDao dao;

    private final UserMapper mapper;

    private final DocsDataDao docsDataDao;

    private final DocsDao docsDao;

    @Autowired
    public UserSerivceImpl(UserDao dao, UserMapper mapper, DocsDataDao docsDataDao, DocsDao docsDao) {
        this.dao = dao;
        this.mapper = mapper;
        this.docsDataDao = docsDataDao;
        this.docsDao = docsDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserListOutDto> findAll(UserListDto dto) {
        List<User> users = dao.findAll(dto.getOfficeId(), dto.getFirstName(), dto.getLastName(), dto.getMiddleName(), dto.getPosition(), dto.getDocCode(), dto.getCitizenshipCode());
        return mapper.mapAsList(users, UserListOutDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserItemDto findId(Long id) {
        User user = dao.findById(id);
        return mapper.map(user, UserItemDto.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Result update(UserUpdateDto dto) {
        dao.update(mapper.map(dto, User.class));
        return new Result("success");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Result save(UserSaveDto dto) {
        if (docsDao.findByCode(dto.getDocCode()) != null) {
            DocsData data = new DocsData(dto.getDocCode(), new Date(), dto.getDocNumber());
            docsDataDao.save(data);
            User user = mapper.map(dto, User.class);
            DocsData data1 = docsDataDao.findLast();
            user.setDocCode(data1.getId());
            dao.save(user);
        }else {
            throw new DocsDataNotFoundException();
        }

        return new Result("success");
    }
}
