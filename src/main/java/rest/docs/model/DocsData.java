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
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /**
     * Docs code
     */
    @Column(name = "docs_code", nullable = false)
    private Long docsCode;

    /**
     * Add date DocsData
     */
    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    /**
     * User id
     */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docs_code", insertable = false, updatable = false)
    private Docs docs;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable =  false, insertable = false)
    private User user;

    public DocsData() {
    }

    public DocsData(Long docsCode, Date date, Long userId) {
        this.docsCode = docsCode;
        this.date = date;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Docs getDocs() {
        return docs;
    }

    public void setDocs(Docs docs) {
        this.docs = docs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
