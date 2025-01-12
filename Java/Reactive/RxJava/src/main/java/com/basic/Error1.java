package com.basic;

import io.reactivex.Observable;

public class Error1 {

	public static void main(String[] args) {
	
		throwException();
		throwCallBackException();
		
		
	}
	
	private static void throwException() {
		 System.out.println("====Throw without Call Back=====");
	     Observable<Integer> data =	Observable.error(new Exception("data"));
	     data.subscribe(System.out::println, error -> System.out.println("error hashCode 1 =>"+error.hashCode()));
	     data.subscribe(System.out::println, error -> System.out.println("error hashCode 2 =>"+error.hashCode()));
	}
	
	private static void throwCallBackException() {
		 System.out.println("====Throw With Call Back=====");
		 Observable<Integer> data =	Observable.error(() -> {
			 System.out.println("Error New Object Created");
			 return new Exception("data");});
		 data.subscribe(System.out::println, error -> System.out.println("error hashCode 1 =>"+error.hashCode()));
		 data.subscribe(System.out::println, error -> System.out.println("error hashCode 2 =>"+error.hashCode()));
	}
	
}
