package com.expeditors.web;

import com.expeditors.domain.Track;
import com.expeditors.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @Autowired
    private UriCreator uriCreator;

    @GetMapping
    public List<Track> getAllTracks(){
        List<Track> track = trackService.getALlTracks();
        return track;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTrack(@PathVariable("id") int id){
        Track track = trackService.getTrack(id);
        if(track == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No track with id: " + id);
        }
        return ResponseEntity.ok(track);
    }

    @PostMapping
    public ResponseEntity<?> addTrack(@RequestBody Track track){
        Track newTrack = trackService.addTrack(track);

        URI newResource = uriCreator.getURI(newTrack.getId());

        return ResponseEntity.created(newResource).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") int id) {
        boolean result = trackService.deleteTrack(id);
        if(!result){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No track with id: " + id);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<?> updateTrack(@RequestBody Track track){
        boolean result = trackService.updateTrack(track);
        if(!result){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No track with id: " + track.getId());
        }
        return ResponseEntity.noContent().build();
    }

}
