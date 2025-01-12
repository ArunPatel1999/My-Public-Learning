package com.arun.main;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

public class FirstMainClass {

	
	public Flux<String> fluxData() {
		return Flux.fromIterable(Arrays.asList("a", "b", "c", "d")).log();
	}

	public Flux<String> fluxMapData() {
		return Flux.fromIterable(Arrays.asList("a", "b", "c", "d"))
				.map(String::toUpperCase)
				.log();
	}

	public Flux<String> fluxFilterData(String data) {
		return Flux.fromIterable(Arrays.asList("a", "b", "c", "d"))
				.filter(x -> x.equals(data))
				.log();
	}
	
	public Flux<String> fluxFlatMapData() {
		return Flux.fromIterable(Arrays.asList("azsfdgh", "bfgdg", "chftgh", "dsddfsg"))
				.flatMap(x -> Flux.just(x.split("")))
				.log();
	}
	
	public Flux<String> fluxFlatMapDataASYC() {
		return Flux.fromIterable(Arrays.asList("azsfdgh", "bfgdg", "chftgh", "dsddfsg"))
				.flatMap(x -> Flux.just(x.split("")))
				.delayElements(Duration.ofMillis(new Random().nextInt(1000)))
				.log();
	}
	
	public ParallelFlux<String> fluxFlatMapDataASYCParallel() {
		System.out.println("core =>"+Runtime.getRuntime().availableProcessors());
		return Flux.fromIterable(Arrays.asList("azsfdgh", "bfgdg", "chftgh", "dsddfsg"))
				.parallel()
				.runOn(Schedulers.parallel())
				.flatMap(x -> getSplit(x))
				.log();
	}
	
	private Flux<String> getSplit(String x) {
		return 	Flux.just(x.split("")).delayElements(Duration.ofMillis(new Random().nextInt(1000)));
	}

	public Flux<String> fluxFlatMapDataASYCWithSchedulers() {
		return Flux.fromIterable(Arrays.asList("azsfdgh", "bfgdg", "chftgh", "dsddfsg"))
				.publishOn(Schedulers.boundedElastic())
				.flatMap(x -> Flux.just(x.split("")))
				.delayElements(Duration.ofMillis(new Random().nextInt(1000)))
				.subscribeOn(Schedulers.boundedElastic())
				.log();
	}
	
	// work on ordring
	public Flux<String> fluxConcatMapData() {
		return Flux.fromIterable(Arrays.asList("azsfdgh", "bfgdg", "chftgh", "dsddfsg"))
				.concatMap(x -> Flux.just(x.split("")))
				.delayElements(Duration.ofMillis(new Random().nextInt(1000)))
				.log();
	}
	
	public Flux<String> fruitFluxTransforma(int a) {
//		Function<Flux<String>, Flux<String>> filterdata = data -> data.filter(s -> s.length() > a);
		UnaryOperator<Flux<String>> filterdata = data -> data.filter(s -> s.length() > a);
		return Flux.fromIterable(Arrays.asList("Mongo", "Orange", "Banana")).transform(filterdata)
				.defaultIfEmpty("NO Data")
				.switchIfEmpty(Flux.just("DATAA", "lsfiuuio")).transform(filterdata)
				.log(); 

	}
	
	public Flux<String> fluxConcat() {
		Flux<String> data1 = Flux.just("Mongo", "Orange");
		Flux<String> data2 = Flux.just("Data", "soivd");
		return Flux.concat(data1, data2);
	}
	
	public Flux<String> fluxConcatWith() {
		Flux<String> data1 = Flux.just("Mongo", "Orange");
		return Flux.just("Data", "soivd").concatWith(data1);
	}
	
	public Flux<String> fluxMerge() {
		Flux<String> data1 = Flux.just("Mongo", "Orange").delayElements(Duration.ofMillis(50));
		Flux<String> data2 = Flux.just("Data", "soivd").delayElements(Duration.ofMillis(75));
		return Flux.merge(data1, data2);
//		return data1.mergeWith(data2);
//		return Flux.mergeSequential(data1, data2);
	}
	
	public Flux<String> fluxZip() {
		Flux<String> data1 = Flux.just("Mongo", "Orange");
		Flux<String> data2 = Flux.just("Data", "soivd");
		return Flux.zip(data1, data2, (first, second) -> first+second);
	}
	
	public Flux<String> fluxZipTapule() {
		Flux<String> data1 = Flux.just("Data1", "Class1");
		Flux<String> data2 = Flux.just("Data2", "Class2");
		Flux<String> data3 = Flux.just("Data3", "Class3");
		return Flux.zip(data1, data2, data3).map(x -> x.getT1()+x.getT2()+x.getT3());
	}
	
	public Flux<String> fluxDoON() {
		Flux<String> data1 = Flux.just("Data1", "Class1","dsofiuv", "lshydfui");
		return data1.map(String::toUpperCase)
				.doOnSubscribe(sub -> System.out.println("sub time call =>"+sub))
				.doOnNext(element -> System.out.println("Elemetnt =>"+element))
				.doOnComplete(() -> System.out.println("On Complete"));
	}
	
	//=============ONERROR=====================
	
	public Flux<String> onErrorReturn() {
		Flux<String> data1 = Flux.just("Data1", "Class1","dsofiuv", "lshydfui");
		return data1.concatWith(Flux.error( new RuntimeException("Thsoi"))).onErrorReturn("DATA");
	}

	public Flux<String> onErrorContinue() {
		Flux<String> data1 = Flux.just("Data1", "Class1","date2");
		return data1.map(x -> {
			if(x.equals("Class1"))
				throw new RuntimeException("This is First");
			return x.toUpperCase();
		}).onErrorContinue((error, data) ->{
			System.out.println("Eroor =>"+ error.getLocalizedMessage());
			System.out.println("data =>"+ data);
		});
	}

	public Flux<String> onErrorMap() {
		Flux<String> data1 = Flux.just("Data1", "Class1","date2");
		return data1.map(x -> {
			if(x.equals("Class1"))
				throw new RuntimeException("This is First");
			return x.toUpperCase();
		}).onErrorMap((error) ->{
			System.out.println("Eroor =>"+ error.getLocalizedMessage());
			throw  new RuntimeException("Data Error");
		});
	}

	public Flux<String> doOnError() {
		Flux<String> data1 = Flux.just("Data1", "Class1","date2");
		return data1.map(x -> {
			if(x.equals("Class1"))
				throw new RuntimeException("This is First");
			return x.toUpperCase();
		}).doOnError((error) ->{
			System.out.println("Eroor =>"+ error.getLocalizedMessage());
		});
	}

	//===================Mono========================
	
	public Mono<String> monoData() {
		return Mono.just("One Date").log();
	}
		
	public Mono<List<String>> monoFlatmap() {
		return Mono.just("One Date").flatMap(x -> Mono.just(Arrays.asList(x.split("")))).log();
	}

	public Flux<String> monoFlatMapMany() {
		return Mono.just("One Date").flatMapMany(x -> Flux.just(x.split(""))).log();
	}
	
	public static void main(String[] args) {
		FirstMainClass firstMainClass  = new FirstMainClass();
		System.out.println("\n\n=====FLUX DATA=====");
		firstMainClass.fluxData().subscribe(x -> System.out.println("data => "+x));
		System.out.println("\n\n=====MONO DATA=====");
		firstMainClass.monoData().subscribe(x -> System.out.println("data => "+x));
	}
	
}
