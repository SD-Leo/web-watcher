/*
 * 2017-11-21
 */
package ru.davist.webwatcher.domain;

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
}
