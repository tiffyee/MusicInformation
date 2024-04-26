package com.expeditors.dao.inmemory;

import com.expeditors.dao.BaseDAO;
import com.expeditors.domain.Track;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

@Repository
@Profile("inmemtrack")
public class InMemoryTrackDAO implements BaseDAO<Track> {

    private Map<Integer, Track> tracks = new ConcurrentHashMap<>();
    private AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public Track insert(Track newTrack){
        newTrack.setId(nextId.getAndIncrement());
        newTrack.setTitle(newTrack.getTitle());
//        newTrack.setAlbum(newTrack.getAlbum());
//        newTrack.setDuration(newTrack.getDuration());
//        newTrack.setMediaType(newTrack.getMediaType());
//        newTrack.setArtists(newTrack.getArtists());
        tracks.put(newTrack.getId(),newTrack);

        return newTrack;
    }
    @Override
    public boolean delete(int id) { return tracks.remove(id) != null; }

    @Override
    public boolean update(Track track) { return tracks.replace(track.getId(), track) != null; }

    @Override
    public Track findById(int id) { return tracks.get(id); }

    @Override
    public List<Track> findAll() { return new ArrayList<>(tracks.values()); }

//    public List<Track> findByExample(Track example){
//        Predicate<Track> predicate = null;
//        if(example.getMediaType() != null) {
//            Predicate<Track> pr = t -> t.getMediaType().equals(example.getMediaType());
//            predicate = predicate == null ? pr : predicate.or(pr);
//        }
////        if(example.getIssueDate() != null) {
////            Predicate<Track> pr = t -> t.getIssueDate().getYear().equals(example.getIssueDate().getYear());
////
////            predicate = predicate == null ? pr : predicate.or(pr);
////        }
//        if(example.getArtists() != null) {
//            Predicate<Track> pr = t -> t.getArtists().equals(example.getArtists());
//            predicate = predicate == null ? pr : predicate.or(pr);
//        }
//
//        predicate = predicate == null ? (t -> true) : predicate;
//
//        List<Track> result = findAll().stream().filter(predicate).toList();
//
//        return result;
//    }

}
