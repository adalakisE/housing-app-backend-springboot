package com.example.housingappbackendspringboot;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ListingRepository extends MongoRepository<ListingModel, ObjectId> {
    Optional<ListingModel> findListingById(Integer ListingId);

    default List<ListingModel> findListingsByFilter(String reqTitle, int reqPrice, int reqSize, int reqBedrooms, MongoTemplate mongoTemplate) {
        Criteria criteria = new Criteria();
        System.out.println("Executing repository");


        if (reqPrice > 0) {
            criteria.and("price").gt(reqPrice);
        }

        if (reqSize > 0) {
            criteria.and("sqFt").gt(reqSize*10.764);
        }

        if (reqBedrooms > 0) {
            criteria.and("bedrooms").gt(reqBedrooms);
        }

        if (reqTitle != null && !reqTitle.isEmpty()) {
            Criteria orCriteria = new Criteria().orOperator(
                    Criteria.where("title").regex(".*" + reqTitle + ".*", "i"), // "i" for case-insensitive
                    Criteria.where("area").regex(".*" + reqTitle + ".*", "i"),
                    Criteria.where("description").regex(".*" + reqTitle + ".*", "i")
            );
            criteria.orOperator(orCriteria);
        }

        Query query = new Query(criteria);
        System.out.println(query);
        List<ListingModel> result = mongoTemplate.find(query, ListingModel.class);

        System.out.println("Result: " + result);
         return result;
    }
}
