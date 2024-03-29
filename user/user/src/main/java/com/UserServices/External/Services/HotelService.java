package com.UserServices.External.Services;

import com.UserServices.Entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("/hotel/signal/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);


}
