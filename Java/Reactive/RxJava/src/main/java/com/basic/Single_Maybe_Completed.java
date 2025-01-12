package com.basic;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class Single_Maybe_Completed {
	public static void main(String[] args) {
		singel();
		maybe();
		completeable();
		
	}

	private static void singel() {
		Single.just("Only One data").subscribe(System.out::println);
	}

	private static void maybe() {
		Maybe.just(1).subscribe(System.out::println, error -> System.out.println("error data => "+error.getLocalizedMessage()), ()->System.out.println("Complated 1"));
		Maybe.empty().subscribe(System.out::println, error -> System.out.println("error data => "+error.getLocalizedMessage()), ()->System.out.println("Complated 2"));
	}

	private static void completeable() {
		Completable.fromSingle(Single.just("Only One data")).subscribe(() -> System.out.println("compatedbale complete"));
	}

}
