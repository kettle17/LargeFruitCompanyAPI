package org.example.largefruitcompanyapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {

    private final FruitRepository repository;

    FruitController(FruitRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/fruit")
    List<Fruit> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/fruit")
    Fruit newFruit(@RequestBody Fruit newFruit) {
        return repository.save(newFruit);
    }

    // Single item

    @GetMapping("/fruit/{id}")
    Fruit one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new FruitNotFoundException(id));
    }

    @PutMapping("/fruit/{id}")
    Fruit replaceEmployee(@RequestBody Fruit newFruit, @PathVariable Long id) {

        return repository.findById(id)
                .map(fruit -> {
                    fruit.setId(newFruit.getId());
                    fruit.setName(newFruit.getName());
                    fruit.setPrice(newFruit.getPrice());
                    return repository.save(fruit);
                })
                .orElseGet(() -> {
                    return repository.save(newFruit);
                });
    }

    @DeleteMapping("/fruit/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
