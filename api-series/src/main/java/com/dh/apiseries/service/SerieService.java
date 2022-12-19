package com.dh.apiseries.service;


import com.dh.apiseries.event.NewSerieEventProducer;
import com.dh.apiseries.model.SerieEntity;
import com.dh.apiseries.repository.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {
    private final SerieRepository serieRepository;
    private final NewSerieEventProducer newSerieEventProducer;


    public SerieService(SerieRepository serieRepository, NewSerieEventProducer newSerieEventProducer) {
        this.serieRepository = serieRepository;
        this.newSerieEventProducer = newSerieEventProducer;
    }

    public SerieEntity save(SerieEntity serie) {
        serieRepository.save(serie);
        newSerieEventProducer.execute(serie);
        return serie;
    }

    public List<SerieEntity> getByGenre(String genre) {
        List<SerieEntity> series = serieRepository.findByGenre(genre);
        return series;
    }
}
