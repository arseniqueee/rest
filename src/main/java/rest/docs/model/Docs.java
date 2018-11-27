package rest.docs.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "docs")
public class Docs {

    /**
     * Docs id
     */
    @Id
    @Column(name = "code")
    private Long code;

    /**
     * Docs name
     */
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "docs", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DocsData> docsDatas;

    public Docs() {
    }

    public Docs(Long code, String name) {
        this.code = code;
        this.name = name;
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

    public List<DocsData> getDocsDatas() {
        return docsDatas;
    }

    public void setDocsDatas(List<DocsData> docsDatas) {
        this.docsDatas = docsDatas;
    }
}
