package edu.SimpleUserGroupsApp.service;

import edu.SimpleUserGroupsApp.model.Group;
import edu.SimpleUserGroupsApp.model.User;
import edu.SimpleUserGroupsApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable(value = "userCache", key = "#id")
    @PreAuthorize("hasAuthority('USER_READ')")
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PreAuthorize("hasAuthority('USER_READ')")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PreAuthorize("hasAuthority('USER_CREATE') and hasAuthority('USER_UPDATE')")
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @PreAuthorize("hasAuthority('USER_DELETE')")
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @PreAuthorize("hasAuthority('USER_CREATE')")
    public void addUserToGroup(User user, Group group) {
        user.getGroupList().add(group);
        saveUser(user);
    }
}
