package com.expeditors.pricing;

import com.expeditors.domain.Track;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@Profile("inmemprice")
public class InMemoryPricingProvider implements PricingProvider {

    @Override
    public void addPriceToTrack(Track track){
        int lowerLimit = 1;
        int higherLimit = 7;

        track.setPrice(ThreadLocalRandom.current().nextInt(lowerLimit,higherLimit));
        //track.setPrice(RandomPrice.generatePriceFromRange(0.49,7.00));
    }
}
