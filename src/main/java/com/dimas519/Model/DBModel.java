package com.dimas519.Model;

public class DBModel {
    private String dataBaseName;
    private String port;
    private String Username;
    private String password;
    private String tableName;


    public DBModel( String port, String username, String password,String dataBaseName,String tableName) {
        this.dataBaseName = dataBaseName;
        this.port = port;
        this.Username = username;
        if(!password.equals("empty")) {
            this.password = password;
        }else{
            this.password="";
        }
        this.tableName=tableName;
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

    public String getTableName() {
        return tableName;
    }
}
