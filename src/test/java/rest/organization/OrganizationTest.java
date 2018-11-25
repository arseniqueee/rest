package rest.organization;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import rest.Application;
import rest.organization.controller.OrganizationController;
import rest.organization.dao.OrganizationDao;
import rest.organization.dto.*;

import rest.response.Response;
import rest.response.Result;

import java.util.LinkedHashMap;
import java.util.List;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.isJson;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class, OrganizationController.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrganizationTest {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void listOrganizations() throws JsonProcessingException {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/organization/list")
                .build();

        OrganizationListDto listDto = new OrganizationListDto();
        listDto.setActive(true);
        listDto.setName("213");


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OrganizationListDto> req = new HttpEntity<>(listDto, headers);

        ResponseEntity<Response<List<OrganizationItemDto>>> res = restTemplate.exchange(uc.toUriString(), HttpMethod.POST, req, new ParameterizedTypeReference<Response<List<OrganizationItemDto>>>(){});


        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertThat(res.getBody().getData(), hasSize(1));

    }

    @Test
    public void getOrganizationById() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/organization/{id}")
                .buildAndExpand(1);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity req = new HttpEntity<>(headers);

        ResponseEntity<Response<OrganizationFullDto>> res = restTemplate.exchange(uc.toUriString(), HttpMethod.GET, req,new ParameterizedTypeReference<Response<OrganizationFullDto>>() {});


        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertThat(res.getBody().getData().getId(), is(1L));
    }

    @Test
    public void saveOrganization() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/organization/save")
                .build();

        OrganizationSaveDto saveDto = new OrganizationSaveDto();
        saveDto.setName("New organization");
        saveDto.setFullName("New organization");
        saveDto.setAddress("New organization address");
        saveDto.setPhone(null);
        saveDto.setInn("1425111136");
        saveDto.setKpp("1425GH121");
        saveDto.setActive(true);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OrganizationSaveDto> req = new HttpEntity<>(saveDto, headers);

        ResponseEntity<Response<Result>> res = restTemplate.exchange(uc.toUriString(), HttpMethod.POST, req, new ParameterizedTypeReference<Response<Result>>(){});

        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertThat(res.getBody().getData().getResult(), is("success"));

    }

    @Test
    public void updateOrganization() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/organization/update")
                .build();

        OrganizationUpdateDto updateDto = new OrganizationUpdateDto();
        updateDto.setId(2L);
        updateDto.setName("Updated organization");
        updateDto.setFullName("Updated organization");
        updateDto.setAddress("Updated organization address");
        updateDto.setPhone(null);
        updateDto.setInn("3664073127");
        updateDto.setKpp("366402002");
        updateDto.setActive(true);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OrganizationUpdateDto> req = new HttpEntity<>(updateDto, headers);

        ResponseEntity<Response<Result>> res = restTemplate.exchange(uc.toUriString(), HttpMethod.POST, req, new ParameterizedTypeReference<Response<Result>>(){});


        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertThat(res.getBody().getData().getResult(), is("success"));
    }
}
