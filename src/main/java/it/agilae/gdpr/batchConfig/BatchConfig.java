package it.agilae.gdpr.batchConfig;

import it.agilae.gdpr.model.Notifica;
import it.agilae.gdpr.stepUtils.BatchProcessor;
import it.agilae.gdpr.stepUtils.BatchRead;
import it.agilae.gdpr.stepUtils.BatchWrite;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Autowired
    public BatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory){
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    // Creazione del Job
    @Bean
    public Job jobNotifiche(){
        return jobBuilderFactory.get("jobNotifiche")
                .start(stepNotifiche())
                .build();
    }

    // Creazione Step
    @Bean
    public Step stepNotifiche(){
        return stepBuilderFactory.get("StepNotifiche")
                .<Notifica,Notifica>chunk(10)
                .reader(batchRead())
                .processor(batchProcessor())
                .writer(batchWrite())
                .build();
    }

    // Creazione degli Step

    // Reader DB
    public BatchRead batchRead(){
        return new BatchRead();
    }

    // Processor Notifiche
    public BatchProcessor batchProcessor(){
        return new BatchProcessor();
    }

    // Writer DB
    public BatchWrite batchWrite(){
        return new BatchWrite();
    }
}
