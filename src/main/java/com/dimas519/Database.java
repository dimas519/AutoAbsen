package com.dimas519;

import com.dimas519.Model.DBModel;
import com.dimas519.Model.Kuliah;
import com.dimas519.Tools.Waktu;
import org.checkerframework.checker.units.qual.K;

import java.sql.*;


public class Database {
    private Connection db;
    private DBModel models;

    public Database(DBModel models){
        this.models=models;
        this.getConnect();
    }

    private void getConnect(){
        try {
            this.db= DriverManager.getConnection(
                    "jdbc:mysql://localhost:"+this.models.getPort()+"/"+this.models.getDataBaseName(),
                    this.models.getUsername(),this.models.getPassword());
        } catch (SQLException e) {
            System.out.println("fail connect db");
        }
    }
    public Kuliah getNextTime(int hari, String jam){
        String query="SELECT * FROM kuliah";
        query+=" WHERE fkHari = "+hari;
        query+=" AND Waktu >= '"+jam+"'";
        query+=" LIMIT 1";
        Kuliah next=_getNextTime(query);
        return  next;
    }

    private Kuliah _getNextTime(String query){
        try {
            Statement statement=this.db.createStatement();
            ResultSet set=statement.executeQuery(query);
            set.next();
            int hari=set.getInt(1);
            String matkul=set.getString(2);
            Time waktu=set.getTime(3);
            boolean role=set.getBoolean(4);
            long waktuKuliah= Waktu.getTime(waktu.toString());
            Kuliah next=new Kuliah(hari,matkul,waktuKuliah,role);
            return next;
        } catch (SQLException e) {
            Kuliah none=new Kuliah(-1,"End of Day",Waktu.MIDNIGHT,false);
            return none;
        }


    }



}
