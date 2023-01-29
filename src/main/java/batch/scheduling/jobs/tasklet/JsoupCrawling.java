package batch.scheduling.jobs.tasklet;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@StepScope
@RequiredArgsConstructor
@Slf4j
public class JsoupCrawling implements Tasklet {
    String item = "전자레인지";
    String pages = "/more/flea_market?page=";
    int pageNums = 100;



    private final WebClient webClient;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        while (pageNums != 0) {
            pageNums--;

            String element = webClient.get().uri(item+pages+pageNums).retrieve().bodyToMono(String.class).block();

            //Parse Json Data
            Document document = Jsoup.parse(element);

            Elements info = document.select("#flea-market-wrap > article:nth-child(2) > a > div.article-info");





            Elements info2 = document.getElementsByClass("article-info");


//        Elements photo = document.getElementsByClass("#flea-market-wrap > article:nth-child(2) > a > div.card-photo");


//        Elements title = info.select("article-title");
//        Elements contents = info.select("article-content");
//        Elements region = info.select("article-region-name");
//        Elements price = info.select("article-price ");
            for (Element t : info2) {
                System.out.println(t.text());
            }

        }
        return RepeatStatus.FINISHED;
    }


}
