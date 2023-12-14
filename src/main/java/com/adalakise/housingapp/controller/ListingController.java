package com.adalakise.housingapp.controller;

import com.adalakise.housingapp.model.ListingDao;
import com.adalakise.housingapp.model.ListingDto;
import com.adalakise.housingapp.service.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("/feed/items")
public class ListingController {

    private final ListingService service;

    @GetMapping("/all")
    public ResponseEntity<List<ListingDto>> getAllListings(){
        return new ResponseEntity<>(service.allListings().stream().map(ListingDao::toDto).toList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListingDto> getSingleMovie(@PathVariable Integer id){
        return ResponseEntity.ok(service.getListingById(id).toDto());
    }
}
