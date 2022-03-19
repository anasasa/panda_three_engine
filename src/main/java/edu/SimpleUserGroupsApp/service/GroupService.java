package edu.SimpleUserGroupsApp.service;

import edu.SimpleUserGroupsApp.repository.GroupRepository;
import edu.SimpleUserGroupsApp.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService  {
    private GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Cacheable(value = "groupCache", key = "#id")
    @PreAuthorize("hasAuthority('GROUP_READ') and hasAuthority('USER_READ')")
    public Group getGroupById(Long id) {
        return groupRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PreAuthorize("hasAuthority('GROUP_READ') and hasAuthority('USER_READ')")
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @PreAuthorize("hasAuthority('GROUP_CREATE') and hasAuthority('USER_UPDATE')")
    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }

    @PreAuthorize("hasAuthority('GROUP_DELETE')")
    public void deleteGroup(long id) {
        groupRepository.deleteById(id);
    }
}
