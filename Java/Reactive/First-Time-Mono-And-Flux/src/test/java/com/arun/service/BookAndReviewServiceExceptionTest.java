package com.arun.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.arun.entitys.BookAndReview;
import com.arun.exception.BookException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.test.StepVerifier;
import reactor.tools.agent.ReactorDebugAgent;

@ExtendWith(MockitoExtension.class)
class BookAndReviewServiceExceptionTest {

	@Mock private BookeInfoService bookeInfoService;
	@Mock private ReviewService reviewService;
	@InjectMocks private BookAndReviewService bookAndReviewService;
	
	
	@Test
	void getAllBookAndThereReviewWithoutError() {
		Mockito.when(bookeInfoService.getData()).thenCallRealMethod();
		Mockito.when(bookeInfoService.getAll()).thenCallRealMethod();
		Mockito.when(reviewService.getAll()).thenCallRealMethod();
		Mockito.when(reviewService.getByMovieId(Mockito.anyInt())).thenCallRealMethod();
	
		Flux<BookAndReview> data = bookAndReviewService.getAllMovieAndReview().log();
		StepVerifier.create(data).expectNextCount(5).verifyComplete();
		
		
	}

	
	@Test
	void getAllBookAndThereReviewError() {
		//Hooks.onOperatorDebug(); // Not Recomandet but give good idea where error occured
		ReactorDebugAgent.init(); //for only one class ethwer add main class
		ReactorDebugAgent.processExistingClasses();

		Mockito.when(bookeInfoService.getData()).thenCallRealMethod();
		Mockito.when(bookeInfoService.getAll()).thenCallRealMethod();
		Mockito.when(reviewService.getAll()).thenCallRealMethod();
		Mockito.when(reviewService.getByMovieId(Mockito.anyInt())).thenThrow(new IllegalStateException("My throw"));
	
		Flux<BookAndReview> data = bookAndReviewService.getAllMovieAndReview().log();
		
		StepVerifier.create(data).expectError(BookException.class).verify();
	}


	@Test
	void getAllBookAndThereReviewErrorAndRetryWhen() {
		Mockito.when(bookeInfoService.getData()).thenCallRealMethod();
		Mockito.when(bookeInfoService.getAll()).thenCallRealMethod();
		Mockito.when(reviewService.getAll()).thenCallRealMethod();
		Mockito.when(reviewService.getByMovieId(Mockito.anyInt())).thenThrow(new IllegalStateException("My throw"));

		Flux<BookAndReview> data = bookAndReviewService.getAllMovieAndReviewRetryWhene().log();

		StepVerifier.create(data).expectError(BookException.class).verify();
	}


}
