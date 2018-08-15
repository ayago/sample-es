package com.qt.adrian.sample.sg.venue.vo;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class TimeSlots implements Iterable<TimeSlot> {

    private final List<TimeSlot> timeSlotList;

    public TimeSlots(List<TimeSlot> timeSlots){
        this.timeSlotList = timeSlots;
    }

    @Override
    public Iterator<TimeSlot> iterator() {
        return timeSlotList.iterator();
    }

    @Override
    public void forEach(Consumer<? super TimeSlot> action) {
        for (TimeSlot timeSlot: timeSlotList) {
            action.accept(timeSlot);
        }
    }

    @Override
    public Spliterator<TimeSlot> spliterator() {
        return timeSlotList.spliterator();
    }
}
