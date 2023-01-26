package batch.scheduling.utils.crawling;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Crawling {
    private final static String url = "https://store.steampowered.com/specials/?l=koreana";

    public static String process() {
        Document document = null;
        Connection conn = Jsoup.connect(url);
        //Jsoup 커넥션 생성

        try {
            document = conn.get();
            //url의 내용을 HTML Document 객체로 가져온다.
            Elements selects = document.select("div..facetedbrowse_FacetedBrowseItems_NO-IP");

            //selenium 으로 해야함
//            for (Elements e : selects) {
//                System.out.println("download: " + e.text());
//                return selects.text();
//            }
//            selects.select("");

            //https://jsoup.org/apidocs/org/jsoup/nodes/Document.html 참고
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("aaa");

        return null;
    }



}
