package edu.SimpleUserGroupsApp.model.dto;

import edu.SimpleUserGroupsApp.model.User;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GroupDto {
    public long groupId;
    public String groupName;
    public String groupDescription;
    public List<User> userList;
}
