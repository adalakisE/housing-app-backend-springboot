package com.example.housingappbackendspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;
    public List<ListingModel> allMovies() {
        System.out.println(listingRepository.findAll().toString());
        return listingRepository.findAll();
    }

    public Optional<ListingModel> singleMovie(String imdbId) {
        return listingRepository.findMovieByImdbId(imdbId);
    }
}
