package com.dimas519.Model;

public class DBModel {
    private String dataBaseName;
    private String port;
    private String Username;
    private String password;



    public DBModel( String port, String username, String password,String dataBaseName) {
        this.dataBaseName = dataBaseName;
        this.port = port;
        this.Username = username;
        if(!password.equals("empty")) {
            this.password = password;
        }else{
            this.password="";
        }

    }

    public String getDataBaseName() {
        return dataBaseName;
    }

    public String getPort() {
        return port;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return password;
    }

}
