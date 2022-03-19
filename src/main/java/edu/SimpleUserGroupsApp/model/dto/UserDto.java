package edu.SimpleUserGroupsApp.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    public long userId;
    public String userName;
    public String userEmail;
}
