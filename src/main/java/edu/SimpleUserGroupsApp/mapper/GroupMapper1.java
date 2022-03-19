package edu.SimpleUserGroupsApp.mapper;

import edu.SimpleUserGroupsApp.model.Group;
import edu.SimpleUserGroupsApp.model.dto.GroupDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface GroupMapper1 {
    @Mappings({
            @Mapping(target = "groupId", source = "id"),
            @Mapping(target = "groupName", source = "name"),
            @Mapping(target = "groupDescription", source = "description")
    })
    GroupDto groupToGroupDTO(Group group);

    @Mappings({
            @Mapping(target = "id", source = "groupId"),
            @Mapping(target = "name", source = "groupName"),
            @Mapping(target = "description", source = "groupDescription")
    })
    Group groupDTOToGroup(GroupDto groupDto);
}
