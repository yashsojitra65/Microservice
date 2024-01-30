package com.RatingServices.Controller;


import com.RatingServices.Entity.Rating;
import com.RatingServices.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("create")
    public ResponseEntity<Rating> create(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }
    @GetMapping("all")
    public ResponseEntity<List<Rating>> getAll() {
        return ResponseEntity.ok(ratingService.getRating());
    }

    @GetMapping("getUser/{userId}")
    public ResponseEntity<List<Rating>> getRatingUserId(@PathVariable String userId) {
        return ResponseEntity.ok(ratingService.getRatingUserId(userId));
    }
    @GetMapping("getHotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }
}
