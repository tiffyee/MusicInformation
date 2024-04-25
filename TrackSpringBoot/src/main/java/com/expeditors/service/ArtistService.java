package com.expeditors.service;

import com.expeditors.dao.BaseDAO;
import com.expeditors.domain.Artist;
import com.expeditors.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    @Autowired
    private BaseDAO<Artist> artistDAO;

    public Artist addArtist(Artist artist) { return artistDAO.insert(artist); }

    public Artist getArtist(int id) { return artistDAO.findById(id); }

    public List<Artist> getALlArtist() { return artistDAO.findAll(); }

    public boolean deleteArtist(int id) { return artistDAO.delete(id); }

    public boolean updateArtist(Artist artist) { return artistDAO.update(artist); }

    public BaseDAO<Artist> getArtistDAO() { return artistDAO; }
    public void setArtistDAO(BaseDAO<Artist> artistDAO) { this.artistDAO = artistDAO; }

//    public List<Artist> findByExample(Map<String, Object> example) {
//        Artist track = new Artist();
//        Predicate<Track> predicate = null;
//        for(var entry : example.entrySet()) {
//            switch(entry.getKey()) {
//                case "mediaType" -> Artist.setMediaType((MediaType) entry.getValue());
//                case "dob" -> track.setDob((LocalDate)entry.getValue());
//                case "status" -> track.setStatus((Track.Status) entry.getValue());
//            };
//        }
//
//        List<Artist> result = trackDAO.findByExample(track);
//
//        return result;
//    }


}
