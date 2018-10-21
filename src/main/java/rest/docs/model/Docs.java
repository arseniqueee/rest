package rest.docs.model;


import javax.persistence.*;

@Entity
@Table(name = "docs")
public class Docs {

    @Id
    @Column(name = "code")
    private Long code;

    @Column(name = "name")
    private String name;

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
