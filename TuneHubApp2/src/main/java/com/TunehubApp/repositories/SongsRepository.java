package com.TunehubApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TunehubApp.entities.Songs;



public interface SongsRepository extends JpaRepository<Songs, Integer>{


	public Songs findByName(String name);


}
