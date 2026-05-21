package com.example.fabricordersserver.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_settings")
public class UserSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // users 테이블과 1:1 연결
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    private String theme;

    private boolean autoSave;

    private boolean notification;

    private String startPage;

    protected UserSetting() {}

    public UserSetting(User user) {
        this.user = user;
        this.theme = "light";
        this.autoSave = true;
        this.notification = true;
        this.startPage = "/settings";
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getTheme() {
        return theme;
    }

    public boolean isAutoSave() {
        return autoSave;
    }

    public boolean isNotification() {
        return notification;
    }

    public String getStartPage() {
        return startPage;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setAutoSave(boolean autoSave) {
        this.autoSave = autoSave;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    public void setStartPage(String startPage) {
        this.startPage = startPage;
    }
}