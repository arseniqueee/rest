package rest.countries.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.countries.model.Countries;
import rest.countries.dao.CountriesDao;

import java.util.List;

/**
 * Country service
 */
@Service
public class CountriesServiceImpl implements CountriesService {

    private final CountriesDao dao;

    @Autowired
    public CountriesServiceImpl(CountriesDao dao) {
        this.dao = dao;
    }


    @Override
    public List<Countries> getList() {
        return dao.findAll();
    }
}
