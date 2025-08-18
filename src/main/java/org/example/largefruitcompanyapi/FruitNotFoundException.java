package org.example.largefruitcompanyapi;

class FruitNotFoundException extends RuntimeException {

    FruitNotFoundException(Long id) {
        super("Could not find fruit " + id);
    }
}
