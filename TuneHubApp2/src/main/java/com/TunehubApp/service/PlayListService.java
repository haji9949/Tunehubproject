package com.TunehubApp.service;

import java.util.List;

import com.TunehubApp.entities.PlayList;

public interface PlayListService{
	public void addPlaylist(PlayList playlist);

	public List<PlayList> fetchPlaylists();
}
