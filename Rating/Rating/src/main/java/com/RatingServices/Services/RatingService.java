package com.RatingServices.Services;


import com.RatingServices.Entity.Rating;

import java.util.*;

public interface RatingService {
    Rating create(Rating rating);

    List<Rating> getRating();

    List<Rating> getRatingUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
