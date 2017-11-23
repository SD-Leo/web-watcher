/*
 * 2017-11-21
 */
package ru.davist.webwatcher.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Желанная цель. Это некоторое значение, которое необходимо получать с web-страницы.
 * Хоть и объект пытаеться быть универсальным, но почти все заточено на то, чтобы получать цену товара.
 * Хотя конечно можно получать курс валют, погоду и другое.
 *
 * @author Starovoytov Danil
 */
public class WantedTarget {

    /**
     * Название задачи. Например "Хвох, который я так давно хотел"
     * или "Курс доллара"
     */
    private String name;

    /**
     * URL со страницей, за которой нужно следить
     * Пока урл один, возможно потом можно будет агрегировать получаемое значения с нескольких страниц.
     */
    private String url;

    private List<String> selectors;

    private List<String> prevValueSelectors;

    private String userId;

    private GrabInterval grabInterval;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getSelectors() {
        return selectors;
    }

    public void setSelectors(List<String> selectors) {
        this.selectors = selectors;
    }

    public void addSelector(String selector) {
        if (this.selectors == null) {
            this.selectors = new ArrayList<>();
        }
        this.selectors.add(selector);
    }

    public List<String> getPrevValueSelectors() {
        return prevValueSelectors;
    }

    public void setPrevValueSelectors(List<String> prevValueSelectors) {
        this.prevValueSelectors = prevValueSelectors;
    }

    public void addPrevValueSelector(String prevValueSelector) {
        if (this.prevValueSelectors == null) {
            this.prevValueSelectors = new ArrayList<>();
        }
        this.prevValueSelectors.add(prevValueSelector);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public GrabInterval getGrabInterval() {
        return grabInterval;
    }

    public void setGrabInterval(GrabInterval grabInterval) {
        this.grabInterval = grabInterval;
    }
}
