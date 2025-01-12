package com.basic;

import io.reactivex.Observable;

public class Defer {
	public static int start = 5, count = 2; 
	public static void main(String[] args) {
		
		
		Observable<Integer> data = Observable.defer(()-> {
			System.out.println("new Object creatred start is: "+start+" count : "+count);
			return 	Observable.range(start, count);
		});
		
		System.out.println("====Noraml=====");
		 data.subscribe(System.out::println);
		count=4;
		 System.out.println("====After Incrseing count=====");
	     data.subscribe(System.out::println);
		
	}
}
