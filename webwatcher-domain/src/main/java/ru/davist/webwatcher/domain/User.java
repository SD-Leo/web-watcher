/*
 * 2017-11-23
 */
package ru.davist.webwatcher.domain;

import ru.davist.webwatcher.domain.notify.Notifier;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Starovoytov Danil
 */
public class User {

    private String id;

    private String login;

    private String email;

    private String name;

    private String password;

    private LocalDateTime registration;

    private List<Notifier> notifiers;

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDateTime registration) {
        this.registration = registration;
    }

    public List<Notifier> getNotifiers() {
        return notifiers;
    }

    public void setNotifiers(List<Notifier> notifiers) {
        this.notifiers = notifiers;
    }
}
