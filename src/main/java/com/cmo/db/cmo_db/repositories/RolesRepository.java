package com.cmo.db.cmo_db.repositories;

import com.cmo.db.cmo_db.entity.Roles;
import com.cmo.db.cmo_db.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RolesRepository extends CrudRepository<Roles, Long> {
    Roles findByRoleAndUser(String role, User user);
    List<Roles> findByUser(User user);
}