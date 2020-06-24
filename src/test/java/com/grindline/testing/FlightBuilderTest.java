package com.grindline.testing;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FlightBuilderTest extends FlightBuilder {

    @Override
    public List<Flight> createFlights() {
        LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
        return Arrays.asList(
                //A flight departing in the past
                createFlight(threeDaysFromNow.minusDays(10), threeDaysFromNow),
                //A normal flight
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(4)),
                //A normal multi segment flight
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(5)),
                //A flight departing in the past
                createFlight(threeDaysFromNow.minusDays(6), threeDaysFromNow),
                //A flight that departs before it arrives
                createFlight(threeDaysFromNow, threeDaysFromNow.minusHours(6)),
                //A flight with more than two hours ground time
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(6)),
                //Broken multi flight
                createFlight(threeDaysFromNow, threeDaysFromNow.plusHours(2),
                        threeDaysFromNow.plusHours(5), threeDaysFromNow.plusHours(4),
                        threeDaysFromNow.plusHours(8), threeDaysFromNow.plusHours(7)));
    }
}
