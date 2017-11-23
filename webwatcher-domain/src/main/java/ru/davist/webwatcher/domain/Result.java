/*
 * 2017-11-19
 */
package ru.davist.webwatcher.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Starovoytov Danil
 */
public class Result {

    /**
     * Основное значение, которое необходимо получать со страницы
     */
    private String value;

    /**
     * Предыдущее значение. Важно понимать, что это не значение предыдущего "замера"
     * а значение на той же странице, например зачеркнутая старая цена (до применения скидки).
     * Это необязательное значение - его может не быть на странице.
     */
    private String prevValue;

    /**
     * Время когда получены данные со страницы
     */
    private LocalDateTime time;

    /**
     * Если со страницы нужно получить дополнительную информацию, то ее можно передать через это поле.
     * Map потому что может быть несколько значений и их нужно различать по ключам.
     */
    private Map<String, String> additionalValues;

    public Result() {
        this.time = LocalDateTime.now();
    }

    public Result(String value) {
        this();
        this.value = value;
    }

    public Result(String value, String prevValue) {
        this(value);
        this.prevValue = prevValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPrevValue() {
        return prevValue;
    }

    public void setPrevValue(String prevValue) {
        this.prevValue = prevValue;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Map<String, String> getAdditionalValues() {
        return additionalValues;
    }

    public void setAdditionalValues(Map<String, String> additionalValues) {
        this.additionalValues = additionalValues;
    }

    public void addAdditionalValue(String key, String value) {
        if (this.additionalValues == null) {
            this.additionalValues = new HashMap<>();
        }
        this.additionalValues.put(key, value);
    }
}
