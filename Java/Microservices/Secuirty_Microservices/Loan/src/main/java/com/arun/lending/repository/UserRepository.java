package com.arun.lending.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arun.lending.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
