package com.arun;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableBatchProcessing
public class MyBatchConfigartion {

	@Autowired
	private StepBuilderFactory stepBuilder;
	@Autowired
	private JobBuilderFactory jobBuilder;
	
	
	@Bean
	public Job job() {
		return jobBuilder.get("job1").incrementer(new RunIdIncrementer()).start(step()).build();
	}

	@Bean
	public Step step() {
		return stepBuilder.get("step1").<Product,Product>chunk(3)
				.reader(reder())
				.writer(writer())
				.processor(processor())
				.build();
	}
	
	
	@Bean
	public ItemReader<Product> reder(){
		
		FlatFileItemReader<Product> reder = new FlatFileItemReader<>();
		reder.setResource(new ClassPathResource("product.csv"));
		
		DefaultLineMapper<Product> lineMappe = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id","name","price");
		BeanWrapperFieldSetMapper<Product> fielMapper = new BeanWrapperFieldSetMapper<>();
		fielMapper.setTargetType(Product.class);
		
		lineMappe.setFieldSetMapper(fielMapper);
		lineMappe.setLineTokenizer(lineTokenizer);
		reder.setLineMapper(lineMappe);
		return reder;
	}
	
	@Bean
	public ItemProcessor<Product, Product> processor(){
		return  p -> { p.setPrice(p.getPrice()+100); return p; };
	}
	
	@Bean
	public ItemWriter<Product> writer() {
		JdbcBatchItemWriter<Product> writer = new JdbcBatchItemWriter<>();
		writer.setDataSource(dataSource());
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		writer.setSql("INSERT INTO product (ID,NAME,PRICE) VALUES (:id, :name, :price)");
		return writer;
	}
	

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("pma");
		dataSource.setPassword("");
		return dataSource;
	}
}
