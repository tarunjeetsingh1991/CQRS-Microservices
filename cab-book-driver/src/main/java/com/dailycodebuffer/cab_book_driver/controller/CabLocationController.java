package com.dailycodebuffer.cab_book_driver.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.cab_book_driver.service.CabLocationService;

@RestController
@RequestMapping("/location")
public class CabLocationController 
{
	@Autowired
    private CabLocationService cabLocationService;
		/*
	 	@SuppressWarnings("rawtypes")
		@PutMapping
	    public ResponseEntity updateLocation() throws InterruptedException {

	        int range = 100;
	        while (range > 0) {
	            cabLocationService.updateLocation(Math.random() + " , " + Math.random());
	            Thread.sleep(1000);
	            range --;
	        }

	        return new ResponseEntity<>(Map.of("message", "Location Updated")
	        , HttpStatus.OK);
	    }
	    */
	 	
	 	@SuppressWarnings("rawtypes")
		@PutMapping
	    public ResponseEntity updateLocation() throws InterruptedException {

	        int range = 1000000;
	        while (range > 0) 
	        {
	        	Random rand = new Random();
	            int n1 = rand.nextInt();
	            int n2 = rand.nextInt();
	            cabLocationService.updateLocation(n1 + " , " + n2);
	            //Thread.sleep(1000);
	            range --;
	        }

	        return new ResponseEntity<>(Map.of("message", "Location Updated")
	        , HttpStatus.OK);
	    }
}
