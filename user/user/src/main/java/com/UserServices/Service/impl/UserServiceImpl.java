package com.UserServices.Service.impl;


import com.UserServices.Entity.Hotel;
import com.UserServices.Entity.Rating;
import com.UserServices.Entity.User;
import com.UserServices.Exceptions.ResourceNotFoundException;
import com.UserServices.External.Services.HotelService;
import com.UserServices.Repo.UserRepo;
import com.UserServices.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
        Rating[] ratingsList = restTemplate.getForObject("http://RATING-SERVICE/rating/getUser/" + user.getUserId(), Rating[].class);
        logger.info("{} ", ratingsList);

        List<Rating> ratingList = Arrays.stream(ratingsList).toList();

        List<Rating> list = ratingList.stream().map(rating -> {

//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/signal/" + rating.getHotelId(), Hotel.class);
//            Hotel hotel = forEntity.getBody();

            Hotel hotel = hotelService.getHotel(rating.getHotelId());
//            logger.info("Response status code: {} ", forEntity.getStatusCode());
            rating.setHotel(hotel);

            return rating;
        }).collect(Collectors.toList());

        user.setRatings(list);
        return user;
    }
}
