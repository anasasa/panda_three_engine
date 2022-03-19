package edu.SimpleUserGroupsApp.configuration.security;

import edu.SimpleUserGroupsApp.model.User;
import edu.SimpleUserGroupsApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s)  {
        User user = userRepository.findByUsername(s);

        return new CustomUserDetails(user);
    }
}
