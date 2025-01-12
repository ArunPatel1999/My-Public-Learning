package com.arun.service;

import org.junit.jupiter.api.Test;

import com.arun.entitys.BookAndReview;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class BookAndReviewServiceTest {

	private BookeInfoService bookeInfoService = new BookeInfoService();
	private ReviewService reviewService = new ReviewService();
	private BookAndReviewService bookAndReviewService = new BookAndReviewService(bookeInfoService, reviewService);
	
	@Test
	void getAll() {
		Flux<BookAndReview> data = 	bookAndReviewService.getAllMovieAndReview().map(x -> {
				System.out.println("data => "+ x);
				return  x;
		});
		StepVerifier.create(data).expectNextCount(5).verifyComplete();
	}

	@Test
	void getById() throws Exception {
		Mono<BookAndReview> data = bookAndReviewService.getById(1).map(x -> {
			System.out.println("data =>"+x);
			return x;
		});

		StepVerifier.create(data).expectNextCount(1).verifyComplete();
	}

}
