package com.expeditors.service;

import com.expeditors.dao.BaseDAO;
import com.expeditors.domain.Artist;
import com.expeditors.domain.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {

    @Autowired
    private BaseDAO<Track> trackDAO;

    public Track addTrack(Track track) { return trackDAO.insert(track); }

    public Track getTrack(int id) { return trackDAO.findById(id); }

    public List<Track> getALlTracks() { return trackDAO.findAll(); }

    public boolean deleteTrack(int id) { return trackDAO.delete(id); }

    public boolean updateTrack(Track track) { return trackDAO.update(track); }

    public BaseDAO<Track> getTrackDAO() { return trackDAO; }
    public void setTrackDAO(BaseDAO<Track> trackDAO) { this.trackDAO = trackDAO; }

//    public List<Track> findByExample(Map<String, Object> example) {
//        Track track = new Track();
//        Predicate<Track> predicate = null;
//        for(var entry : example.entrySet()) {
//            switch(entry.getKey()) {
//                case "mediaType" -> track.setMediaType((MediaType) entry.getValue());
//                case "dob" -> track.setDob((LocalDate)entry.getValue());
//                case "status" -> track.setStatus((Track.Status) entry.getValue());
//            };
//        }
//
//        List<Track> result = trackDAO.findByExample(track);
//
//        return result;
//    }

}
