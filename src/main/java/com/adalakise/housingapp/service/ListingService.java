package com.adalakise.housingapp.service;

import com.adalakise.housingapp.model.ListingDao;
import com.adalakise.housingapp.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ListingService {

    private final ListingRepository listingRepository;

    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public List<ListingDao> allListings() {
        return listingRepository.findAll();
    }

    public ListingDao getListingById(Integer id) {
        return listingRepository.findById(Long.valueOf(id)).orElse(null);
    }

}
