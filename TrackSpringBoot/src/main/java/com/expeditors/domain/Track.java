package com.expeditors.domain;

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
    private List<Artist> artists;
}
