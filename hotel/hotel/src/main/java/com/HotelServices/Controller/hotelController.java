package com.HotelServices.Controller;

import com.HotelServices.Entity.Hotel;
import com.HotelServices.Services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("hotel")
public class hotelController {
    @Autowired
    private HotelServices hotelServices;

    @PostMapping("create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelServices.create(hotel));
    }

    @GetMapping("signal/{hotelId}")
    public ResponseEntity<Hotel> signalHotel(@PathVariable String hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelServices.get(hotelId));
    }
    @GetMapping("all")
    public ResponseEntity<List<Hotel>> getHotel() {
        return ResponseEntity.ok(hotelServices.getAll());
    }
}
