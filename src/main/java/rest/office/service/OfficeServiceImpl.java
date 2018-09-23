package rest.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.office.dao.OfficeDao;
import rest.office.model.Office;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao dao;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Office> findByIdOrg(Long orgId, String name, String phone, boolean isActive) {
        return dao.findByIdOrg(orgId, name, phone, isActive);
    }

    @Override
    public Office findById(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public void save(Office office) {
        dao.save(office);
    }
}
