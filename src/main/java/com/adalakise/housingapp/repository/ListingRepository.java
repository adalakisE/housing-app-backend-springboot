package com.adalakise.housingapp.repository;

import com.adalakise.housingapp.model.ListingDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends JpaRepository<ListingDao, Long> {

}
