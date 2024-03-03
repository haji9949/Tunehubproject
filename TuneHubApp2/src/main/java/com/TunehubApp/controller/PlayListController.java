package com.TunehubApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.TunehubApp.entities.PlayList;
import com.TunehubApp.entities.Songs;
import com.TunehubApp.service.PlayListService;
import com.TunehubApp.service.SongsService;





@Controller
public class PlayListController {
	@Autowired
	PlayListService pserv;
	
	@Autowired
	SongsService sserv;
	@GetMapping("/createplaylist")
	public String createPlayList(Model model)
	{
		//Fetching the songs using song Service 
		List<Songs> songslist = sserv.fetchAllSongs();
		
		//Adding the songs in the model
		model.addAttribute("songslist",songslist);
		
		//sending createplaylist
		return "createplaylist";
	}
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist)
	{
		//adding playlist
		pserv.addPlaylist(playlist);
		
		List<Songs> songslist = playlist.getSongs();
		for(Songs song : songslist)
		{
			song.getPlayList().add(playlist);
			sserv.updateSong(song);
		
	}
	return "playlistsuccess";
	}
	@GetMapping("/viewplaylist")
	public String viewPlaylist(Model model)
	{
		List<PlayList> plist = pserv.fetchPlaylists();
		System.out.println(plist);
		model.addAttribute("plist",plist);
		return "viewplaylist";
	}
}

