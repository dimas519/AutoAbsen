package com.dimas519.Tools;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logging {
    String filePath;
    public Logging(String filePathlogging){
        this.filePath=filePathlogging;
    }



    public void write(String x) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(this.filePath, true));
            writer.println("["+Waktu.getTimeNow()+"]"+x);
            writer.close();
        } catch (IOException e) {
            Tray.printError("Error write:"+e.getMessage());
        }
    }
}
