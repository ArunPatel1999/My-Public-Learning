package com.basic.error;

import io.reactivex.Observable;

public class OnError {
	public static void main(String[] args) {
		
		doOnError();
		onErrorResumeNext();
		onErrorReturn();
		onErrorReturnItem();
	}
	
	public static void doOnError() {
		System.out.println("======doOnError=============");
		Observable.error(new Exception("Just Error"))
			.doOnError(error ->System.out.println("Testy =>"+error))
			.subscribe(System.out::println, error ->System.out.println("Error =>"+error),()-> System.out.println("complete"));
	}

	public static void onErrorResumeNext() {
		System.out.println("======onErrorResumeNext=============");
		Observable.error(new Exception("Just Error"))
			.onErrorResumeNext(Observable.just(12,3,74,54,4,654))
			.subscribe(System.out::println, error ->System.out.println("Error =>"+error),()-> System.out.println("complete"));
	}

	public static void onErrorReturn() {
		System.out.println("======onErrorReturn=============");
		Observable.error(new IllegalAccessError("Just Error"))
		.onErrorReturn(error -> {
			if(error instanceof IllegalStateException ) return "Illegal error";
			else return "Error";
		})
		.subscribe(System.out::println, error ->System.out.println("Error =>"+error),()-> System.out.println("complete"));
	}
	
	public static void onErrorReturnItem() {
		System.out.println("======onErrorReturnItem=============");
		Observable.error(new IllegalAccessError("Just Error"))
		.onErrorReturnItem("return normal error")
		.subscribe(System.out::println, error ->System.out.println("Error =>"+error),()-> System.out.println("complete"));
	}
	
	
}
