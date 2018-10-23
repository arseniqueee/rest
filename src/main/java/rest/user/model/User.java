package rest.user.model;


import rest.countries.model.Countries;
import rest.docs.model.DocsData;
import rest.office.model.Office;

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

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "second_name", length = 100, nullable = false)
    private String secondName;

    @Column(name = "middle_name", length = 100, nullable = false)
    private String middleName;

    @Column(name = "position", length = 50, nullable = false)
    private String position;

    @Column(name = "doc_code", nullable = false)
    private Long docCode;

    @Column(name = "city_code", nullable = false)
    private Long citizenshipCode;

    @Column(name = "identified", nullable = false)
    private boolean identified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id", insertable = false, updatable = false)
    private Office office;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_code", insertable = false, updatable = false)
    private DocsData docsData;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_code", updatable = false, insertable = false)
    private Countries countries;

    public User() {
    }

    public User(Long officeId, String firstName, String lastName, String secondName, String middleName, String position, Long docCode, Long citizenshipCode, boolean identified) {
        this.officeId = officeId;
        this.lastName = lastName;
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
        this.secondName= secondName;
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

    public boolean isIdentified() {
        return identified;
    }

    public void setIdentified(boolean identified) {
        this.identified = identified;
    }

    public DocsData getDocsData() {
        return docsData;
    }

    public void setDocsData(DocsData docsData) {
        this.docsData = docsData;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
}
