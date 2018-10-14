package rest.organization.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import rest.organization.dto.*;
import rest.organization.model.Organization;

@Component
public class OrganizationMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(Organization.class, OrganizationItemDto.class)
                .byDefault()
                .register();

        factory.classMap(Organization.class, OrganizationListDto.class)
                .byDefault()
                .register();


        factory.classMap(Organization.class, OrganizationFullDto.class)
                .byDefault()
                .register();

        factory.classMap( Organization.class, OrganizationSaveDto.class)
//                .field("isActive", "active")
                .byDefault()
                .register();

        factory.classMap( Organization.class, OrganizationUpdateDto.class)
//                .field("isActive", "active")
                .byDefault()
                .register();
    }
}
