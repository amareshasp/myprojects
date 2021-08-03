package com.amareshasp.njbatchprocessing.config;

import com.amareshasp.njbatchprocessing.model.NewsItemDTO;
import com.amareshasp.njbatchprocessing.step.FeedMessage;
import com.amareshasp.njbatchprocessing.step.RssReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    private Resource outputResource = new FileSystemResource("output/outputData.csv");

    @Bean
    public ItemReader<FeedMessage> reader() {
//        StaxEventItemReader<NewsItemDTO> reader = new StaxEventItemReader<>();
//        reader.setResource(new ClassPathResource("sample_feed.xml"));
//        reader.setFragmentRootElementName("item");
//        Map<String, String> aliases = new HashMap<String, String>();
//        aliases.put("item", "com.amareshasp.njbatchprocessing.model.NewsItemDTO");
//
//        XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
//        try {
//            xStreamMarshaller.setAliases(aliases);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        reader.setUnmarshaller(xStreamMarshaller);
//
//        return reader;

        return new RssReader();

    }



    @Bean
    public FlatFileItemWriter<FeedMessage> writer()
    {
        //Create writer instance
        FlatFileItemWriter<FeedMessage> writer = new FlatFileItemWriter<>();

        //Set output file location
        writer.setResource(outputResource);

        //All job repetitions should "append" to same output file
        writer.setAppendAllowed(true);

        //Name field values sequence based on object properties
        writer.setLineAggregator(new DelimitedLineAggregator<FeedMessage>() {
            {
                setDelimiter(",");
                setFieldExtractor(new BeanWrapperFieldExtractor<FeedMessage>() {
                    {
                        setNames(new String[] { "title", "link", "pubDate" });
                    }
                });
            }
        });
        return writer;
    }
    @Bean
    public Step step1(){
        return stepBuilderFactory.get("step1").<FeedMessage,FeedMessage> chunk(10).reader(reader()).writer(writer()).build();
    }
    @Bean
    public Job importUserJob() {
        return jobBuilderFactory.get("loadFeeds")
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();

    }

}
