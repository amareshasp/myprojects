package com.amareshasp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Subscription{
    private String agency;
    private List<String> topics;

    public Subscription() {
    }

    public Subscription(String agency, List<String> topics) {
        this.agency = agency;
        this.topics = topics;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }
}

@Document
public class User {
    @Id
    private int userId;
    private String userName;
    private String userMail;
    private int age;
    private List<Subscription> subscriptions;
    private Map<String,String> userSetting = new HashMap<>();

    public User() {
    }

    public User(int userId, String userName, String userMail, int age) {
        this.userId = userId;
        this.userName = userName;
        this.userMail = userMail;
        this.age = age;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Map<String, String> getUserSetting() {
        return userSetting;
    }

    public void setUserSetting(Map<String, String> userSetting) {
        this.userSetting = userSetting;
    }
}
