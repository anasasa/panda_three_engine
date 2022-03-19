package edu.SimpleUserGroupsApp.model.security;

import edu.SimpleUserGroupsApp.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "AUTHORITY")
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "authorities")
    List<User> userList;

    @Override
    public String getAuthority() {
        return getName();
    }
}
