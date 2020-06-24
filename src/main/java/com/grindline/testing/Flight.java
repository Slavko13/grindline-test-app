package com.grindline.testing;

import java.util.List;
import java.util.stream.Collectors;

public class Flight {

    private final List<Segment> segments;
    private final Integer id;

    Flight(final List<Segment> segs, Integer id) {
        segments = segs;
        this.id = id;
    }

    List<Segment> getSegments() {
        return segments;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return segments.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }



}
