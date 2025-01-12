package com.basic;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class HotAndCold1 {
	public static void main(String[] args) {
		cold();
		hotAndConnectable();
	}
	
	private static void cold() {
		 System.out.println("====COLD=====");
	     Observable<Integer> data =	Observable.just(1,2,3,4,5);
	     data.subscribe(x -> System.out.println("sub 1: => "+x));
	     data.subscribe(x -> System.out.println("sub 2: => "+x));
	}
	
	private static void hotAndConnectable() {
		System.out.println("====HOT=====");
		ConnectableObservable<Integer> data =	Observable.just(1,2,3,4,5).publish();
		data.subscribe(x -> System.out.println("sub 1: => "+x));
		data.subscribe(x -> System.out.println("sub 2: => "+x));
		data.connect();
	}
}
