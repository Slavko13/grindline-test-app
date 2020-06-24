package com.grindline.testing;

import java.util.List;
import java.util.Set;

public interface SegmentFilter {

    void showAllSegments(List<Flight> flights);
    Set<Flight> getDepartureTimeBeforeNow(List<Flight> flights);
    Set<Flight> getArrivalDateLessDepartureDate(List<Flight> flights);
    Set<Flight> getFlightWithTransferMoreThanTwoHours(List<Flight> flights);

}
