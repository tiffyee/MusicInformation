package com.expeditors.domain;

import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Artist {
    private int id;
    @NonNull
    private String name;
    List<Track> tracks = new ArrayList<>();

    public Artist(){}

    public Artist(String name){
        setName(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks.addAll(tracks);
    }

    public void addTrack(Track track){
        Objects.requireNonNull(track);
        this.tracks.add(track);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
