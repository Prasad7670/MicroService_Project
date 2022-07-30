package com.neoquant.valid.repository;

import com.neoquant.valid.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public abstract User findUserById(int id);
}
