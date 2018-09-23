package rest.office.dao;

import rest.office.model.Office;
import java.util.List;

public interface OfficeDao {

    public List<Office> findByIdOrg(Long id, String name, String phone, boolean isActive);

    public Office findById(Long id);

    public void save(Office office);
}
