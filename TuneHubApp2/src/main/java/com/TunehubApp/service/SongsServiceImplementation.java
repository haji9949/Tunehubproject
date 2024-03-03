package com.TunehubApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TunehubApp.entities.Songs;
import com.TunehubApp.repositories.SongsRepository;

@Service
public class SongsServiceImplementation  implements SongsService{
	@Autowired
	SongsRepository srepo;
	
	public String addSongs(Songs song) {
		srepo.save(song);
		return "Song is added";
		
	}

	
	public boolean songExists(String name) {
		Songs song=srepo.findByName(name);
		if(song==null) {
			return false;
		}
		else {
		return true;
		}
		
	}

	public List<Songs> fetchAllSongs() {
		
		List<Songs> songslist=srepo.findAll();
		
	 return songslist;
	}


	@Override
	public void updateSong(Songs song) {
		srepo.save(song);
		// TODO Auto-generated method stub
		
	}
}
