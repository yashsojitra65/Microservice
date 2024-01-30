package com.RatingServices.Services.impl;


import com.RatingServices.Entity.Rating;
import com.RatingServices.Repo.RatingRepo;
import com.RatingServices.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepo ratingRepo;
    @Override
    public Rating create(Rating rating) {
        String Id = UUID.randomUUID().toString();
        rating.setRatingId(Id);
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRating() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}
