package rest.docs.dao;

import rest.docs.model.DocsData;

public interface DocsDataDao {

    /**
     * Find DocsData by id
     * @param id document data id
     * @return DocsData entity
     */
    DocsData findById(Long id);

    /**
     * Save DocsData
     * @param data Entity for save
     */
    void save(DocsData data);

    /**
     * Find last row in DocsData table
     * @return DocsData entity
     */
    DocsData findLast();
}
