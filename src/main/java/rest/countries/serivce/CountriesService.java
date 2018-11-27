package rest.countries.serivce;

import rest.countries.model.Countries;

import java.util.List;

/**
 * Country service
 */
public interface CountriesService {

    /**
     * Get list countries
     * @return List of countries
     */
    List<Countries> getList();
}
