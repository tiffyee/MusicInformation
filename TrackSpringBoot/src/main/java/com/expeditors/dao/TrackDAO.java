package com.expeditors.dao;

import com.expeditors.domain.Track;

import java.util.List;

public interface TrackDAO {

    Track insert(Track newTrack);

    boolean delete(int id);

    boolean update(Track track);

    Track findById(int id);

    List<Track> findAll();




}
