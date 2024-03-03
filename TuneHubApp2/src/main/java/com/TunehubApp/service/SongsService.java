package com.TunehubApp.service;

import java.util.List;

import com.TunehubApp.entities.Songs;

public interface SongsService {
	public String addSongs(Songs song);
	public boolean songExists(String song);
	public List<Songs> fetchAllSongs();
	public void updateSong(Songs song);
}
