package io.github.carloscardoso05.bidflow.mapper;

import io.github.carloscardoso05.bidflow.dto.CreateUserRequest;
import io.github.carloscardoso05.bidflow.dto.UserResponse;
import io.github.carloscardoso05.bidflow.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toDto(User user);

    User toEntity(CreateUserRequest request);
}
