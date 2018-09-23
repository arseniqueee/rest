package rest.countries.model;


import javax.persistence.*;

@Entity
@Table(name = "country")
public class Countries {

    @Id
    @GeneratedValue
    @Column(name = "code")
    private int code;

    @Column(name = "name", length = 50)
    private String name;

    public Countries() {
    }

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