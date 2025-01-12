package com.arun.main;

import java.util.List;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.test.StepVerifier;

class FirstMainClassTest {

	FirstMainClass firstMainClass = new FirstMainClass();
	
	@Test
	void createFluxUsingGenrate() {
		Flux<Integer> data = Flux.generate(() ->1, (state, subscribe) ->{
			subscribe.next(state*2);
			if(state==10)
				subscribe.complete();
			return state+1;
		});
		
		StepVerifier.create(data.log()).expectNextCount(10).verifyComplete();
	}
	
	
	@Test
	void fluxData() {
		Flux<String> data = firstMainClass.fluxData();
		StepVerifier.create(data).expectNext("a", "b", "c", "d").verifyComplete();
	}
	
	@Test
	void fluxMapData() {
		Flux<String> data = firstMainClass.fluxMapData();
		StepVerifier.create(data).expectNext("A", "B", "C", "D").verifyComplete();
	}
	
	@Test 
	void fluxFilterData() {
		Flux<String> data = firstMainClass.fluxFilterData("a");
		StepVerifier.create(data).expectNext("a").verifyComplete();
	}

	@Test
	void fluxFlatMapData() {
		Flux<String> data = firstMainClass.fluxFlatMapData();
		StepVerifier.create(data).expectNextCount(25).verifyComplete();
	}
	
	@Test
	void fluxFlatMapDataASYC() {
		Flux<String> data = firstMainClass.fluxFlatMapDataASYC();
		StepVerifier.create(data).expectNextCount(25).verifyComplete();
	}

	@Test
	void fluxFlatMapDataASYCParallel() {
		ParallelFlux<String> data = firstMainClass.fluxFlatMapDataASYCParallel();
		StepVerifier.create(data).expectNextCount(25).verifyComplete();
	}
	
	@Test
	void fluxFlatMapDataASYCWithSchedulers() {
		Flux<String> data = firstMainClass.fluxFlatMapDataASYCWithSchedulers();
		StepVerifier.create(data).expectNextCount(25).verifyComplete();
	}
	

	@Test
	void fluxConcatMapData() {
		Flux<String> data = firstMainClass.fluxConcatMapData();
		StepVerifier.create(data).expectNextCount(25).verifyComplete();
	}
	
	@Test
	void fruitFluxTransforma() {
		Flux<String> data = firstMainClass.fruitFluxTransforma(50);
		StepVerifier.create(data).expectNext("Orange", "Banana").verifyComplete();
	}
	
	@Test
	void fluxConcat() {
		Flux<String> data = firstMainClass.fluxConcat().log();
		StepVerifier.create(data).expectNext("Mongo", "Orange","Data", "soivd").verifyComplete();
	}
	
	@Test
	void fluxConcatWith() {
		Flux<String> data = firstMainClass.fluxConcatWith().log();
		StepVerifier.create(data).expectNext("Data", "soivd", "Mongo", "Orange").verifyComplete();
	}
	
	@Test
	void fluxMearge() {
		Flux<String> data = firstMainClass.fluxMerge().log();
		StepVerifier.create(data).expectNext("Mongo", "Data", "Orange", "soivd").verifyComplete();
	}
	
	@Test
	void fluxZip() {
		Flux<String> data = firstMainClass.fluxZip().log();
		StepVerifier.create(data).expectNext("MongoData", "Orangesoivd").verifyComplete();
	}
	
	@Test
	void fluxZipTapule() {
		Flux<String> data = firstMainClass.fluxZipTapule().log();
		StepVerifier.create(data).expectNext("Data1Data2Data3", "Class1Class2Class3").verifyComplete();
	}
	
	@Test
	void fluxDoON() {
		Flux<String> data = firstMainClass.fluxDoON().log();
		StepVerifier.create(data).expectNext("DATA1", "CLASS1","DSOFIUV", "LSHYDFUI").verifyComplete();
	}
	
	//=========ON ERROR+++===============
	
	@Test
	void onErrorReturn() {
		Flux<String> data = firstMainClass.onErrorReturn().log();
		StepVerifier.create(data).expectNext("Data1", "Class1","dsofiuv", "lshydfui", "DATA").verifyComplete();
	}


	@Test
	void onErrorContinue() {
		Flux<String> data = firstMainClass.onErrorContinue().log();
		StepVerifier.create(data).expectNext("DATA1", "DATE2").verifyComplete();
	}

	@Test
	void onErrorMap() {
		Flux<String> data = firstMainClass.onErrorMap().log();
		StepVerifier.create(data).expectNext("DATA1").expectError(RuntimeException.class).verify();
	}

	@Test
	void doOnError() {
		Flux<String> data = firstMainClass.doOnError().log();
		StepVerifier.create(data).expectNext("DATA1").expectError(RuntimeException.class).verify();
	}

	//=================MONO===========================
	
	@Test
	void monoData() {
		Mono<String> data = firstMainClass.monoData();
		StepVerifier.create(data).expectNext("One Date").verifyComplete();
	}
	
	@Test
	void monoFlatMapData() {
		Mono<List<String>> data = firstMainClass.monoFlatmap();
		StepVerifier.create(data).expectNextCount(1).verifyComplete();
	}

	@Test
	void monoFlatMapmany() {
		Flux<String> data = firstMainClass.monoFlatMapMany();
		StepVerifier.create(data).expectNextCount(8).verifyComplete();
	}
}
