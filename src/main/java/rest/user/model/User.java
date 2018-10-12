package rest.user.model;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 20)
    private Long id;

    @Column(name = "office_id", length = 20, nullable = false)
    private Long officeId;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "second_name", length = 100, nullable = false)
    private String seocindName;

    @Column(name = "middle_name", length = 100, nullable = false)
    private String middleName;

    @Column(name = "position")
    private String position;

    @Column(name = "doc_code")
    private int docCode;

    @Column(name = "city_code")
    private int citizenshipCode;

    public User() {
    }

    public User(Long officeId, String firstName, String seocindName, String middleName, String position, int docCode, int citizenshipCode) {
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
