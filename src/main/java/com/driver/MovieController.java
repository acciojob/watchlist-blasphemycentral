package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController
{
    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(Movie movie)
    {
        movieService.addMovie(movie);
        return new ResponseEntity<>("Movie added", HttpStatus.CREATED);
    }

    @PostMapping("/movis/add-director")
    public ResponseEntity<String> addDirector(Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity<>("Director added", HttpStatus.CREATED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director)
    {
        movieService.addMovieDirectorPair(movie, director);
        return new ResponseEntity<>("Pair added", HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name)
    {
        Movie m = movieService.getMovieByName(name);
        return new ResponseEntity<>(m, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name)
    {
        Director d = movieService.getDirectorByName(name);
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies()
    {
        List<Movie> m = movieService.findAllMovies();
        return new ResponseEntity<>(m, HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String name)
    {
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("Deleted", HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("Deleted All", HttpStatus.CREATED);
    }
}
