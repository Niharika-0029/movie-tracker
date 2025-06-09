package com.movietracker.service;

import com.movietracker.model.Movie;
import com.movietracker.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;
    
    public List<Movie> getWantToWatchMovies() {
        return movieRepository.findByDateWatchedIsNull();
    }
    
    public List<Movie> getWatchedMovies() {
        return movieRepository.findByDateWatchedIsNotNull();
    }
    
    public Movie getMovie(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
    }
    
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
