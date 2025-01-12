package com.basic.oprater;

import java.util.Comparator;

import io.reactivex.Observable;

public class Sorted_Contains {

	public static void main(String[] args) {
		sorted();
		sortedWithMethod();
		sortedComprater();
		contains();
	}
	
	public static void sorted() {
		System.out.println("========sorted===");
		Observable.just(54,1,60,75,30).sorted().subscribe(System.out::println);
	}
	
	public static void sortedWithMethod() {
		System.out.println("========sortedWithMethod===");
		Observable.just(54,1,60,75,30).sorted(Comparator.reverseOrder()).subscribe(System.out::println);
	}

	public static void sortedComprater() {
		System.out.println("========sortedComprater===");
		Observable.just("foo", "fool", "super", "foss", "foil").sorted((first, second)-> Integer.compare(first.length(), second.length())).subscribe(System.out::println);
	}
	
	public static void contains() {
		System.out.println("========contains===");
		Observable.just("foo", "fool", "super", "foss", "foil").contains("foo").subscribe(System.out::println);
	}
	
	

	
}
