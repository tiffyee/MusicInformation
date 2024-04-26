package com.expeditors.pricing;

import com.expeditors.domain.Track;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@Profile("networkprice")
public class NetworkPricingProvider implements PricingProvider {

    private String pricingUrl;
    private RestClient restClient;

    public NetworkPricingProvider() {
        var baseUrl = "http://localhost:8081";

        var rootUrl = "/pricing";
        pricingUrl = rootUrl + "/{id}";

        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Accept", "application/json")
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
    @Override
    public void addPriceToTrack(Track track) {
        ResponseEntity<Integer> response = restClient.get()
                .uri(pricingUrl, 1)
                .retrieve()
                .toEntity(Integer.class);

        if(response.getStatusCode() == HttpStatus.OK) {
            Integer price =  response.getBody();
            if(price != null) {
                track.setPrice(price);
            }
        }

    }
}
