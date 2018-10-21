package rest.docs.model;


import javax.persistence.*;

@Entity
@Table(name = "docs")
public class Docs {

    @Id
    @Column(name = "code")
    private int code;

    @Column(name = "name")
    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
