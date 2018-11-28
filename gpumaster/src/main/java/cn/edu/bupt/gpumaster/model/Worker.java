package cn.edu.bupt.gpumaster.model;

import java.io.Serializable;

public class Worker implements Serializable {

    private String ip;
    private int port=8080;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
