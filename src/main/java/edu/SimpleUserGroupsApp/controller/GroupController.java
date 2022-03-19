package edu.SimpleUserGroupsApp.controller;

import edu.SimpleUserGroupsApp.mapper.GroupMapper;
import edu.SimpleUserGroupsApp.model.Group;
import edu.SimpleUserGroupsApp.model.dto.GroupDto;
import edu.SimpleUserGroupsApp.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/app/groups")
public class GroupController {
    private GroupService groupService;
    private GroupMapper groupMapper;

    @Autowired
    public GroupController(GroupService groupService, GroupMapper groupMapper) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveGroup(@RequestBody GroupDto groupDto) {
        groupService.saveGroup(groupMapper.mapDtoToGroup(groupDto));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<GroupDto> getAllGroups() {
        List<Group> groups = groupService.getAllGroups();
        return groups.stream()
                .map(group -> groupMapper.mapGroupToDto(group))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{groupId}")
    public GroupDto getGroupById(@PathVariable("groupId") long groupId) {
        return groupMapper.mapGroupToDto(groupService.getGroupById(groupId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{groupId}")
    public void deleteGroup(@PathVariable("groupId") long groupId) {
        groupService.deleteGroup(groupId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public GroupDto updateGroup(GroupDto groupDto) {
        return groupMapper.mapGroupToDto(groupService.saveGroup(groupMapper.mapDtoToGroup(groupDto)));
    }
}
