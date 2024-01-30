package com.UserServices;

import com.UserServices.Entity.Rating;
import com.UserServices.External.Services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserApplicationTests {

    @Test
    void contextLoads() {
    }

//    @Autowired
//    private RatingService ratingService;

//    @Test
//    void createRating() {
//        Rating rating = Rating.builder()
//                .rating(10)
//                .userId("")
//                .hotelId("")
//                .feedback("Nice Hotel")
//                .build();
//        Rating saveRating = ratingService.createRating(rating);
//
//        System.out.println("New rating created");
//    }
}
