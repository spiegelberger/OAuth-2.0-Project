package com.spiegelberger.webclient.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spiegelberger.webclient.response.AlbumRest;


@Controller
public class AlbumsController {

	
	@GetMapping("/albums")
	public String getAlbums(Model model, @AuthenticationPrincipal OidcUser principal) {
		
		// Principal Informations
//		System.out.println("Principal: " + principal);
//		OidcIdToken idToken = principal.getIdToken();
//		String idTokenValue = idToken.getTokenValue();
//		System.out.println("idTokenValue: " + idTokenValue);
		
		AlbumRest album = new AlbumRest();
		album.setAlbumId("albumOne");
		album.setAlbumTitle("Album one title");
		album.setAlbumUrl("http://localhost:8082/albums/1");
		
		AlbumRest album2 = new AlbumRest();
		album2.setAlbumId("albumTwo");
		album2.setAlbumTitle("Album two title");
		album2.setAlbumUrl("http://localhost:8082/albums/2");
		
		List<AlbumRest>returnValue = Arrays.asList(album, album2);
		
		model.addAttribute("albums", returnValue);
		
		return "albums";
	}
}
