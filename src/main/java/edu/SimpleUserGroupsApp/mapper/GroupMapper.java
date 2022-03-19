package edu.SimpleUserGroupsApp.mapper;

import edu.SimpleUserGroupsApp.model.Group;
import edu.SimpleUserGroupsApp.model.dto.GroupDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {

    public GroupDto mapGroupToDto(Group group) {
        return new GroupDto(
                group.getId(),
                group.getName(),
                group.getDescription(),
                group.getUserList()
        );
    }

    public Group mapDtoToGroup(GroupDto groupDto) {
        return new Group(
                groupDto.getGroupId(),
                groupDto.getGroupName(),
                groupDto.getGroupDescription(),
                groupDto.getUserList()
        );
    }

    public List<GroupDto> mapListToDto(List<Group> groups) {
        return groups.stream()
                .map(group -> mapGroupToDto(group))
                .collect(Collectors.toList());
    }
}
