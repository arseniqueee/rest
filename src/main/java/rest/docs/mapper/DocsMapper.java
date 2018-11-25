package rest.docs.mapper;


import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import rest.docs.dto.DocsListDto;
import rest.docs.model.Docs;

@Component
public class DocsMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(Docs.class, DocsListDto.class)
                .byDefault()
                .register();
    }

}
