package com.lcwd.user.service.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.external.services.HotelService;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService
{
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	Logger logger =  LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	HotelService hotelService;
	 
	@Override
	public User saveuser(User user) 
	{
		//generate unique user ID
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return repo.save(user);
	}

	@Override
	public List<User> getAllUser() 
	{
		return repo.findAll();
	}

	/*
	@Override
	public User getUser(String userId) 
	{
		//get user from database
		User user =  repo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on server !! " + userId));
		
		// fetch rating of the above user using rating rating service
		// http://localhost:8083/ratings/users/04736cfe-27c5-46bf-bd27-dfb1413176c9
		
		ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/" + user.getUserId(), ArrayList.class);
		logger.info("{}",ratingsOfUser); 
		user.setRatings(ratingsOfUser);
		return user;
	}
	
	
	//get single user using restTemplate
    @Override
    public User getUser(String userId) 
    {
        //get user from database with the help  of user repository
        User user = repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
        
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + user.getUserId(), Rating[].class);
        logger.info("{}",ratingsOfUser); 
        
        List<Rating> ratings = Arrays.stream(ratingsOfUser).collect(Collectors.toList());
        
        
        List<Rating> ratingList = ratings.stream().map(rating -> {
        	//api call to hotel service to get the hotel
        	// http://localhost:8082/hotels/caedde5f-937f-415a-9bcd-db16a41ebb92
        	ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(),Hotel.class);
        	
        	Hotel hotel = forEntity.getBody();
        	logger.info("response status code: {} ",forEntity.getStatusCode());
        	
        	//set the hotel to rating
        	rating.setHotel(hotel);
        	
        	//return the rating
        	return rating;
        }).collect(Collectors.toList());
        
        user.setRatings(ratingList);
        
        return user ;
    }
    
    */
	
	//get single user using feignClient
    @Override
    public User getUser(String userId) 
    {
        //get user from database with the help  of user repository
        User user = repo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
        
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + user.getUserId(), Rating[].class);
        logger.info("{}",ratingsOfUser); 
        
        List<Rating> ratings = Arrays.stream(ratingsOfUser).collect(Collectors.toList());
        
        
        List<Rating> ratingList = ratings.stream().map(rating -> {
        	//api call to hotel service to get the hotel
        	// http://localhost:8082/hotels/caedde5f-937f-415a-9bcd-db16a41ebb92
        	
        	
        	Hotel hotel = hotelService.getHotel(rating.getHotelId());
        	
        	
        	//set the hotel to rating
        	rating.setHotel(hotel);
        	
        	//return the rating
        	return rating;
        }).collect(Collectors.toList());
        
        user.setRatings(ratingList);
        
        return user ;
    }

}
