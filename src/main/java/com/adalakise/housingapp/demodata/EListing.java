package com.adalakise.housingapp.demodata;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EListing {

    LISTING_1(1, "Modern Apartment in Central Athens",
            "A stylish apartment with 2 bedrooms located in the vibrant area of Kolonaki in Central Athens.",
            1200,
            900,
            "Kolonaki",
            "data:image/webp;base64,UklGRj...",
            2,
            37.9838,
            23.7275),
    LISTING_2(
            2,
            "Cozy Studio near Acropolis",
            "A comfortable studio apartment with 1 bedroom, situated in the charming neighborhood of Plaka, within close proximity to the Acropolis.",
            800,
            600,
            "Plaka",
            "data:image/webp;base64,UklGRi...",
            1,
            37.9838,
            23.7275),
    ;

    private final Integer id;
    private final String title;
    private final String description;
    private final Integer price;
    private final Integer sqFt;
    private final String area;
    private final String photoLink;
    private final Integer bedrooms;
    private final Double latitude;
    private final Double longitude;

}


