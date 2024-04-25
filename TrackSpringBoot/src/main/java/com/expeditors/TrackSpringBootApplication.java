package com.expeditors;

import com.expeditors.domain.Artist;
import com.expeditors.domain.MediaType;
import com.expeditors.domain.Track;
import com.expeditors.service.ArtistService;
import com.expeditors.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TrackSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackSpringBootApplication.class, args);
    }

}

@Component
class MyRunner implements CommandLineRunner {

    @Autowired
    private TrackService trackService;

    @Autowired
    private ArtistService artistService;

    @Override
    public void run(String... args) throws Exception {

        var artists = List.of(
                new Artist("John Doe"),
                new Artist("Josh Groban"),
                new Artist("Sara Bareilles")
        );

        artists.forEach(artistService::addArtist);

//        Artist artist1 = new Artist("John Doe");
//        Artist artist2 = new Artist("Josh Groban");
//        Artist artist3 = new Artist("Sara Bareilles");
//
//        artistService.addArtist(artist1);
//        artistService.addArtist(artist2);
//        artistService.addArtist(artist3);

        List<Artist> artists1 = new ArrayList<>();
        artists1.add(artists.get(0));

        List<Artist> artists2 = new ArrayList<>();
        artists2.add(artists.get(1));

        List<Artist> artists3 = new ArrayList<>();
        artists3.add(artists.get(1));
        artists3.add(artists.get(2));



        var tracks = List.of(
                new Track("Song Title",
                "Album Name",
                LocalDate.parse("2002-02-17"),
              //  Duration.of(3, ChronoUnit.MINUTES),
                Duration.parse("PT3M18S"),
                MediaType.MP3,
                        artists1),

                new Track("February Song",
                "Awake",
                LocalDate.parse("2006-11-07"),
                Duration.parse("PT5M12S"),
                MediaType.MP3,
                        artists2),

                new Track("Both Sides Now",
                        "Harmony",
                        LocalDate.parse("2020-11-20"),
                        Duration.parse("PT4M3S"),
                        MediaType.MP3,
                        artists3)
        );

        tracks.forEach(trackService::addTrack);

        System.out.println("Track Count:" + tracks.size());
        tracks.forEach(System.out::println);

        //List<Track> filteredTracks = trackService.



    }

}