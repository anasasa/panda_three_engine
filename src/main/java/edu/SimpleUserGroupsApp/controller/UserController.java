package edu.SimpleUserGroupsApp.controller;

import edu.SimpleUserGroupsApp.mapper.UserMapper;
import edu.SimpleUserGroupsApp.model.User;
import edu.SimpleUserGroupsApp.model.dto.UserDto;
import edu.SimpleUserGroupsApp.service.GroupService;
import edu.SimpleUserGroupsApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/app/users")
public class UserController {
    private UserService userService;
    private UserMapper userMapper;
    private GroupService groupService;


    @Autowired
    public UserController(UserService userService, UserMapper userMapper, GroupService groupService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.groupService = groupService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userMapper.mapDtoToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.stream()
                .map(user -> userMapper.mapUserToDto(user))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public UserDto getUserById(@PathVariable(value = "userId") Long userId) {
        return userMapper.mapUserToDto(userService.getUserById(userId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{userId}")
    public void deleteUser(@PathVariable(value = "userId") Long userId) {
        userService.deleteById(userId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateUser(@RequestBody UserDto userDto) {
        userService.saveUser(userService.saveUser(userMapper.mapDtoToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/addGroup/{groupId}")
    public void updateUserGroup(@RequestBody UserDto userDto,
                                @PathVariable(value = "groupId") long groupId) {
        userService.addUserToGroup(userMapper.mapDtoToUser(userDto), groupService.getGroupById(groupId));
    }
}
