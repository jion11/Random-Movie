package com.Movie.Randomizer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class MovieRandomizerService {
    String randMovie;

    public String getRandomMovie() {

        randMovie = MovieRandomizer.randomizeMovie();
        return randMovie;
    }

    public ArrayList<String> getMovies() {
        return MovieRandomizer.GetMovies();
    }

    public ArrayList<String> getMoviesWatched() { return MovieRandomizer.GetWatchedMovies(); }

    public String getDescription() throws IOException { return MovieRandomizer.GetDescription(randMovie);}

    public String getYear() {return "Year released: " + String.valueOf(MovieRandomizer.yearOfMovie());}

    public String getDirector() throws IOException { return "The Director is: " + MovieRandomizer.GetDirector(randMovie);}

    public String getUrl() {return "Letterboxd link: " + MovieRandomizer.urlMovie();}

}

