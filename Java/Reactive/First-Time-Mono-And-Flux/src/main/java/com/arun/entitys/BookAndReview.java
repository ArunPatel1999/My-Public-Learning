package com.arun.entitys;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAndReview {

	private BookInfo bookInfo;
	private List<Review> reviews;
	
}
