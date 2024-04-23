package com.expeditors.service;

import com.expeditors.dao.TrackDAO;
import com.expeditors.domain.Track;

import java.util.List;

public class TrackService {

    private TrackDAO trackDAO;

    public Track addTrack(Track track) { return trackDAO.insert(track); }

    public Track getTrack(int id) { return trackDAO.findById(id); }

    public List<Track> getALlTracks() { return trackDAO.findAll(); }

    public boolean deleteTrack(int id) { return trackDAO.delete(id); }

    public boolean updateTrack(Track track) { return trackDAO.update(track); }

    public void setTrackDAO(TrackDAO trackDAO) { this.trackDAO = trackDAO; }



}
