package edu.SimpleUserGroupsApp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "GROUPS")
public class Group {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GROUP_ID")
    private long id;

    @NotNull
    @Column(name = "GROUP_NAME")
    private String name;

    @Column(name = "GROUP_DESCRIPTION")
    private String description;

    @ManyToMany(mappedBy = "groupList")
    List<User> userList;
//
//    //for tests only
//    public Group(String name, String description) {
//        this.name = name;
//        this.description = description;
//    }
}
