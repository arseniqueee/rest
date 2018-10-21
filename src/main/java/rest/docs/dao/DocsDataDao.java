package rest.docs.dao;

import rest.docs.model.DocsData;

public interface DocsDataDao {

    DocsData findById(Long id);
}
