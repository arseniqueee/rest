package rest.office.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import rest.organization.model.Organization;

import javax.persistence.*;

@Entity
@Table(name = "office")
public class Office {

  @Id
  @GeneratedValue
  @Column(name = "id", length = 20)
  private Long id;

  @Column(name = "org_id", length = 20, nullable = false)
  private Long orgId;

  @Column(name = "name", length = 100, nullable = false)
  private String name;

  @Column(name = "address",length = 100, nullable = false)
  private String address;

  @Column(name = "phone", length = 12, nullable = false)
  private String phone;

  @Column(name = "is_active")
  private boolean isActive;

  @ManyToOne
  @JoinColumn(name = "org_id", insertable = false, updatable = false)
  private Organization organization;

  public Office() {
  }

  public Office(long orgId, String name, String address, String phone, boolean isActive) {
    this.orgId = orgId;
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.isActive = isActive;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getOrgId() {
    return orgId;
  }

  public void setOrgId(Long orgId) {
    this.orgId = orgId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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


  public boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(boolean isActive) {
    this.isActive = isActive;
  }

}
