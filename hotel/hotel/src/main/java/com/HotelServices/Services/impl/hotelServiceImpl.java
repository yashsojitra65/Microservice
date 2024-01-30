package com.HotelServices.Services.impl;


import com.HotelServices.Entity.Hotel;
import com.HotelServices.Exception.ResourceNotFoundException;
import com.HotelServices.Repo.HotelRepo;
import com.HotelServices.Services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class hotelServiceImpl implements HotelServices {
    @Autowired
    private HotelRepo hotelRepo;
    @Override
    public Hotel create(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with given id is not found on server !! : "+id));
    }
}
