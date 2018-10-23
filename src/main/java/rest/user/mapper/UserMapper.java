package rest.user.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import rest.docs.model.Docs;
import rest.user.dto.*;
import rest.user.model.User;

@Component
public class UserMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(User.class, UserListDto.class)
                .byDefault()
                .register();

        factory.classMap(User.class, UserListOutDto.class)
                .byDefault()
                .register();

        factory.classMap(User.class, UserItemDto.class)
                .byDefault()
                .register();

        factory.classMap(User.class, UserUpdateDto.class)
                .byDefault()
                .register();

        factory.classMap(User.class, UserSaveDto.class)
                .byDefault()
                .register();

        factory.classMap(Docs.class, UserSaveDto.class)
                .field("code", "docNumber")
                .field("name", "docName")
                .byDefault()
                .register();
    }
}
