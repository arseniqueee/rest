package rest.organization.model;


import io.swagger.annotations.ApiModel;
import rest.office.model.Office;

import javax.persistence.*;
import java.util.List;

/**
 * Organization entity
 */
@Entity
@Table(name = "organization")
public class Organization {

    /**
     * Organization id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 20)
    private Long id;

    /**
     * Organization name
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Organization full name
     */
    @Column(name = "full_name", length = 100, nullable = false)
    private String fullName;

    /**
     * Organization inn
     */
    @Column(name = "inn", length = 12, nullable = false)
    private String inn;

    /**
     * Organization kpp
     */
    @Column(name = "kpp", length = 9, nullable = false)
    private String kpp;

    /**
     * Organization address
     */
    @Column(name = "address", length = 100, nullable = false)
    private String address;

    /**
     * Organization phone
     */
    @Column(name = "phone", length = 12, nullable = true)
    private String phone;

    /**
     * Organization active
     */
    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    private List<Office> offices;

    public Organization() {

    }

    public Organization(String name, String fullName, String inn, String kpp, String address, String phone, boolean active) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
