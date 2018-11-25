package rest.docs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.docs.dao.DocsDao;
import rest.docs.dto.DocsListDto;
import rest.docs.mapper.DocsMapper;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DocsServiceImpl implements DocsService {

    private final DocsDao dao;

    private final DocsMapper mapper;

    @Autowired
    public DocsServiceImpl(DocsDao dao, DocsMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    /**
     * List documents
     * @return List of documents
     */
    @Override
    public List<DocsListDto> findAll() {
        return mapper.mapAsList(dao.getList(), DocsListDto.class);
    }
}
