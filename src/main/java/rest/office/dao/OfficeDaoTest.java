package rest.office.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.office.model.Office;

public interface OfficeDaoTest extends JpaRepository<Office, Long> {
}
