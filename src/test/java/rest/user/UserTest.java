package rest.user;


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
import rest.user.controller.UserController;
import rest.user.dto.UserListDto;
import rest.user.dto.UserSaveDto;
import rest.user.dto.UserUpdateDto;

import java.sql.Date;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static com.jayway.jsonpath.matchers.JsonPathMatchers.isJson;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class, UserController.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void listUser() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/user/list")
                .build();

        UserListDto filterDto = new UserListDto();
        filterDto.setOfficeId(1L);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserListDto> req = new HttpEntity<>(filterDto, headers);

        ResponseEntity<String> res = restTemplate.postForEntity(uc.toUriString(), req, String.class);
        String json = res.getBody();

        assertEquals(HttpStatus.OK, res.getStatusCode());

        assertThat(json, isJson());
        assertThat(json, hasJsonPath("$.data[*]", hasSize(1)));
    }

    @Test
    public void getUserById() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/user/{id}")
                .buildAndExpand(1);

        ResponseEntity<String> res = restTemplate.getForEntity(uc.toUriString(), String.class);
        String json = res.getBody();

        assertEquals(HttpStatus.OK, res.getStatusCode());

        assertThat(json, isJson());
        assertThat(json, hasJsonPath("$.data.id", equalTo(1)));
    }

    @Test
    public void saveUser() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/user/save")
                .build();

        Date docDate = new Date(21-12-2018);


        UserSaveDto saveDto = new UserSaveDto();
        saveDto.setOfficeId(2L);
        saveDto.setFirstName("New user first name");
        saveDto.setMiddleName("New middleName");
        saveDto.setPosition("New user position");
        saveDto.setSecondName("Second Name");
        saveDto.setCitizenshipCode(632L);
        saveDto.setDocNumber(10L);
        saveDto.setDocName("Pasport");
        saveDto.setDocDate(docDate);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserSaveDto> req = new HttpEntity<>(saveDto, headers);

        ResponseEntity<String> res = restTemplate.postForEntity(uc.toUriString(), req, String.class);
        String json = res.getBody();

        assertEquals(HttpStatus.OK, res.getStatusCode());

        assertThat(json, isJson());
        assertThat(json, hasJsonPath("$.data.result", equalTo("success")));
    }

    @Test
    public void updateUser() {
        UriComponents uc = UriComponentsBuilder.newInstance()
                .path("/user/update")
                .build();


        UserUpdateDto saveDto = new UserUpdateDto ();
        saveDto.setId(17L);
        saveDto.setOfficeId(2L);
        saveDto.setFirstName("Updated user first name");
        saveDto.setMiddleName("New middleName");
        saveDto.setPosition("Updated user position");
        saveDto.setSecondName("Second Name");
        saveDto.setCitizenshipCode(643L);
        saveDto.setDocCode(1L);



        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserUpdateDto > req = new HttpEntity<>(saveDto, headers);

        ResponseEntity<String> res = restTemplate.postForEntity(uc.toUriString(), req, String.class);
        String json = res.getBody();

        assertEquals(HttpStatus.OK, res.getStatusCode());

        assertThat(json, isJson());
        assertThat(json, hasJsonPath("$.data.result", equalTo("success")));
    }
}
