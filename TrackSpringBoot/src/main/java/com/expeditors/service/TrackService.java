package com.expeditors.service;

import com.expeditors.dao.BaseDAO;
import com.expeditors.domain.Artist;
import com.expeditors.domain.MediaType;
import com.expeditors.domain.Track;
import com.expeditors.pricing.PricingProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

@Service
public class TrackService {

    @Autowired
    private BaseDAO<Track> trackDAO;

    @Autowired
    private PricingProvider pricingProvider;



    public Track addTrack(Track track) { return trackDAO.insert(track); }

    public Track getTrack(int id) {
        Track track = trackDAO.findById(id);
        pricingProvider.addPriceToTrack(track);
        return track;
    }

    public List<Track> getALlTracks() {
        List<Track> tracks = trackDAO.findAll();
        tracks.forEach(pricingProvider::addPriceToTrack);
        return tracks;
    }

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

    public List<Track> getByQueryParams(Map<String, String> queryParams) {
        Predicate<Track> finalPred = null;

        for(var entry : queryParams.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();

            if(key.equals("year")) {
                var yearInt =  Integer.valueOf(value);
                Predicate<Track> tmp = (t) -> t.getIssueDate().getYear() == yearInt;

                finalPred = finalPred == null ? tmp : finalPred.or(tmp);
            }else if(key.equals("mediatype")) {
                var mediaEnum = MediaType.valueOf(value);
                Predicate<Track> tmp = (t) -> t.getMediaType().equals(mediaEnum);

                finalPred = finalPred == null ? tmp : finalPred.or(tmp);
            }else if(key.equals("artist")) {
                Predicate<Track> tmp = (t) -> t.getArtists().stream().anyMatch(a -> Objects.equals(a.getName(), value));
                finalPred = finalPred == null ? tmp : finalPred.or(tmp);
            }
        }

        finalPred = finalPred != null ? finalPred : (s) -> true;

        List<Track> result = getALlTracks().stream()
                .filter(finalPred)
                .toList();

        return result;
    }
}
