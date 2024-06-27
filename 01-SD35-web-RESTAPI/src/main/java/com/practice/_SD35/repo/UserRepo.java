package com.practice._SD35.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice._SD35.entities.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Long>{

}
