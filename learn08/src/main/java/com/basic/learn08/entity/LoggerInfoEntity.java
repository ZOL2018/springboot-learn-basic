package com.basic.learn08.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "logger_info")
public class LoggerInfoEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "client_ip")
    private String clientIp;
    @Column(name = "url")
    private String url;
    @Column(name = "type")
    private String type;
    @Column(name = "method")
    private String method;
    @Column(name = "param_data")
    private String paramData;
    @Column(name = "session_id")
    private String sessionId;
    @Column(name = "time",insertable = false)
    private Timestamp time;
    @Column(name = "r_time")
    private String rTime;
    @Column(name = "r_data")
    private String rData;
    @Column(name = "http_status_code")
    private String httpStatusCode;
    @Column(name = "time_consuming")
    private int timeConsuming;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getrTime() {
        return rTime;
    }

    public void setrTime(String rTime) {
        this.rTime = rTime;
    }

    public String getrData() {
        return rData;
    }

    public void setrData(String rData) {
        this.rData = rData;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public int getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(int timeConsuming) {
        this.timeConsuming = timeConsuming;
    }
}
