package com.expeditors.domain;

import javax.print.attribute.standard.Media;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class Track {
    private int id;
    private String title;
    private String album;
    private LocalDate issueDate;
    private Duration duration;
    private MediaType mediaType;
    List<Artist> artists;

    public Track(){}
    public Track(String title, String album, LocalDate issueDate, Duration duration, MediaType mediaType, List<Artist> artists){
        setTitle(title);
        setTitle(album);
        setIssueDate(issueDate);
        setDuration(duration);
        setMediaType(mediaType);
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
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

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
