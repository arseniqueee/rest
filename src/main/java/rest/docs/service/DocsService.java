package rest.docs.service;

import rest.docs.dto.DocsListDto;
import rest.docs.model.Docs;

import java.util.List;

public interface DocsService {

    List<DocsListDto> findAll();
}
