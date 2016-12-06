package com.jeremy.jba4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeremy.jba4.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByName(String name);

}
