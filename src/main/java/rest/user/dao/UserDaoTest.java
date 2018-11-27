package rest.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.user.model.User;

public interface UserDaoTest extends JpaRepository<User, Long> {
}
