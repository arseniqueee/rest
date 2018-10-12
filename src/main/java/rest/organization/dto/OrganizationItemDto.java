package rest.organization.dto;

public class OrganizationItemDto {

    private long id;

    private String name;

    private Boolean active;

    public OrganizationItemDto() {
    }

    public OrganizationItemDto(long id, String name, Boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
