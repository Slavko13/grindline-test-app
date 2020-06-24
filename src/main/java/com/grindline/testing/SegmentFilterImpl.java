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
        DateTimeFormatter dateTimeFormatter = getDateFormatter();
        Set<Flight> resultSet = new HashSet<>();

        for (Flight flight : flights ) {
                List<String> split = getListAfterSplit(flight);

            while (split.size() > 0) {
                LocalDateTime departureTime = LocalDateTime.parse(split.remove(0), dateTimeFormatter);
                LocalDateTime arrivalTime = LocalDateTime.parse(split.remove(0), dateTimeFormatter);
                if(arrivalTime.isBefore(departureTime)) {
                    showRightFLight(flight, departureTime, arrivalTime);
                    resultSet.add(flight);
                }
            }

            }
        return resultSet;
    }



    public Set<Flight> getDepartureTimeBeforeNow(List<Flight> flights) {
        DateTimeFormatter dateTimeFormatter = getDateFormatter();
        LocalDateTime timeNow = LocalDateTime.now();
        Set<Flight> resultSet = new HashSet<>();

        for (Flight flight : flights ) {
            List<String> split = getListAfterSplit(flight);

            while (split.size() > 0) {
                LocalDateTime departureTime = LocalDateTime.parse(split.remove(0), dateTimeFormatter);
                LocalDateTime arrivalTime = LocalDateTime.parse(split.remove(0), dateTimeFormatter);
                if(departureTime.isAfter(timeNow)) {
                    showRightFLight(flight, departureTime, arrivalTime);
                    resultSet.add(flight);
                }
            }

        }
        return resultSet;
    }

    public Set<Flight> getFlightWithTransferMoreThanTwoHours(List<Flight> flights) {
        DateTimeFormatter dateTimeFormatter = getDateFormatter();
        Set<Flight> resultSet = new HashSet<>();

        for (Flight flight : flights ) {
            List<String> split = getListAfterSplit(flight);
            if (split.size() > 2) {
                while (split.size() > 2) {
                    LocalDateTime arrivalTime = LocalDateTime.parse(split.remove(1), dateTimeFormatter);
                    LocalDateTime departureTime = LocalDateTime.parse(split.remove(1), dateTimeFormatter);
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
        System.out.println( "Flight number - " + flight.getId()  + "\n" + "Departure time: " + departureTime + "\n" + "Arrival time: " + arrivalTime );
        System.out.println("---------------------------------------------------------------------------");

    }

    private DateTimeFormatter getDateFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    }

    private List<String> getListAfterSplit(Flight flight) {
        List<String> split = new ArrayList<>();

        for(int i = 0; i < flight.getSegments().size(); i++) {
            String[] temp = flight.getSegments().get(i).toString().substring(1, flight.getSegments().get(i).toString().length() - 1).split("\\|");
            split.addAll(Arrays.asList(temp));
        }
        return split;
    }

    private void showTransfer(Flight flight, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        System.out.println( "Flight number - " + flight.getId()  + "\n" + "Arrival time: " + arrivalTime + "\n" + "Departure time: " + departureTime );
        System.out.println("---------------------------------------------------------------------------");

    }
}
