package rest.docs.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.docs.dao.DocsDao;
import rest.docs.model.Docs;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DocsServiceImpl implements DocsService {

    private final DocsDao dao;

    @Autowired
    public DocsServiceImpl(DocsDao dao) {
        this.dao = dao;
    }


    @Override
    public List<Docs> findAll() {
        return dao.getList();
    }
}
