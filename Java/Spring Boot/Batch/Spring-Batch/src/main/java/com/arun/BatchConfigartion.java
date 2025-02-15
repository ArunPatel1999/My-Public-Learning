package com.arun;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfigartion {
	
	
	private Reader reader;
	private Writer writer;
	private Processer processer;
	private MyJobExecution myJobExecution;
	private StepBuilderFactory sbf;
	private JobBuilderFactory jbf;
	
	
	public BatchConfigartion(Reader reader, Writer writer, Processer processer, MyJobExecution myJobExecution,
			StepBuilderFactory sbf, JobBuilderFactory jbf) {
		super();
		this.reader = reader;
		this.writer = writer;
		this.processer = processer;
		this.myJobExecution = myJobExecution;
		this.sbf = sbf;
		this.jbf = jbf;
	}

	@Bean
	public Job job() {
		return jbf.get("job1").incrementer(new RunIdIncrementer()).listener(myJobExecution).start(step()).build();
	}

	@Bean
	public Step step() {
		return sbf.get("step1").<String,String>chunk(1)
				.reader(reader)
				.writer(writer)
				.processor(processer)
				.build();
	}
	
	

}
