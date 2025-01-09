package com.noticiero.demo.Repository;

import com.noticiero.demo.Models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {

    Users findByEmail(String email);
}
