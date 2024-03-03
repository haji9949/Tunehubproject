package com.TunehubApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TunehubApp.entities.Users;


public interface UsersRepository extends JpaRepository<Users, Integer>{

	public Users findByEmail(String email);

}
