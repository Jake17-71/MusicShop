package ru.randomplay.musicshop.mapper;

import org.mapstruct.*;
import ru.randomplay.musicshop.dto.UserCreateRequest;
import ru.randomplay.musicshop.entity.User;
import ru.randomplay.musicshop.model.UserActivity;
import ru.randomplay.musicshop.model.UserRole;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "activity", ignore = true)
    @Mapping(target = "registeredAt", ignore = true)
    public abstract User toUser(UserCreateRequest userCreateRequest);

    @AfterMapping
    protected void setDefaults(@MappingTarget User user) {
        user.setRole(UserRole.CUSTOMER);
        user.setActivity(UserActivity.ACTIVE);
    }
}
