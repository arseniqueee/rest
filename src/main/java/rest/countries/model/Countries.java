package rest.countries.model;


import javax.persistence.*;


/**
 * Country entity
 */
@Entity
@Table(name = "country")
public class Countries {

    /**
     * Country code
     */
    @Id
    @GeneratedValue
    @Column(name = "code")
    private Long code;

    /**
     * Country name
     */
    @Column(name = "name", length = 50)
    private String name;

    public Countries() {
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
