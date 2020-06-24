package com.grindline.testing;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SegmentFilterImplTest {

    private SegmentFilter segmentFilter = new SegmentFilterImpl();

    private FlightBuilder flightBuilder = new FlightBuilderTest();

    private List<Flight> flights = flightBuilder.createFlights();

    @Test
    public void getDepartureTimeBeforeNow() {
        Assert.assertNotNull(flights);
        Assert.assertEquals(5, segmentFilter.getDepartureTimeBeforeNow(flights).size() );
    }

    @Test
    public void getArrivalDateLessDepartureDate() {
        Assert.assertNotNull(flights);
        Assert.assertEquals(2, segmentFilter.getArrivalDateLessDepartureDate(flights).size() );
    }

    @Test
    public void getFlightWithTransferMoreThanTwoHours() {
        Assert.assertNotNull(flights);
        Assert.assertEquals(2, segmentFilter.getFlightWithTransferMoreThanTwoHours(flights).size() );
    }

}