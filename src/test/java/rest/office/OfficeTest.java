package rest.office;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import rest.Application;
import rest.office.controller.OfficeController;
import rest.office.dto.OfficeListDto;

import rest.office.dto.OfficeSaveDto;
import rest.office.dto.OfficeUpdateDto;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.isJson;
import static org.hamcrest.Matchers.hasSize;
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

        ResponseEntity<String> res = restTemplate.postForEntity(uc.toUriString(), req, String.class);
        String json = res.getBody();

        assertEquals(HttpStatus.OK, res.getStatusCode());

        assertThat(json, isJson());
        assertThat(json, hasJsonPath("$.data[*]", hasSize(4)));
    }

    @Test
    public void getOfficeById() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/office/{id}")
                .buildAndExpand(1);

        ResponseEntity<String> res = restTemplate.getForEntity(uc.toUriString(), String.class);
        String json = res.getBody();

        assertEquals(HttpStatus.OK, res.getStatusCode());

        assertThat(json, isJson());
        assertThat(json, hasJsonPath("$.data.id", equalTo(1)));
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

        ResponseEntity<String> res = restTemplate.postForEntity(uc.toUriString(), req, String.class);
        String json = res.getBody();

        assertEquals(HttpStatus.OK, res.getStatusCode());

        assertThat(json, isJson());
        assertThat(json, hasJsonPath("$.data.result", equalTo("success")));
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

        ResponseEntity<String> res = restTemplate.postForEntity(uc.toUriString(), req, String.class);
        String json = res.getBody();

        assertEquals(HttpStatus.OK, res.getStatusCode());

        assertThat(json, isJson());
        assertThat(json, hasJsonPath("$.data.result", equalTo("success")));
    }
}
