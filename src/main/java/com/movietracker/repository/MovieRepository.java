package com.movietracker.repository;

import com.movietracker.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByDateWatchedIsNull();
    List<Movie> findByDateWatchedIsNotNull();
}
