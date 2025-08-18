package org.example.largefruitcompanyapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(FruitRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Fruit("Apple", 0.50)));
            log.info("Preloading " + repository.save(new Fruit("Orange", 0.90)));
            log.info("Preloading " + repository.save(new Fruit("Mango", 1.20)));
            log.info("Preloading " + repository.save(new Fruit("Cherry", 0.30)));
        };
    }
}