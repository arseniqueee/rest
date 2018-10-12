package rest.office.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.property.RegexPropertyResolver;
import org.springframework.stereotype.Component;
import rest.office.dto.OfficeListDto;
import rest.office.dto.OfficeListOutDto;
import rest.office.dto.OfficeSaveDto;
import rest.office.dto.OfficeUpdateDto;
import rest.office.model.Office;

@Component
public class OfficeMapper extends ConfigurableMapper {


    protected void configure(MapperFactory factory) {
        factory.classMap(Office.class, OfficeListDto.class)
                .byDefault()
                .register();

        factory.classMap(Office.class, OfficeUpdateDto.class)
                .field("isActive", "active")
                .byDefault()
                .register();

        factory.classMap(Office.class, OfficeSaveDto.class)
                .field("isActive", "active")
                .byDefault()
                .register();

        factory.classMap(Office.class, OfficeListOutDto.class)
                .byDefault()
                .register();
    }
}
