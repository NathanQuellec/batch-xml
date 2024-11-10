package com.example.batch_xml;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:job.xml") // Load the XML batch configuration
public class BatchXmlApplication implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job helloJob;

	public static void main(String[] args) {
		SpringApplication.run(BatchXmlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jobLauncher.run(helloJob, new org.springframework.batch.core.JobParameters());
	}
}
