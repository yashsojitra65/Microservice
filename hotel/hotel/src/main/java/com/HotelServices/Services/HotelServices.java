package com.HotelServices.Services;


import com.HotelServices.Entity.Hotel;
import java.util.*;

public interface HotelServices {
    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel get(String id);
}
