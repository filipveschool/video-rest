package org.ucll.rest.controller;

import domain.Movie;
import domain.facade.VideoBeheer;
import domain.factory.DatabaseType;
import helperclasses.MovieEvaluation;
import helperclasses.MovieGenre;
import helperclasses.MovieRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by filip on 5/16/2016.
 */
@RestController
public class VideoRestController {

    //@Autowired
    //VideoBeheer vdb;

    VideoBeheer vdb = new VideoBeheer(DatabaseType.RELATIONAL);

    @RequestMapping(value = "/addMovie",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMovie(@RequestBody Movie movie) {
        vdb.addMovie(movie);
    }

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
        Collection<Movie> movies = new ArrayList<Movie>();

        Movie movie1 = new Movie();
        movie1.setId(1);
        movie1.setTitle("The Lord of the Rings: The Fellowship of the Ring");
        movie1.setDirector("Peter Jackson");
        movie1.setJaar(2001);
        movie1.setGenre(MovieGenre.FANTASY);
        movie1.setRating(MovieRating.GENERALAUDIENCE);
        movie1.setEvaluation(MovieEvaluation.FIVESTARS);
        movie1.setSeen(true);

        movies.add(movie1);
        */
/*
        movies.addAll(temp);
        System.out.println("");
*/
        return moviedb;
    }

}
