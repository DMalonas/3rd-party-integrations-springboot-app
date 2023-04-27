//package com.mintos.weather;
//
//import com.mintos.weather.services.client.ipapi.IpApiClient;
//import com.mintos.weather.services.client.ipapi.IpApiResult;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//import org.mockito.Mockito;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
//import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//import java.time.Duration;
//import java.time.Duration;
//
//import static org.mockito.Mockito.times;
//
//public class IpApiClientTest {
//
//    private WebClient webClient;
//    private IpApiClient ipApiClient;
//
//    @BeforeEach
//    public void setup() {
//        webClient = Mockito.mock(WebClient.class);
//        ipApiClient = new IpApiClient(webClient);
//    }
//
//    @Test
//    public void testGetIpApiResultReturnsSuccess() {
//        String query = "1.2.3.4";
//        IpApiResult expectedResult = new IpApiResult(
//                query, "success", "Country", "CC", "Region", "Region Name",
//                "City", "12345", 1.0, 2.0, "Timezone", "ISP", "Organization", "AS");
//        String expectedUri = "http://ip-api.com/json/" + query;
//
//        WebClient.RequestHeadersUriSpec<IpApiResult> requestHeadersUriSpecMock = Mockito.mock(WebClient.RequestHeadersUriSpec.class);
//
//
//        WebClient.ResponseSpec responseSpecMock = Mockito.mock(WebClient.ResponseSpec.class);
//
//        Mockito.when(webClient.get()).thenReturn(requestHeadersUriSpecMock);
//        Mockito.when(requestHeadersUriSpecMock.uri(expectedUri)).thenReturn(responseSpecMock);
//
//        Mockito.when(requestHeadersUriSpecMock.uri(expectedUri)).thenReturn(requestHeadersUriSpecMock);
//
//        Mockito.when(requestHeadersUriSpecMock.retrieve()).thenReturn(responseSpecMock);
//        Mockito.when(responseSpecMock.bodyToMono(IpApiResult.class)).thenReturn(Mono.just(expectedResult));
//
//        Mono<IpApiResult> result = ipApiClient.getIpApiResult(query);
//
//        StepVerifier.create(result)
//                .expectNext(expectedResult)
//                .verifyComplete();
//
//        Mockito.verify(webClient, times(1)).get();
//        Mockito.verify(requestHeadersUriSpecMock, times(1)).uri(expectedUri);
//        Mockito.verify(requestHeadersUriSpecMock, times(1)).retrieve();
//        Mockito.verify(responseSpecMock, times(1)).bodyToMono(IpApiResult.class);
//    }
//
//    @Test
//    public void testGetIpApiResultReturnsEmptyOnError() {
//        String query = "1.2.3.4";
//        String expectedUri = "http://ip-api.com/json/" + query;
//
//        WebClient.RequestHeadersUriSpec<?> requestHeadersUriSpecMock = Mockito.mock(WebClient.RequestHeadersUriSpec.class);
//        WebClient.ResponseSpec responseSpecMock = Mockito.mock(WebClient.ResponseSpec.class);
//
//        Mockito.when(webClient.get()).thenReturn(requestHeadersUriSpecMock);
//        Mockito.when(requestHeadersUriSpecMock.uri(expectedUri)).thenReturn(requestHeadersUriSpecMock);
//
//        Mockito.when(requestHeadersUriSpecMock.retrieve()).thenReturn(responseSpecMock);
//        Mockito.when(responseSpecMock.bodyToMono(IpApiResult.class)).thenThrow(new RuntimeException("Error!"));
//
//        Mono<IpApiResult> result = ipApiClient.getIpApiResult(query);
//
//        StepVerifier.create(result)
//                .verifyComplete();
//
//        Mockito.verify(webClient, times(1)).get();
//        Mockito.verify(requestHeadersUriSpecMock, times(1)).uri(expectedUri);
//        Mockito.verify(requestHeadersUriSpecMock, times(1)).retrieve();
//        Mockito.verify(responseSpecMock, times(1)).bodyToMono(IpApiResult.class);
//    }
//}
//
//
