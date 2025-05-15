package com.msuser.mapper;

import com.msuser.dao.entity.UserEntity;
import com.msuser.model.request.UserRequest;
import com.msuser.model.response.UserView;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<UserView> toView(List<UserEntity> entities);

    UserView toView(UserEntity entity);

    UserEntity toEntity(UserRequest request);
}
