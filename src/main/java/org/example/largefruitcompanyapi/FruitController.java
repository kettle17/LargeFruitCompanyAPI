package org.example.largefruitcompanyapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FruitController {

    @GetMapping("/fruit")
    public List<Fruit> getFruit() {
        return FruitRepository.findAll();
    }

    @GetMapping("/fruit/{id}")
    public Fruit getCustomerById(@PathVariable("id") int id) {
        return FruitRepository.findById(id);
    }

}
