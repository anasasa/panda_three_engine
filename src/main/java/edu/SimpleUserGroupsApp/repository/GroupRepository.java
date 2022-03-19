package edu.SimpleUserGroupsApp.repository;

import edu.SimpleUserGroupsApp.model.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group, Long> {
    List<Group> findAll();
}
