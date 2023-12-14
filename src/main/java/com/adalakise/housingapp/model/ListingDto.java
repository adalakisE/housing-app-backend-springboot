package com.adalakise.housingapp.model;

import com.adalakise.housingapp.demodata.EListing;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListingDto {

    private Long id;
    private String title;
    private String description;
    private Number price;
    private Number sqFt;
    private String area;
    private String photoLink;
    private Number bedrooms;
    private Number latitude;
    private Number longitude;

    public ListingDto(ListingDao listingDao) {
        this.id = listingDao.getId();
        this.title = listingDao.getTitle();
        this.description = listingDao.getDescription();
        this.price = listingDao.getPrice();
        this.sqFt = listingDao.getSqFt();
        this.area = listingDao.getArea();
        this.photoLink = listingDao.getPhotoLink();
        this.bedrooms = listingDao.getBedrooms();
        this.latitude = listingDao.getLatitude();
        this.longitude = listingDao.getLongitude();
    }
}
