package edu.SimpleUserGroupsApp.model.security;

import edu.SimpleUserGroupsApp.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "AUTHORITY")
public class Authority implements GrantedAuthority {
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "authorities")
    List<User> userList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Override
    public String getAuthority() {
        return getName();
    }
}
