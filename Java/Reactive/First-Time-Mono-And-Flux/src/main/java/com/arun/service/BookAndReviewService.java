package com.arun.service;

import java.time.Duration;
import java.util.List;

import com.arun.entitys.BookAndReview;
import com.arun.entitys.BookInfo;
import com.arun.entitys.Review;
import com.arun.exception.BookException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

@AllArgsConstructor
@Slf4j
public class BookAndReviewService {

	private BookeInfoService bookeInfoService;
	private ReviewService reviewService;
	
	
	public Flux<BookAndReview> getAllMovieAndReview() {
		Flux<BookInfo> data = bookeInfoService.getAll();
		return data.checkpoint("First")
				.flatMap(x -> {
			Mono<List<Review>> reviews = reviewService.getByMovieId(x.getId()).collectList();
			return reviews.map(review -> new BookAndReview(x, review));
		}).checkpoint("Error check pont")
				.onErrorMap(error -> {
			log.error("Error in getBook and review =>" + error);
			return new BookException("error => " + error);
		}).retry(3);
	}


	public Flux<BookAndReview> getAllMovieAndReviewRetryWhene() {
		Retry retry = Retry.backoff(3, Duration.ofMillis(500))
				.filter(throwable -> throwable instanceof RuntimeException)
				.onRetryExhaustedThrow((retryBackoffSpec, retrySignal) -> Exceptions.propagate(retrySignal.failure()));

		return bookeInfoService.getAll().flatMap(x -> {
			Mono<List<Review>> reviews = reviewService.getByMovieId(x.getId()).collectList();
			return reviews.map(review -> new BookAndReview(x, review));
		}).onErrorMap(error -> {
			log.error("Error in getBook and review =>" + error);
			return new BookException("error => " + error);
		}).retryWhen(retry);
	}


	public Mono<BookAndReview> getById(int id) throws Exception {
		Mono<BookInfo> data = bookeInfoService.getById(id);
		return data.flatMap(x -> {
			Mono<List<Review>> reviews = reviewService.getByMovieId(x.getId()).collectList();
			return reviews.map(review -> new BookAndReview(x, review));
		});
	}
	
}
