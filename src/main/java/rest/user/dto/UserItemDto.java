package rest.user.dto;

public class UserItemDto {

    private Long id;

    private Long officeId;

    private String firstName;

    private String seocindName;

    private String middleName;

    private String position;

    private int docCode;

    private int citizenshipCode;

    public UserItemDto() {
    }

    public UserItemDto(Long id, Long officeId, String firstName, String seocindName, String middleName, String position, int docCode, int citizenshipCode) {
        this.id = id;
        this.officeId = officeId;
        this.firstName = firstName;
        this.seocindName = seocindName;
        this.middleName = middleName;
        this.position = position;
        this.docCode = docCode;
        this.citizenshipCode = citizenshipCode;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSeocindName() {
        return seocindName;
    }

    public void setSeocindName(String seocindName) {
        this.seocindName = seocindName;
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

    public int getDocCode() {
        return docCode;
    }

    public void setDocCode(int docCode) {
        this.docCode = docCode;
    }

    public int getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(int citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }
}
