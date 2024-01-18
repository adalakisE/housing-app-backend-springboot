package com.example.housingappbackendspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class ListingController {
    @Autowired
    private ListingService service;
    @RequestMapping("/feed/item")
    @GetMapping
    public ResponseEntity<Optional<ListingModel>> getSingleMovie(@RequestParam Integer id) {
        return new ResponseEntity<>(service.singleListing(id), HttpStatus.OK);
    }

    @RequestMapping("/feed/items")
//    @GetMapping
//    public ResponseEntity<List<ListingModel>> getAllListings() {
//        return new ResponseEntity<>(service.allListings(), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<ListingModel>> getFilteredListings(
            @RequestParam(required = false) String title,
            @RequestParam(required = false, defaultValue = "0") int price,
            @RequestParam(required = false, defaultValue = "0") int size,
            @RequestParam(required = false, defaultValue = "0") int bedrooms) {

        List<ListingModel> filteredListings = service.filterListings(title, price, size, bedrooms);
        return new ResponseEntity<>(filteredListings, HttpStatus.OK);
    }
}
