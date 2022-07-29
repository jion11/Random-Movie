package com.Movie.Randomizer;

import Model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping
public class MovieRandomizerController {

    private final MovieRandomizerService movieRandomizerService;

    @Autowired
    public MovieRandomizerController(MovieRandomizerService movieRandomizerService) {
        this.movieRandomizerService = movieRandomizerService;
    }

    @GetMapping(path = "/movie/random")

    public Movie getRandomMovie() throws IOException{
        Movie movie = new Movie();
        movie.setName(movieRandomizerService.getRandomMovie());
        movie.setYearReleased(movieRandomizerService.getYear());
        movie.setDescription(movieRandomizerService.getDescription());
        movie.setUrl(movieRandomizerService.getUrl());
        return movie;
    }

   /* @GetMapping(path = "/movie/random")

    public String getRandomMovie() throws IOException {

        return movieRandomizerService.getRandomMovie() + "<br>"
                + movieRandomizerService.getDirector() + "<br>"
                + movieRandomizerService.getYear() + "<br>"
                + movieRandomizerService.getDescription() + "<br>"
                + movieRandomizerService.getUrl();

    }
*/
    @GetMapping("/movie")

    public ArrayList<String> getMovieList() {

        return movieRandomizerService.getMovies();
    }

    @GetMapping("/movie/watched")

    public ArrayList<String> getMovieWatchedList() {
        return movieRandomizerService.getMoviesWatched();
    }

    @GetMapping("/")

    public String helloWorld() {

        return "Want to watch a movie innit?";
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}