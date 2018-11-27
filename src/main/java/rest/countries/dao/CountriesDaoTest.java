package rest.countries.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.countries.model.Countries;

/**
 * Country repository for test
 */
public interface CountriesDaoTest extends JpaRepository<Countries, Long> {
}
