package com.ycw.photosystem.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by liuyang on 2016/11/7 0007.
 */
@Entity
public class Request {
    private int id;
    private int requestUser;
    private String requestMsg;
    private Byte isChecked;
    private Timestamp requestTime;
    private Timestamp responseTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "request_user")
    public int getRequestUser() {
        return requestUser;
    }

    public void setRequestUser(int requestUser) {
        this.requestUser = requestUser;
    }

    @Basic
    @Column(name = "request_msg")
    public String getRequestMsg() {
        return requestMsg;
    }

    public void setRequestMsg(String requestMsg) {
        this.requestMsg = requestMsg;
    }

    @Basic
    @Column(name = "is_checked")
    public Byte getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Byte isChecked) {
        this.isChecked = isChecked;
    }

    @Basic
    @Column(name = "request_time")
    public Timestamp getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Timestamp requestTime) {
        this.requestTime = requestTime;
    }

    @Basic
    @Column(name = "response_time")
    public Timestamp getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Timestamp responseTime) {
        this.responseTime = responseTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (id != request.id) return false;
        if (requestUser != request.requestUser) return false;
        if (requestMsg != null ? !requestMsg.equals(request.requestMsg) : request.requestMsg != null) return false;
        if (isChecked != null ? !isChecked.equals(request.isChecked) : request.isChecked != null) return false;
        if (requestTime != null ? !requestTime.equals(request.requestTime) : request.requestTime != null) return false;
        if (responseTime != null ? !responseTime.equals(request.responseTime) : request.responseTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + requestUser;
        result = 31 * result + (requestMsg != null ? requestMsg.hashCode() : 0);
        result = 31 * result + (isChecked != null ? isChecked.hashCode() : 0);
        result = 31 * result + (requestTime != null ? requestTime.hashCode() : 0);
        result = 31 * result + (responseTime != null ? responseTime.hashCode() : 0);
        return result;
    }
}
