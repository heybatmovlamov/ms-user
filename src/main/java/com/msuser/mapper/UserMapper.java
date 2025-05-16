package com.msuser.mapper;

import static com.msuser.model.enums.UserRole.USER;
import static com.msuser.model.enums.UserStatus.ACTIVE;
import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;
import static org.mapstruct.ReportingPolicy.IGNORE;

import com.msuser.dao.entity.UserEntity;
import com.msuser.model.request.UserRequest;
import com.msuser.model.response.UserView;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = CONSTRUCTOR,
        unmappedSourcePolicy = IGNORE,
        unmappedTargetPolicy = IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<UserView> toView(List<UserEntity> entities);

    UserView toView(UserEntity entity);

    UserEntity toEntity(UserRequest request);

    @AfterMapping
    default void setDefaults(@MappingTarget UserEntity entity) {
        entity.setStatus(ACTIVE);
        entity.setRole(USER);
    }
}
