package com.dh.apiseries;

import com.dh.apiseries.model.ChapterEntity;
import com.dh.apiseries.model.SeasonEntity;
import com.dh.apiseries.model.SerieEntity;
import com.dh.apiseries.repository.SerieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;

@SpringBootApplication
@EnableDiscoveryClient
@EnableMongoRepositories
public class ApiSeriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSeriesApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(SerieRepository repository) {
		return (args) -> {
			if (!repository.findAll().isEmpty()) {
				return;
			}
			ChapterEntity chapter1 = new ChapterEntity(1L, "Episode 1", 1, "www.Netflix.com");
			ChapterEntity chapter2 = new ChapterEntity(2L, "Episode 2", 2, "www.Netflix.com");
			ChapterEntity chapter3 = new ChapterEntity(3L, "Episode 3", 3, "www.Netflix.com");
			ArrayList<ChapterEntity> capitulosLista1 = new ArrayList<>();
			capitulosLista1.add(chapter1);
			capitulosLista1.add(chapter2);
			capitulosLista1.add(chapter3);
			SeasonEntity season1 = new SeasonEntity(1L, 1, capitulosLista1);
			SeasonEntity season2 = new SeasonEntity(2L, 2, capitulosLista1);
			ArrayList<SeasonEntity> seasonLista1 = new ArrayList<>();
			seasonLista1.add(season1);
			seasonLista1.add(season2);

			SerieEntity serie1 = new SerieEntity(1L, "American Horror Story", "Terror", seasonLista1);
			SerieEntity serie2 = new SerieEntity(2L, "The Outsider", "Terror", seasonLista1);
			SerieEntity serie3 = new SerieEntity(3L, "Sons of Anarchy", "Thriller e intriga", seasonLista1);
			SerieEntity serie4 = new SerieEntity(4L, "Black Mirror", "Thriller e intriga", seasonLista1);
			SerieEntity serie5 = new SerieEntity(5L, "Orphan Black", "Ciencia ficción", seasonLista1);
			SerieEntity serie6 = new SerieEntity(6L, "Stranger Things", "Ciencia ficción", seasonLista1);
			SerieEntity serie7 = new SerieEntity(7L, "The Big Bang Theory", "Comedia", seasonLista1);

			repository.save(serie1);
			repository.save(serie2);
			repository.save(serie3);
			repository.save(serie4);
			repository.save(serie5);
			repository.save(serie6);
			repository.save(serie7);
		};
	}
}
