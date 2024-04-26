package com.expeditors.pricing;

import com.expeditors.domain.Track;

public interface PricingProvider {
    void addPriceToTrack(Track track);
}
