/*
 * 2017-11-23
 */
package ru.davist.webwatcher.domain.notify;

/**
 * Настройка события уведомлений
 *
 * @author Starovoytov Danil
 */
public enum ChangeValueType {

    /**
     * Значение изменилось, т.е. стало не таким как в предыдущем "замере"
     */
    CHANGED,

    /**
     * Значение стало меньше. Логично, что это работает только для числовых значений.
     * Если значение не целочисленное, то будет срабатывать как CHANGED
     */
    LESS,

    /**
     * Значение стало больше. Логично, что это работает только для числовых значений
     * Если значение не целочисленное, то будет срабатывать как CHANGED
     */
    GREATER
}