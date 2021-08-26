package com.amareshasp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Subscription{
    private String agency;
    private List<String> channel;

    public Subscription() {
    }

    public Subscription(String agency, List<String> channel) {
        this.agency = agency;
        this.channel = channel;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public List<String> getChannel() {
        return channel;
    }

    public void setChannel(List<String> channel) {
        this.channel = channel;
    }
}

@Document
public class User {
    @Id
    private String userId;
    private String userName;
    private String userMail;
    private int age;
    private List<Subscription> subscriptions;
    private Map<String,String> userSetting = new HashMap<>();

    public User() {
    }

    public User(String userId, String userName, String userMail, int age) {
        this.userId = userId;
        this.userName = userName;
        this.userMail = userMail;
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userMail='" + userMail + '\'' +
                ", age=" + age +
                ", subscriptions=" + subscriptions +
                ", userSetting=" + userSetting +
                '}';
    }
}
