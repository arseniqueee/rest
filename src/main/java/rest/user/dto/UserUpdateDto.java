package rest.user.dto;

import javax.validation.constraints.NotNull;

public class UserUpdateDto {

    private Long id;

    private Long officeId;

    private String firstName;

    private String secondName;

    private String middleName;

    private String position;

    private Long docCode;

    private Long citizenshipCode;

    private boolean identified;

    public UserUpdateDto() {
    }

    public UserUpdateDto(Long id, Long officeId, String firstName, String secondName, String middleName, String position, Long docCode, Long citizenshipCode, boolean identified) {
        this.id = id;
        this.officeId = officeId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.docCode = docCode;
        this.citizenshipCode = citizenshipCode;
        this.identified = identified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    @NotNull(message = "First name not be null")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @NotNull(message = "Position not be null")
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

    public boolean isIdentified() {
        return identified;
    }

    public void setIdentified(boolean identified) {
        this.identified = identified;
    }
}
