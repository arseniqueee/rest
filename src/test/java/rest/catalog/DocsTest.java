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
import rest.docs.dao.DocsDaoTest;
import rest.docs.model.Docs;
import rest.response.Response;

import java.util.List;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.isJson;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DocsTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private DocsDaoTest dao;

    @After
    public void resetDb(){
        dao.deleteAll();
        dao.flush();
    }

    @Test
    public void listDocs(){
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/docs")
                .build();

        create();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity req = new HttpEntity<>(headers);

        ResponseEntity<Response<List<Docs>>> res = restTemplate.exchange(uc.toUriString(), HttpMethod.POST, req, new ParameterizedTypeReference<Response<List<Docs>>>() {});

        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertThat(res.getBody().getData(), hasSize(2));
    }
    private Docs create(){
        Docs docs = new Docs(15L, "INN");
        return dao.saveAndFlush(docs);
    }
}
