package com.solvd.connectionPool;

public class Connection {
    private String url;
    private String user;
    private String password;

    public Connection(){}
    public Connection(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
