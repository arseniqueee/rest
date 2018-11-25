package rest.docs.model;

import rest.user.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "docs_data")
public class DocsData {

    /**
     * DocsData id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Docs code
     */
    @Column(name = "docs_code", nullable = false)
    private Long docsCode;

    @Column(name = "docs_number", nullable = false)
    private Long docsNumber;

    /**
     * Add date DocsData
     */
    @Column(name = "date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date date;

    /**
     * User id
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docs_code", insertable = false, updatable = false)
    private Docs docs;


    public DocsData() {
    }

    public DocsData(Long docsCode, Date date, Long docsNumber) {
        this.docsCode = docsCode;
        this.date = date;
        this.docsNumber = docsNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDocsCode() {
        return docsCode;
    }

    public void setDocsCode(Long docsCode) {
        this.docsCode = docsCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Docs getDocs() {
        return docs;
    }

    public void setDocs(Docs docs) {
        this.docs = docs;
    }


    public Long getDocsNumber() {
        return docsNumber;
    }

    public void setDocsNumber(Long docsNumber) {
        this.docsNumber = docsNumber;
    }
}
