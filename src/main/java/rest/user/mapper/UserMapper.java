package rest.user.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import rest.user.dto.UserItemDto;
import rest.user.dto.UserListDto;
import rest.user.dto.UserListOutDto;
import rest.user.dto.UserUpdateDto;
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
    }
}
