/*
 * 2017-11-23
 */
package ru.davist.webwatcher.domain;

/**
 * @author Starovoytov Danil
 */
public class GrabInterval {

    private int every;

    private IntervalType type;

    public int getEvery() {
        return every;
    }

    public void setEvery(int every) {
        this.every = every;
    }

    public IntervalType getType() {
        return type;
    }

    public void setType(IntervalType type) {
        this.type = type;
    }

    public enum IntervalType {
        MINUTE,
        HOUR,
        DAY,
        WEEK,
        MONTH
    }
}
