package com.dh.catalog.service;

import com.dh.catalog.client.MovieServiceClient;
import com.dh.catalog.client.SerieServiceClient;
import com.dh.catalog.handler.Exception;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class CatalogService {

    private final MovieServiceClient movieServiceClient;

    private final SerieServiceClient serieServiceClient;

    public CatalogService(MovieServiceClient movieServiceClient, SerieServiceClient serieServiceClient) {
        this.movieServiceClient = movieServiceClient;
        this.serieServiceClient = serieServiceClient;
    }

    @CircuitBreaker(name = "clientMovie", fallbackMethod = "callMovieFallBack")
    @Retry(name = "clientMovie")
    public List<?> getMovieByGenre(String genre) {
        Exception error;
        List response =  movieServiceClient.getMovieByGenre(genre);
        if (response.isEmpty()) {
            error = new Exception("No se encuentran peliculas para ese genero", HttpStatus.NOT_FOUND, ZonedDateTime.now());
            response.add(error);
        }

        return response;
    }

    public List<?> callMovieFallBack(String genre, Throwable t) {
        Exception error;
        List response =  movieServiceClient.getMovieByGenre(genre);
        if (response.isEmpty()) {
            error = new Exception("No se encuentran peliculas para ese genero", HttpStatus.NOT_FOUND, ZonedDateTime.now());
            response.add(error);
        }

        return response;
    }

    @CircuitBreaker(name= "clientSerie", fallbackMethod = "callSerieFallBack")
    @Retry(name = "clientSerie")
    public List<?> getSerieByGenre(String genre) {
        Exception error;
        List response = serieServiceClient.getSerieByGenre(genre);
        if (response.isEmpty()) {
            error = new Exception("No se encuentran series para ese genero", HttpStatus.NOT_FOUND, ZonedDateTime.now());
            response.add(error);
        }
        return response;
    }
    public List<?> callSerieFallBack(String genre, Throwable t) {
        Exception error;
        List response = serieServiceClient.getSerieByGenre(genre);
        if (response.isEmpty()) {
            error = new Exception("No se encuentran series para ese genero", HttpStatus.NOT_FOUND, ZonedDateTime.now());
            response.add(error);
        }
        return response;
    }
}
