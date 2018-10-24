package rest.organization;


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
import rest.organization.controller.OrganizationController;
import rest.organization.dto.OrganizationListDto;
import rest.organization.dto.OrganizationSaveDto;
import rest.organization.dto.OrganizationUpdateDto;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.isJson;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class, OrganizationController.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrganizationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void listOrganizations() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/organization/list")
                .build();

        OrganizationListDto listDto = new OrganizationListDto();
        listDto.setActive(true);
        listDto.setName("213");


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OrganizationListDto> req = new HttpEntity<>(listDto, headers);

        ResponseEntity<String> res = restTemplate.postForEntity(uc.toUriString(), req, String.class);
        String json = res.getBody();

        assertEquals(HttpStatus.OK, res.getStatusCode());

        assertThat(json, isJson());
        assertThat(json, hasJsonPath("$.data[*]", hasSize(1)));
    }

    @Test
    public void getOrganizationById() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/organization/{id}")
                .buildAndExpand(1);

        ResponseEntity<String> res = restTemplate.getForEntity(uc.toUriString(), String.class);
        String json = res.getBody();

        assertEquals(HttpStatus.OK, res.getStatusCode());

        assertThat(json, isJson());
        assertThat(json, hasJsonPath("$.data.id", equalTo(1)));
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

        ResponseEntity<String> res = restTemplate.postForEntity(uc.toUriString(), req, String.class);
        String json = res.getBody();

        assertEquals(HttpStatus.OK, res.getStatusCode());

        assertThat(json, isJson());
        assertThat(json, hasJsonPath("$.data.result", equalTo("success")));
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

        ResponseEntity<String> res = restTemplate.postForEntity(uc.toUriString(), req, String.class);
        String json = res.getBody();

        assertEquals(HttpStatus.OK, res.getStatusCode());

        assertThat(json, isJson());
        assertThat(json, hasJsonPath("$.data.result", equalTo("success")));
    }
}
