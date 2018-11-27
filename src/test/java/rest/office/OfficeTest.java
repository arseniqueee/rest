package rest.office;

import org.hamcrest.MatcherAssert;
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
import rest.office.controller.OfficeController;
import rest.office.dao.OfficeDaoTest;
import rest.office.dto.*;

import rest.office.model.Office;
import rest.response.Response;
import rest.response.Result;

import java.util.List;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.isJson;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OfficeTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private OfficeDaoTest dao;

    @After
    public void resetDb(){
        dao.deleteAll();
        dao.flush();
    }

    @Test
    public void listOffice() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/office/list")
                .build();

        Long id = create("New Office").getId();
        create("New office 2");

        OfficeListDto filterDto = new OfficeListDto();
        filterDto.setOrgId(1L);
        filterDto.setActive(true);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OfficeListDto> req = new HttpEntity<>(filterDto, headers);

        ResponseEntity<Response<List<OfficeListOutDto>>> res = restTemplate.exchange(uc.toUriString(), HttpMethod.POST, req, new ParameterizedTypeReference<Response<List<OfficeListOutDto>>>() {});


        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertThat(res.getBody().getData(), hasSize(2));
    }

    @Test
    public void getOfficeById() {
        Long id = create("Office").getId();

        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/office/{id}")
                .buildAndExpand(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity req = new HttpEntity<>(headers);

        ResponseEntity<Response<OfficeItemDto>> res = restTemplate.exchange(uc.toUriString(), HttpMethod.GET, req,new ParameterizedTypeReference<Response<OfficeItemDto>>() {});

        assertEquals(HttpStatus.OK, res.getStatusCode());
        MatcherAssert.assertThat(res.getBody().getData().getId(), is(id));
    }

    @Test
    public void saveOffice() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/office/save")
                .build();

        OfficeSaveDto saveDto = new OfficeSaveDto();
        saveDto.setName("New office");
        saveDto.setAddress("New office address");
        saveDto.setOrgId(1L);
        saveDto.setPhone("+45653312");
        saveDto.setActive(true);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OfficeSaveDto> req = new HttpEntity<>(saveDto, headers);

        ResponseEntity<Response<Result>> res = restTemplate.exchange(uc.toUriString(), HttpMethod.POST, req, new ParameterizedTypeReference<Response<Result>>(){});


        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertThat(res.getBody().getData().getResult(), is("success"));
    }

    @Test
    public void updateOffice() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/office/update")
                .build();

        Long id = create("Office").getId();

        OfficeUpdateDto updateDto = new OfficeUpdateDto();
        updateDto.setId(id);
        updateDto.setName("Updated office");
        updateDto.setAddress("Updated office address");
        updateDto.setOrgId(1L);
        updateDto.setPhone("+63232156478");
        updateDto.setActive(true);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OfficeUpdateDto> req = new HttpEntity<>(updateDto, headers);

        ResponseEntity<Response<Result>> res = restTemplate.exchange(uc.toUriString(), HttpMethod.POST, req, new ParameterizedTypeReference<Response<Result>>(){});


        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertThat(res.getBody().getData().getResult(), is("success"));
    }

    private Office create(String name){
        Office office = new Office(1L, name, "Address", "Phone", true);
        return dao.saveAndFlush(office);
    }
}
