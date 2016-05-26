package org.ucll.rest.controller;

import domain.Movie;
import domain.facade.VideoBeheer;
import domain.factory.DatabaseType;
import helperclasses.MovieEvaluation;
import helperclasses.MovieGenre;
import helperclasses.MovieRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by filip on 5/16/2016.
 */
@RestController
public class VideoRestController {

    //@Autowired
    //VideoBeheer vdb;

    @Autowired
    private VideoBeheer vdb;

    //VideoBeheer vdb = new VideoBeheer(DatabaseType.RELATIONAL);
    @CrossOrigin
    @RequestMapping(value = "/addMovie",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMovie(@RequestBody Movie movie) {
        vdb.addMovie(movie);
    }

    /*
    voorbeeld dat werkt in postman:
bij de url vul je in: http://localhost:8080/video-rest/addMovie
dan neem je "body" en "raw" en in dropdown-veld===>aplication/json aanklikken
en dan plak je de tekst hieronder en druk je op send

//meer uitleg: http://websystique.com/springmvc/spring-mvc-4-restful-web-services-crud-example-resttemplate/

    {
    "title": "The Matrix",
    "director": "Joske vermeulen",
    "jaar": 2010,
    "genre": "ACTION",
    "rating": "NOTRATED",
    "evaluation": "ONESTAR",
    "seen": true,
    "actors": []
    }

     */

    @CrossOrigin
    @RequestMapping(value = "/movies",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Movie> movies() {

        Collection<Movie> moviedb = vdb.getAllMovies();

        //ArrayList<Movie> temp = new ArrayList<>(moviedb);

        //for(int i = 0; i < temp.size(); i++){
        //System.out.println(temp.get(i));
        //}


        /*
        Collection<Movie> moviedb = new ArrayList<Movie>();

        Movie movie1 = new Movie();
        movie1.setId(1);
        movie1.setTitle("The Lord of the Rings: The Fellowship of the Ring");
        movie1.setDirector("Peter Jackson");
        movie1.setJaar(2001);
        movie1.setGenre(MovieGenre.FANTASY);
        movie1.setRating(MovieRating.GENERALAUDIENCE);
        movie1.setEvaluation(MovieEvaluation.FIVESTARS);
        movie1.setSeen(true);

        moviedb.add(movie1);

/*
        movies.addAll(temp);
        System.out.println("");
*/
        return moviedb;
    }


    /*

    Dit is een werkend voorbeeld op url: http://localhost:8080/video-rest/updateMovie
     {
    "id": 1,
    "title": "Pirates of the caribbean test rest ahoi",
    "director": "Peter jackson",
    "jaar": 2010,
    "genre": "ACTION",
    "rating": "NOTRATED",
    "evaluation": "ONESTAR",
    "seen": true,
    "actors": []
  }
     */
    @CrossOrigin
    @RequestMapping(value = "/updateMovie",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateMovie(@RequestBody Movie movie) {
        //Movie
        vdb.updateMovie(movie);
    }



    /*
    Dit is een werkend voorbeeld dat wel al uitgevoerd is:

    http://localhost:8080/video-rest/deleteMovie/251

     */
    @CrossOrigin
    @RequestMapping(value = "/deleteMovie/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable("id") int id){

        vdb.deleteMovieById(id);

    }

/*
    // show updateForm of chosen Movie By Id
    @RequestMapping(path = "/update/{id}", value = "/update/{id}", method = RequestMethod.GET)
    public String updateMovie(@PathVariable("id") int id, Model model) {
        Movie movie = vdbDao.getMovieById(id);

        model.addAttribute("movie", movie);
        return "crud/movies/update";
    }

    // update the movie to the database
    @RequestMapping(value = "/updatemovie", method = RequestMethod.POST)
    public String updateMovieToDatabase(@ModelAttribute("movie") Movie movie, BindingResult result, ModelMap modelMap,
                                        Model model) {
        // vdb.updateMovie(movie, movie.getId());
        vdbDao.updateMovie(movie);
        return "redirect:/movies/showmovies.htm";
    }

    @RequestMapping(path = "/delete/{id}", value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteMovie(@PathVariable("id") int id, Model model) {
        vdbDao.deleteMovieById(id);
        return "redirect:/movies/showmovies.htm";
    }
*/

}
