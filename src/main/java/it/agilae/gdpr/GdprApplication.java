package it.agilae.gdpr;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
public class GdprApplication {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job jobNotifiche;

	public static void main(String[] args) {
		SpringApplication.run(GdprApplication.class, args);
	}


//		* * * * * ?    The command to be scheduled
//		| | | | |
//		| | | | +------------------ day of week: 0 - 6 (Sunday=0)
//		| | | +-------------------- month:  1 - 12
//		| |	+---------------------- day:  1 - 31
//		| +------------------------ hour:  0 - 23
//		+-------------------------- minute:  0 - 59
	@Scheduled(cron = "1 * * * * ?")
	public void perform() throws Exception{
		JobParameters params = new JobParametersBuilder()
				.addString("JobID", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		jobLauncher.run(jobNotifiche,params);
	}

}
