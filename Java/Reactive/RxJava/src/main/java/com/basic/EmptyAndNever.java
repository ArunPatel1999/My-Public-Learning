package com.basic;

import io.reactivex.Observable;

public class EmptyAndNever {
	public static void main(String[] args) throws InterruptedException {
		empty();
		never();
	}
	
	private static void empty() {
		 System.out.println("====empty=====");
	     Observable<Integer> data =	Observable.empty();
	     data.subscribe(System.out::println, System.out::println, ()-> System.out.println("Complete"));
	}
	
	private static void never() throws InterruptedException {
		System.out.println("====never=====");
		Observable<Integer> data =	Observable.never();
		data.subscribe(System.out::println, System.out::println, ()-> System.out.println("Complete"));
		Thread.sleep(1000);
	}
}
