package rest.catalog;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import rest.Application;
import rest.countries.controller.CountriesController;
import rest.countries.dao.CountriesDaoTest;
import rest.countries.model.Countries;
import rest.response.Response;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CountryTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CountriesDaoTest dao;

    @After
    public void resetDb(){
        dao.deleteAll();
        dao.flush();
    }

    @Test
    public void listCountries(){
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/countries")
                .build();

        create();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity req = new HttpEntity<>( headers);

        ResponseEntity<Response<List<Countries>>> res = restTemplate.exchange(uc.toUriString(), HttpMethod.POST, req, new ParameterizedTypeReference<Response<List<Countries>>>() {});

        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertThat(res.getBody().getData(), hasSize(2));
    }

    private Countries create(){
        Countries countries = new Countries(15L, "Germany");
        return dao.saveAndFlush(countries);
    }
}
