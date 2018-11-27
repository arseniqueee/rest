package rest.countries.dao;

import rest.countries.model.Countries;

import java.util.List;

/**
 * Country repository
 */
public interface CountriesDao {

    /**
     * Get all countries
     * @return List of countries
     */
    public List<Countries> findAll();
}
