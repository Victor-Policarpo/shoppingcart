package victor.policarpo.shoppingcart.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import victor.policarpo.shoppingcart.dto.request.CreateUser;
import victor.policarpo.shoppingcart.dto.response.UserResponse;
import victor.policarpo.shoppingcart.entity.User;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User toEntity(CreateUser userRequest);
    UserResponse toUserResponse(User entity);
    List<UserResponse> toListResponseDto(List<User> entity);
}
