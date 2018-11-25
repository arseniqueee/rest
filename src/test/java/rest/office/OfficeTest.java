package rest.office;

import org.hamcrest.MatcherAssert;
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
import rest.office.dto.*;

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
@SpringBootTest(classes = {Application.class, OfficeController.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OfficeTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void listOffice() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/office/list")
                .build();

        OfficeListDto filterDto = new OfficeListDto();
        filterDto.setOrgId(1L);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OfficeListDto> req = new HttpEntity<>(filterDto, headers);

        ResponseEntity<Response<List<OfficeListOutDto>>> res = restTemplate.exchange(uc.toUriString(), HttpMethod.POST, req, new ParameterizedTypeReference<Response<List<OfficeListOutDto>>>() {});


        assertEquals(HttpStatus.OK, res.getStatusCode());
        MatcherAssert.assertThat(res.getBody().getData(), hasSize(4));
    }

    @Test
    public void getOfficeById() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/office/{id}")
                .buildAndExpand(1);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity req = new HttpEntity<>(headers);

        ResponseEntity<Response<OfficeItemDto>> res = restTemplate.exchange(uc.toUriString(), HttpMethod.GET, req,new ParameterizedTypeReference<Response<OfficeItemDto>>() {});

        assertEquals(HttpStatus.OK, res.getStatusCode());
        MatcherAssert.assertThat(res.getBody().getData().getId(), is(1L));
    }

    @Test
    public void saveOffice() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/office/save")
                .build();
        Long aLong = new Long(2);
        OfficeSaveDto saveDto = new OfficeSaveDto();
        saveDto.setName("New office");
        saveDto.setAddress("New office address");
        saveDto.setOrgId(2L);
        saveDto.setPhone(null);
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

        OfficeUpdateDto updateDto = new OfficeUpdateDto();
        updateDto.setId(5L);
        updateDto.setName("Updated office");
        updateDto.setAddress("Updated office address");
        updateDto.setOrgId(2L);
        updateDto.setPhone(null);
        updateDto.setActive(true);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OfficeUpdateDto> req = new HttpEntity<>(updateDto, headers);

        ResponseEntity<Response<Result>> res = restTemplate.exchange(uc.toUriString(), HttpMethod.POST, req, new ParameterizedTypeReference<Response<Result>>(){});


        assertEquals(HttpStatus.OK, res.getStatusCode());
        assertThat(res.getBody().getData().getResult(), is("success"));
    }
}
