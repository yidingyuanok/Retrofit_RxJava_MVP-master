package com.example.demo.bean;

/**
 * Created by Turing on 2017/5/3.
 */

public class Token {

    /**
     * access_token : ea2e0e2432903abddde0e39574fd9l41
     * id : 9359
     * refresh_token : 22a4b316d8e044926155aa2d4386l7397115f0d6c1d726ed7297a170
     * status : true
     */

    private String access_token;
    private int id;
    private String refresh_token;
    private boolean status;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public boolean isStatus() {
        return status;
    }



    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Token{" +
                "access_token='" + access_token + '\'' +
                ", id=" + id +
                ", refresh_token='" + refresh_token + '\'' +
                ", status=" + status +
                '}';
    }
}
