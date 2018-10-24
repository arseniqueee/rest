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
 * User service
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
     * Find user by filter
     * @param dto filter dto
     * @return list of users
     */
    @Override
    public List<UserListOutDto> findAll(UserListDto dto) {
        List<User> users = dao.findAll(dto.getOfficeId(), dto.getFirstName(), dto.getLastName(), dto.getMiddleName(), dto.getPosition(), dto.getDocCode(), dto.getCitizenshipCode());
        return mapper.mapAsList(users, UserListOutDto.class);
    }

    /**
     * Find user by id
     * @param id User id
     * @return item dto user
     */
    @Override
    public UserItemDto findId(Long id) {
        User user = dao.findById(id);
        return mapper.map(user, UserItemDto.class);
    }

    /**
     * Update user
     * @param dto update user dto
     * @return result
     */
    @Override
    @Transactional
    public Result update(UserUpdateDto dto) {
        dao.update(mapper.map(dto, User.class));
        return new Result("success");
    }

    /**
     * Save user
     * @param dto save dto user
     * @return result
     */
    @Override
    @Transactional
    public Result save(UserSaveDto dto) {
        if (dto.getDocCode() != null){
            if (docsDataDao.findById(dto.getDocCode()) != null){
                dao.save(mapper.map(dto, User.class));
            }else {
                throw new DocsDataNotFoundException();
            }
        }else {
            Docs docs = mapper.map(dto, Docs.class);
            if (docsDao.findByCode(docs.getCode()) == null){
                docsDao.saveDocs(docs);
            }
            dao.save(mapper.map(dto, User.class));
            DocsData data = new DocsData(dto.getDocNumber(), new Date(), dao.findLast().getId());
            docsDataDao.save(data);
            User user = dao.findLast();
            user.setDocCode(docsDataDao.findLast().getId());
            dao.save(user);
        }
        return new Result("success");
    }
}
