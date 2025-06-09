package com.movietracker.controller;

import com.movietracker.model.Movie;
import com.movietracker.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/movies")
public class MovieController {
    
    @Autowired
    private MovieService movieService;
      @GetMapping("/add")
    public String showAddMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "add-movie";
    }
    
    @PostMapping("/add")
    public String addMovie(@Valid @ModelAttribute Movie movie, 
                          BindingResult result, 
                          RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "add-movie";
        }
        movieService.saveMovie(movie);
        redirectAttributes.addFlashAttribute("message", "Movie added successfully!");
        return "redirect:/movies/list";
    }
    
    @GetMapping("/list")
    public String listMovies(Model model) {
        model.addAttribute("wantToWatchMovies", movieService.getWantToWatchMovies());
        model.addAttribute("watchedMovies", movieService.getWatchedMovies());
        return "list-movies";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovie(id);
        model.addAttribute("movie", movie);
        return "add-movie";
    }
    
    @PostMapping("/edit/{id}")
    public String updateMovie(@PathVariable Long id, 
                            @Valid @ModelAttribute Movie movie, 
                            BindingResult result,
                            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "add-movie";
        }
        movie.setId(id);
        movieService.saveMovie(movie);
        redirectAttributes.addFlashAttribute("message", "Movie updated successfully!");
        return "redirect:/movies/list";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        movieService.deleteMovie(id);
        redirectAttributes.addFlashAttribute("message", "Movie deleted successfully!");
        return "redirect:/movies/list";
    }
}
