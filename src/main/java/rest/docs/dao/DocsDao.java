package rest.docs.dao;

import rest.docs.dto.DocsListDto;
import rest.docs.model.Docs;
import rest.docs.model.DocsData;

import java.util.List;

/**
 * Document repository
 */
public interface DocsDao
{

    /**
     *
     * @return List of document
     */
    public List<Docs> getList();


    /**
     *
     * @param docs Docs entity for save
     */
    void saveDocs(Docs docs);

    /**
     *
     * @param code Document code
     * @return document entity
     */
    Docs findByCode(Long code);


}
