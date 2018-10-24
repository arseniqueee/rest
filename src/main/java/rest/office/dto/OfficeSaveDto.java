package rest.office.dto;

public class OfficeSaveDto {

    private Long orgId;

    private String name;

    private String address;

    private String phone;

    private boolean active;

    public OfficeSaveDto() {
    }

    public OfficeSaveDto(Long orgId, String name, String address, String phone, boolean active) {
        this.orgId = orgId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.active = active;
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
}
