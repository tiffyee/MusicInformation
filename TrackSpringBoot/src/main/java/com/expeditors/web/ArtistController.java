package com.expeditors.web;

import com.expeditors.domain.Artist;
import com.expeditors.service.ArtistService;
import com.sun.source.tree.BreakTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public List<Artist> getAllArtists() {
        List<Artist> artists = artistService.getALlArtist();
        return artists;
    }
}
