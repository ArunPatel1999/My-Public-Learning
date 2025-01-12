package com.basic;

import io.reactivex.Observable;

public class FromCallable {
	public static void main(String[] args) {
	System.out.println("==========lazey loading==========");
		Observable<Integer> observable = Observable.fromCallable(() -> {
			System.out.println("Object Created");
			return getNumber()	;
		});
		System.out.println("==========data not loaded==========");	
		System.out.println("==========data loadeding start==========");
		observable.subscribe(System.out::println, error -> System.out.println("error =>"+error.toString()));
	}
	private static int getNumber() {
		System.out.println("new value genrated");
		return 1/0;
	}
}
