package com.lcwd.user.service.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating 
{
	String ratingId, userId, hotelId, feedback;
	int rating;
	
	
	Hotel hotel;
}
