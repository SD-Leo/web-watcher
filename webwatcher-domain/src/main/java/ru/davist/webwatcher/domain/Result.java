package ru.davist.webwatcher.domain;

import java.time.LocalDateTime;

/**
 * on 19/11/2017.
 *
 * @author danil
 */
public class Result {

    private String value;

    private String oldValue;

    private LocalDateTime time;

    public Result() {
        this.time = LocalDateTime.now();
    }

    public Result(String value) {
        this();
        this.value = value;
    }

    public Result(String value, String oldValue) {
        this(value);
        this.oldValue = oldValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
