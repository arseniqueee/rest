package rest.docs.dao;

import rest.docs.model.Docs;
import rest.docs.model.DocsData;

import java.util.List;

public interface DocsDao
{

    public List<Docs> getList();

    public void saveDocData(DocsData docsData);

    void saveDocs(Docs docs);

    Docs findByCode(Long code);


}
