package batch.scheduling.jobs.tasklet;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Component
@StepScope
@RequiredArgsConstructor
@Slf4j
public class Crawling implements Tasklet, StepExecutionListener {
    private final static String url = "https://www.daangn.com/search/";

    private static WebDriver webDriver;
    private static XPath xPath = XPathFactory.newInstance().newXPath();


    @Override
    public void beforeStep(StepExecution stepExecution) {

    }
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        System.setProperty("webdriver.chrome.driver", "/Users/sol/Desktop/chromedriver_mac_arm64/chromedriver");

        int pageDown = 10;
        Document document = null;
        webDriver = new ChromeDriver();

        webDriver.get(url+"전자레인지");
        Thread.sleep(1000);
        log.info("url connect");
        List<WebElement> elements = webDriver.findElements(By.className("article-info"));

        while (pageDown > 0) {
            pageDown--;
            webDriver.findElement(By.xpath("//*[@id=\"result\"]/div[1]/div[2]")).click();
            if (elements.size() > 0) {
                for (WebElement element : elements) {
                    System.out.println(element.getText());
                }
            }

        }

//        if (elements.size() > 0) {
//            for (WebElement element : elements) {
//                System.out.println(element.getText());
//            }
//        }



        return RepeatStatus.FINISHED;
    }

//
//    public static String process() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "/Users/sol/Desktop/chromedriver_mac_arm64/chromedriver");
//
//        webDriver = new ChromeDriver();
//
//
//        Document document = null;
//        Connection conn = Jsoup.connect(url+"전자레인지");
//        //Jsoup 커넥션 생성
//
//        try {
//            document = conn.get();
//            //url의 내용을 HTML Document 객체로 가져온다.
////            Elements selects = document.select("div..facetedbrowse_FacetedBrowseItems_NO-IP");
//
//            webDriver.get("div..facetedbrowse_FacetedBrowseItems_NO-IP");
//            Thread.sleep(1000);
//            WebElement element = webDriver.findElement(By.tagName("div"));
//
//            System.out.println(element);
//
//            //selenium 으로 해야함
////            for (Elements e : selects) {
////                System.out.println("download: " + e.text());
////                return selects.text();
////            }
////            selects.select("");
//
//            //https://jsoup.org/apidocs/org/jsoup/nodes/Document.html 참고
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("aaa");
//
//        return null;
//    }
//

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }


}
