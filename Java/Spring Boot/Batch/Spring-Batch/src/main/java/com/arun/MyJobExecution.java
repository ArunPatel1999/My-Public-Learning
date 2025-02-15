package com.arun;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class MyJobExecution implements JobExecutionListener{

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("job Start");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("job complete => "+jobExecution.getStatus().toString());
	}

}
