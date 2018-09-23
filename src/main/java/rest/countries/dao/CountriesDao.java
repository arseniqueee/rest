package rest.countries.dao;

import rest.countries.model.Countries;

import java.util.List;

public interface CountriesDao {
    public List<Countries> findAll();
}
