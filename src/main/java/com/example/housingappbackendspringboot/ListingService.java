package com.example.housingappbackendspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<ListingModel> allListings() {
        return listingRepository.findAll();
    }

    public Optional<ListingModel> singleListing(Integer Id) {
        return listingRepository.findListingById(Id);
    }

    public List<ListingModel> filterListings(String title, int price, int size, int bedrooms) {
        System.out.println("service");
        return listingRepository.findListingsByFilter(title, price, size, bedrooms, mongoTemplate);
    }
}
