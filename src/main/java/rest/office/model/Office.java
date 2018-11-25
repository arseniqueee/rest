package rest.office.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import rest.organization.model.Organization;
import rest.user.model.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "office")
public class Office {

  /**
   * Office id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", length = 20)
  private Long id;

  /**
   * Organization id
   */
  @Column(name = "org_id", length = 20, nullable = false)
  private Long orgId;

  /**
   * Office name
   */
  @Column(name = "name", length = 100, nullable = false)
  private String name;

  /**
   * Office address
   */
  @Column(name = "address",length = 100, nullable = false)
  private String address;

  /**
   * Office phone
   */
  @Column(name = "phone", length = 12, nullable = false)
  private String phone;

  /**
   * Office active
   */
  @Column(name = "active", nullable = false)
  private boolean active;

  @ManyToOne
  @JoinColumn(name = "org_id", insertable = false, updatable = false)
  private Organization organization;

  @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
  private List<User> users;

  public Office() {
  }

  public Office(long orgId, String name, String address, String phone, boolean active) {
    this.orgId = orgId;
    this.name = name;
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


  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Organization getOrganization() {
    return organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
}
