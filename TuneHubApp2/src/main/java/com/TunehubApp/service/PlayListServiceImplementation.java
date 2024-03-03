package com.TunehubApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TunehubApp.entities.PlayList;
import com.TunehubApp.repositories.PlayListRepository;

@Service
public class PlayListServiceImplementation implements PlayListService {
	@Autowired
	PlayListRepository prepo;

	public void addPlaylist(PlayList playlist) {
		prepo.save(playlist);
	}

	@Override
	public List<PlayList> fetchPlaylists() {
		return prepo.findAll();
	}

}
