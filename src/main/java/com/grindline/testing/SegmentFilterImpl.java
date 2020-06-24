package com.grindline.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SegmentFilterImpl implements SegmentFilter {

    public void showAllSegments(List<Flight> flights) {
        for (Flight flight : flights ) {
            System.out.println("Flight number - " + flight.getId());
            for(int i = 0; i < flight.getSegments().size(); i++) {
                System.out.println(flight.getSegments().get(i) + " Segment number is " + flight.getSegments().get(i).getId());
            }
        }
    }

    public Set<Flight> getArrivalDateLessDepartureDate(List<Flight> flights) {

        Set<Flight> resultSet = new HashSet<>();
        List<Segment> split = new ArrayList<>();
        for (Flight flight : flights ) {
               split.addAll(flight.getSegments());

            while (split.size() > 0) {
                LocalDateTime departureTime = split.get(0).getDepartureDate();
                LocalDateTime arrivalTime = split.remove(0).getArrivalDate();
                if(arrivalTime.isBefore(departureTime)) {
                    showRightFLight(flight, departureTime, arrivalTime);
                    resultSet.add(flight);
                }
            }

            }
        return resultSet;
    }



    public Set<Flight> getDepartureTimeBeforeNow(List<Flight> flights) {
        LocalDateTime timeNow = LocalDateTime.now();
        Set<Flight> resultSet = new HashSet<>();
        List<Segment> split = new ArrayList<>();
        for (Flight flight : flights ) {
            split.addAll(flight.getSegments());

            while (split.size() > 0) {
                LocalDateTime departureTime = (split.get(0).getDepartureDate());
                LocalDateTime arrivalTime = (split.remove(0).getArrivalDate());
                if(departureTime.isAfter(timeNow)) {
                    showRightFLight(flight, departureTime, arrivalTime);
                    resultSet.add(flight);
                }
            }

        }
        return resultSet;
    }

    public Set<Flight> getFlightWithTransferMoreThanTwoHours(List<Flight> flights) {
        Set<Flight> resultSet = new HashSet<>();
        List<Segment> split = new ArrayList<>();
        for (Flight flight : flights ) {
            split.addAll(flight.getSegments());
            if (split.size() > 2) {
                while (split.size() > 2) {
                    LocalDateTime arrivalTime = split.remove(1).getArrivalDate();
                    LocalDateTime departureTime = split.remove(1).getDepartureDate();
                    if(departureTime.isAfter(arrivalTime.plusHours(2))) {
                        showTransfer(flight, arrivalTime, departureTime);
                        resultSet.add(flight);
                    }
                }
            }
        }
        return resultSet;
    }



    private void showRightFLight(Flight flight, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        DateTimeFormatter dateTimeFormatter = getDateFormatter();
        System.out.println( "Flight number - " + flight.getId()  + "\n" + "Departure time: " + dateTimeFormatter.format(departureTime) + "\n" + "Arrival time: " + dateTimeFormatter.format(arrivalTime) );
        System.out.println("---------------------------------------------------------------------------");

    }

    private void showTransfer(Flight flight, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        DateTimeFormatter dateTimeFormatter = getDateFormatter();
        System.out.println( "Flight number - " + flight.getId()  + "\n" + "Arrival time: " + dateTimeFormatter.format(arrivalTime) + "\n" + "Departure time: " + dateTimeFormatter.format(departureTime)  );
        System.out.println("---------------------------------------------------------------------------");

    }

    private DateTimeFormatter getDateFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    }


}
