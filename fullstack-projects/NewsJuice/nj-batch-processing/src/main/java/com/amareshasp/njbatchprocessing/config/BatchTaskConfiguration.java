package com.amareshasp.njbatchprocessing.config;

import com.amareshasp.njbatchprocessing.task.MasterDataReaderTask;
import com.amareshasp.njbatchprocessing.task.RssFeedProcessorTask;
import com.amareshasp.njbatchprocessing.task.RssFeedReaderTask;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchTaskConfiguration {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    protected Step readMasterData() {
        return steps.get("readMasterData").tasklet(masterDataReader()).build();
    }

    @Bean
    protected Step readRssFeed() {
        return steps.get("readRssFeed").tasklet(rssFeedReader()).build();
    }

    @Bean
    protected Step processRssFeed() {
        return steps.get("processRssFeed").tasklet(rssFeedProcessor()).build();
    }

    @Bean
    protected Step writeRssFeed() {
        return steps.get("writeRssFeed").tasklet(masterDataReader()).build();
    }

    @Bean
    public Job job() {
        return jobs.get("NewsRetriever")
                .start(readMasterData())
                .next(readRssFeed())
                .next(processRssFeed())
                .next(writeRssFeed()).build();
    }

    @Bean
    public MasterDataReaderTask masterDataReader(){
        return new MasterDataReaderTask();
    }
    @Bean
    public RssFeedReaderTask rssFeedReader(){
        return new RssFeedReaderTask();
    }
    @Bean
    public RssFeedProcessorTask rssFeedProcessor(){
        return new RssFeedProcessorTask();
    }


}
