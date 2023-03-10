package com.example.movieplan.repository;

import com.example.movieplan.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Integer> {
    Role searchRoleById(int id);
}
