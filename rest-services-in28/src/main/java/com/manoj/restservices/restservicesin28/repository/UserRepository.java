package com.manoj.restservices.restservicesin28.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manoj.restservices.restservicesin28.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
