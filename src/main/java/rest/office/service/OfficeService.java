package rest.office.service;

import rest.office.model.Office;

import java.util.List;

public interface OfficeService {

    List<Office> findByIdOrg(Long orgId, String name, String phone, boolean isActive);

    Office findById(Long id);

    void save(Office office);


}
