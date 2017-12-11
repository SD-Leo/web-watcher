/*
 * 2017-11-21
 */
package ru.davist.webwatcher.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.davist.webwatcher.domain.ScreenshotEventType.NONE;

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

    /**
     * Последовательный набор веб-селекторов, по которым будет осуществлятся поиск требуемого значения на странице.
     * Селекторы должны быть jquary-подобными
     */
    private List<String> selectors;

    /**
     * Иногда хочется на странице "наблюдать" за несколькими значениями. Например: предыдущая цена, время, геопозиция и др.
     * Это можно осуществить с помощью дополнительных селекторов.
     */
    private Map<String, List<String>> additionalSelectors;

    /**
     * Идентификатор пользователя-владельца
     */
    private String userId;

    /**
     * Настройки интервала, как часто нужно осуществлять проверку страницы на изменения
     */
    private GrabInterval grabInterval;

    private Map<String, String> cookies;

    private ScreenshotEventType makeScreenshot = NONE;


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

    public Map<String, List<String>> getAdditionalSelectors() {
        return additionalSelectors;
    }

    public void setAdditionalSelectors(Map<String, List<String>> additionalSelectors) {
        this.additionalSelectors = additionalSelectors;
    }

    public void addAdditionalSelector(String name, String selector) {
        if (this.additionalSelectors == null) {
            this.additionalSelectors = new HashMap<>();
        }
        this.additionalSelectors.computeIfAbsent(name, k -> new ArrayList<>());
        this.additionalSelectors.get(name).add(selector);
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

    public Map<String, String> getCookies() {
        return cookies;
    }

    public void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    public void addCookie(String key, String value) {
        if (this.cookies == null) {
            this.cookies = new HashMap<>();
        }
        this.cookies.put(key, value);
    }

    public ScreenshotEventType getMakeScreenshot() {
        return makeScreenshot;
    }

    public void setMakeScreenshot(ScreenshotEventType makeScreenshot) {
        this.makeScreenshot = makeScreenshot;
    }
}
