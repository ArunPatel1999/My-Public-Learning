package com.basic.oprater;

import io.reactivex.Observable;

public class Repeat_And_Scan {
	public static void main(String[] args) {
		repeat();
		scan();
		scanWithIntialValue();
	}
	
	public static void repeat() {
		System.out.println("========repeat===");
		Observable.just(1,2,3).repeat(3).subscribe(System.out::println);
	}
	
	public static void scan() {
		System.out.println("========scan===");
		Observable.just(1,2,3,4).scan((accumater, next) -> accumater+next).subscribe(System.out::println);
	}
	
	public static void scanWithIntialValue() {
		System.out.println("========scanWithIntialValue===");
		Observable.just(1,2,3,4).scan(10 ,(accumater, next) -> accumater+next).subscribe(System.out::println);
	}
	
}
