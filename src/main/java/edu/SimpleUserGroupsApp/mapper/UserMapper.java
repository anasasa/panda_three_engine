package edu.SimpleUserGroupsApp.mapper;

import edu.SimpleUserGroupsApp.model.User;
import edu.SimpleUserGroupsApp.model.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto mapUserToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }

    public User mapDtoToUser(UserDto userDto) {
        return new User(
                userDto.getUserId(),
                userDto.getUserName(),
                userDto.getUserEmail()
        );
    }


    public List<UserDto> mapListToDto(List<User> users) {
        return users.stream()
                .map(user -> mapUserToDto(user))
                .collect(Collectors.toList());
    }
}
