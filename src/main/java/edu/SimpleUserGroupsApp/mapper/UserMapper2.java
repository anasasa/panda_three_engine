package edu.SimpleUserGroupsApp.mapper;

import edu.SimpleUserGroupsApp.model.User;
import edu.SimpleUserGroupsApp.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper2 {
    @Mappings({
            @Mapping(target = "userId", source = "id"),
            @Mapping(target = "userName", source = "username"),
            @Mapping(target = "userEmail", source = "email")
    })
    UserDto mapUserToUserDTO(User user);

    @Mappings({
            @Mapping(target = "id", source = "userId"),
            @Mapping(target = "username", source = "userName"),
            @Mapping(target = "email", source = "userEmail")
    })
    User mapUserDTOToUser(UserDto userDto);
}
