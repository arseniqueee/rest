package rest.office.dto;

public class OfficeListDto {

    private Long orgId;

    private String name;

    private String phone;

    private boolean active;

    public OfficeListDto() {
    }

    public OfficeListDto(Long orgId, String name, String phone, boolean active) {
        this.orgId = orgId;
        this.name = name;
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
