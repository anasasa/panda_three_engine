package edu.SimpleUserGroupsApp.model;

import edu.SimpleUserGroupsApp.model.security.Authority;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "USERS")
public class User implements UserDetails {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private long id;

    @NotNull
    @Column(name = "USER_NAME",
            unique = true)
    private String username;

    @NotNull
    @Column(name = "USER_EMAIL",
            unique = true)
    private String email;

    @Column(name = "PASSWORD")
    private String password;


    @Column(name = "ACCOUNT_EXPIRED")
    private boolean accountExpired;

    @Column(name = "ACCOUNT_LOCKED")
    private boolean accountLocked;

    @Column(name = "CREDENTIALS_EXPIRED")
    private boolean credentialsExpired;

    @Column(name = "ENABLED")
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_USERS_GROUPS",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "GROUP_ID")}
    )
    private List<Group> groupList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "USERS_AUTHORITIES",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID")}
    )
    private Collection<Authority> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return !isAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return !isEnabled();
    }

    //for tests only
    public User(long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
