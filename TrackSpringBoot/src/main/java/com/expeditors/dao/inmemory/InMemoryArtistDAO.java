package com.expeditors.dao.inmemory;


import com.expeditors.dao.BaseDAO;
import com.expeditors.domain.Artist;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

@Repository
@Profile("inmemartist")
public class InMemoryArtistDAO implements BaseDAO<Artist> {

    private Map<Integer, Artist> artists = new ConcurrentHashMap<>();
    private AtomicInteger nextId = new AtomicInteger(1);

    @Override
    public Artist insert(Artist newArtist) {
        newArtist.setId(nextId.getAndIncrement());
        newArtist.setName(newArtist.getName());
        artists.put(newArtist.getId(), newArtist);

        return newArtist;
    }

    @Override
    public boolean delete(int id) {
        return artists.remove(id) != null;
    }

    @Override
    public boolean update(Artist track) {
        return artists.replace(track.getId(), track) != null;
    }

    @Override
    public Artist findById(int id) {
        return artists.get(id);
    }

    @Override
    public List<Artist> findAll() {
        return new ArrayList<>(artists.values());
    }

//    public List<Artist> findByExample(Artist example){
//        Predicate<Artist> predicate = null;
//        if(example.getTracks() != null) {
//            Predicate<Artist> pr = t -> t.getTracks().equals(example.getTracks());
//            predicate = predicate == null ? pr : predicate.or(pr);
//        }
//
//        predicate = predicate == null ? (t -> true) : predicate;
//
//        List<Artist> result = findAll().stream().filter(predicate).toList();
//
//        return result;
//    }
}