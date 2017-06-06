package com.example.demo.bean;

/**
 * Created by Turing on 2017/5/3.
 */

public class User {


    /**
     * access_token : ea2e0e2432903abddde0e39574fd9l41
     * account : yidingyuan
     * domain : yidingyuan
     * email : yidingyuanok@163.com
     * gender : 1
     * id : 9359
     * integral : 0
     * isemail : 0
     * isphone : 0
     * status : true
     * time : 1493797429000
     * title :
     * weiboid : 0
     */

    private String access_token;
    private String account;
    private String domain;
    private String email;
    private int gender;
    private int id;
    private int integral;
    private int isemail;
    private int isphone;
    private boolean status;
    private long time;
    private String title;
    private int weiboid;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getIsemail() {
        return isemail;
    }

    public void setIsemail(int isemail) {
        this.isemail = isemail;
    }

    public int getIsphone() {
        return isphone;
    }

    public void setIsphone(int isphone) {
        this.isphone = isphone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWeiboid() {
        return weiboid;
    }

    public void setWeiboid(int weiboid) {
        this.weiboid = weiboid;
    }

    @Override
    public String toString() {
        return "User{" +
                "access_token='" + access_token + '\'' +
                ", account='" + account + '\'' +
                ", domain='" + domain + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", id=" + id +
                ", integral=" + integral +
                ", isemail=" + isemail +
                ", isphone=" + isphone +
                ", status=" + status +
                ", time=" + time +
                ", title='" + title + '\'' +
                ", weiboid=" + weiboid +
                '}';
    }
}
