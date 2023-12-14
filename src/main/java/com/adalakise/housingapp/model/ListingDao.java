package com.adalakise.housingapp.model;

import com.adalakise.housingapp.demodata.EListing;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListingDao {

    @Id
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

    public ListingDao(EListing eListing) {
        this.id = Long.valueOf(eListing.getId());
        this.title = eListing.getTitle();
        this.description = eListing.getDescription();
        this.price = eListing.getPrice();
        this.sqFt = eListing.getSqFt();
        this.area = eListing.getArea();
        this.photoLink = eListing.getPhotoLink();
        this.bedrooms = eListing.getBedrooms();
        this.latitude = eListing.getLatitude();
        this.longitude = eListing.getLongitude();
    }

    public ListingDto toDto() {
        return new ListingDto(this);
    }
}
