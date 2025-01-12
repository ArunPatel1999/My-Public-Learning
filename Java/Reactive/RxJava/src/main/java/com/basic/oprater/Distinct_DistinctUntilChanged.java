package com.basic.oprater;

import io.reactivex.Observable;

public class Distinct_DistinctUntilChanged {

	public static void main(String[] args) {
		distinct();
		distinctWitKeySelecter();
		
		distinctUntilChanged();
		distinctUntilChangedWitKeySelecter();
	}
	
	public static void distinct() {
		System.out.println("========DISTINCAT===");
		Observable.just(1,2,2,3,3,4,5,5).distinct().subscribe(System.out::println);
	}

	public static void distinctWitKeySelecter() {
		System.out.println("========distinctWitKeySelecter===");
		Observable.just("foo", "fool", "super", "foss", "foil").distinct(x -> x.length()).subscribe(System.out::println);
	}
	
	//==================================
	
	public static void distinctUntilChanged() {
		System.out.println("========distinctUntilChanged===");
		Observable.just(1,1,2,2,3,3,4,5,1,2).distinctUntilChanged().subscribe(System.out::println);
	}

	public static void distinctUntilChangedWitKeySelecter() {
		System.out.println("========distinct Until Changed Wit Key Selecter===");
		Observable.just("foo", "fool", "super", "foss", "foil").distinctUntilChanged(String::length).subscribe(System.out::println);
	}
}
