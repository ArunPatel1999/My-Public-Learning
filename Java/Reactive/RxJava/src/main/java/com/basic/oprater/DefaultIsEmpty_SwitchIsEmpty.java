package com.basic.oprater;

import io.reactivex.Observable;

public class DefaultIsEmpty_SwitchIsEmpty {
	public static void main(String[] args) {
		defaultIsEmpty();
		switchIfEmpty();
	}
	
	public static void defaultIsEmpty() {
		System.out.println("========defaultIsEmpty===");
		Observable.just(1,2,2,3,3,4,5,5).filter(x -> x >10 ).defaultIfEmpty(100).subscribe(System.out::println);
	}

	public static void switchIfEmpty() {
		System.out.println("========switchIfEmpty===");
		Observable.just(1,2,2,3,3,4,5,5).filter(x -> x >10 ).switchIfEmpty(Observable.just(10,11,22)).subscribe(System.out::println);
	}
}
