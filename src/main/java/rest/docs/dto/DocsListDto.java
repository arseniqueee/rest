package rest.docs.dto;

public class DocsListDto {

    private Long code;

    private String name;

    public DocsListDto() {
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
