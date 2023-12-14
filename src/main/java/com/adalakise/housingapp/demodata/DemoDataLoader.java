package com.adalakise.housingapp.demodata;

import com.adalakise.housingapp.model.ListingDao;
import com.adalakise.housingapp.repository.ListingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DemoDataLoader {

    private final ListingRepository listingRepository;

    public void createDemoData() throws Exception {
        System.out.println("Start Demo Data Generation.");
        for(EListing eListing : EListing.values()) {
            listingRepository.save(new ListingDao(eListing));
        }
    }
}
