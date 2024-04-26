package com.expeditors.domain;

import org.springframework.lang.NonNull;

import javax.print.attribute.standard.Media;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Track {
    private int id;
    @NonNull
    private String title;
    @NonNull
    private String album;
    @NonNull
    private LocalDate issueDate;
    @NonNull
    private Duration duration;
    @NonNull
    private MediaType mediaType;
    private List<Artist> artists = new ArrayList<>();
    private int price;

    public Track(){}
    public Track(String title, String album, LocalDate issueDate, Duration duration, MediaType mediaType,List<Artist> artists){
        setTitle(title);
        setAlbum(album);
        setIssueDate(issueDate);
        setDuration(duration);
        setMediaType(mediaType);
        setArtists(artists);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public List<Artist> getArtists() {
        return List.copyOf(artists);
    }

    public void setArtists(List<Artist> artists) {
        //this.artists.clear();
        this.artists.addAll(artists);
        //artists.forEach(this::addArtist);
    }

    public void addArtist(Artist artist){
        Objects.requireNonNull(artist);
        this.artists.add(artist);
    }
    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", issueDate=" + issueDate +
                ", duration=" + duration +
                ", mediaType=" + mediaType +
                ", artists=" + artists +
                '}';
    }



}
