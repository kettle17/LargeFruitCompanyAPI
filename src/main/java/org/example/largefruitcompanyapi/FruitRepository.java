package org.example.largefruitcompanyapi;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Flux;

public interface FruitRepository extends FirestoreReactiveRepository<Fruit> {
}
