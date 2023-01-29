package batch.scheduling.jobs.config;

import batch.scheduling.jobs.tasklet.Crawling;
import batch.scheduling.jobs.tasklet.JsoupCrawling;
import batch.scheduling.jobs.tasklet.ParseCrawling;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class BatchConfig {
    private final WebClient webClient;
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job noticeUpdateJob(Step step1) {
        return this.jobBuilderFactory.get("noticeUpdateJob")
                .start(danggenCarwlingStep(webClient))
                .next(parseCrawlingStep())
                .build();
    }

    private Step parseCrawlingStep() {
        return stepBuilderFactory.get("parseCrawlingStep").tasklet(new ParseCrawling()).build();
                    }

    @JobScope
    @Bean
    public Step danggenCarwlingStep(WebClient webClient) {
        return stepBuilderFactory.get("danggenCarwlingStep").tasklet(new JsoupCrawling(webClient)).build();

    }



}
