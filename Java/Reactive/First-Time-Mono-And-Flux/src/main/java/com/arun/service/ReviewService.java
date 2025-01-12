package com.arun.service;

import java.util.LinkedList;
import java.util.List;

import com.arun.entitys.Review;

import reactor.core.publisher.Flux;

public class ReviewService {

	
	public  List<Review> getAll() {
		List<Review> list = new LinkedList<>();
		list.add(new Review(1, "nice book", 1));
		list.add(new Review(2, "very good", 1));
		list.add(new Review(3, "vhv ", 2));
		list.add(new Review(4, "shjvof", 2));
		list.add(new Review(5, ".shvibevjnsbo", 2));
		list.add(new Review(6, "nice bvsdb book", 3));
		list.add(new Review(7, "nice kcghsv book", 4));
		return list;
	}
	
	public Flux<Review> getByMovieId(int bookId) {
		return Flux.fromIterable(getAll()).filter(x -> x.getBookId() == bookId);
	}
		
}
