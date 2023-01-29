package batch.scheduling.jobs.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContextBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.JettyClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
@Slf4j
public class WebclientConfig {
//    ExchangeStrategies strategies = ExchangeStrategies
//            .builder()
//            .codecs(configurer -> {configurer
//                    .defaultCodecs()
//                    .maxInMemorySize(-1);       // unlimited buffer size (default: 256k)
//
//                WebClient webClient = WebClient.builder()
//                        .exchangeStrategies(strategies)
//                        .build();

        @Bean
        public WebClient webClient() {


//            HttpClient httpClient = new HttpClient();
//
//            HttpClient httpClient = HttpClient.create()
//                    .tcpConfiguration(client ->
//                            client.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000));
//
//            ClientHttpConnector connector = new JettyClientHttpConnector(httpClient);


            ExchangeStrategies exchangeStrategy = ExchangeStrategies.builder()
                    .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1))
                    .build();

            WebClient webClient = WebClient.builder().exchangeStrategies(exchangeStrategy).baseUrl("https://www.daangn.com/search/")
                    .build();
            return webClient;
        }
}
