package com.basic.oprater;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Take_TakeWhile_Skip_SkipWhile {

	public static void main(String[] args) {
		take();
		takeWithIntervale();
		takeWhile();
		
		skip();
		skipWithIntervale();
		skipWhile();
		
		
	}
	
	public static void take() {
		System.out.println("======Take=============");
		Observable.just(1,2,3,4,5)
			.take(2)
			.subscribe(System.out::println);
	}
	
	public static void takeWithIntervale() {
		System.out.println("======Take with intervale=============");
		Observable.interval(300, TimeUnit.MILLISECONDS)
		.take(2, TimeUnit.SECONDS)
		.subscribe(System.out::println, System.out::println,()-> System.out.println("complete"));
		
		takeWithIntervale(5000);
	}
	

	public static void takeWhile() {
		System.out.println("======Take While=============");
		Observable.just(1,2,3,4,5,6,7,8)
		.takeWhile(item -> item <= 3)
		.subscribe(System.out::println, System.out::println,()-> System.out.println("complete"));
	}
	
	
	//====================SKIP========================================================
	
	public static void skip() {
		System.out.println("======skip=============");
		Observable.just(1,2,3,4,5)
			.skip(2)
			.subscribe(System.out::println);
	}
	
	public static void skipWithIntervale() {
		System.out.println("======skip with intervale=============");
		Observable.interval(300, TimeUnit.MILLISECONDS)
		.skip(2, TimeUnit.SECONDS)
		.subscribe(System.out::println, System.out::println,()-> System.out.println("complete"));
		
		takeWithIntervale(5000);
	}
	

	public static void skipWhile() {
		System.out.println("======skip While=============");
		Observable.just(1,2,3,4,5,6,7,8)
		.skipWhile(item -> item <= 3)
		.subscribe(System.out::println, System.out::println,()-> System.out.println("complete"));
	}
	
	
	public static void takeWithIntervale(int duration) {
		try {
			Thread.sleep(duration);
		}catch (Exception e) { }
	}
	
	
}
