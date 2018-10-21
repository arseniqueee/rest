package rest.user.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.security.acl.LastOwnerException;

public class UserListDto {

    private Long officeId;

    private String firstName;

    private String lastName;

    private String middleName;

    private String position;

    private Long docCode;

    private Long citizenshipCode;

    public UserListDto() {
    }

    public UserListDto(Long officeId, String firstName, String lastName, String middleName, String position, Long docCode, Long citizenshipCode) {
        this.officeId = officeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.position = position;
        this.docCode = docCode;
        this.citizenshipCode = citizenshipCode;
    }

    @ApiModelProperty(required = true)
    @NotNull
    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getDocCode() {
        return docCode;
    }

    public void setDocCode(Long docCode) {
        this.docCode = docCode;
    }

    public Long getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(Long citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }
}
