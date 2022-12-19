package com.dh.apiseries.controller;


import com.dh.apiseries.model.SerieEntity;
import com.dh.apiseries.service.SerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/series")
public class SerieController {
    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/{genre}")
    ResponseEntity<List<SerieEntity>> getSeriesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(serieService.getByGenre(genre));
    }

    @PostMapping("/save")
    ResponseEntity<SerieEntity> saveSerie(@RequestBody SerieEntity serie) {
        return ResponseEntity.ok().body(serieService.save(serie));
    }
}
