package com.dimas519.Tools;

import com.dimas519.MainInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Tray {
    private SystemTray tray;
    private static TrayIcon trayIcon;
    private static Logging log;
    private MainInterface mi;
    public Tray(String ssDir, String logFile, String icon, MainInterface mi) {
        try {
            this.tray = SystemTray.getSystemTray();
            this.mi=mi;
            Image image = Toolkit.getDefaultToolkit().getImage(icon);
            this.trayIcon = new TrayIcon(image, "Auto Absen");
            this.trayIcon.setImageAutoSize(true);
            this.trayIcon.setToolTip("Auto Absen");
            this.trayIcon.setImageAutoSize(true);
            this.tray.add(this.trayIcon);

            PopupMenu ppm=new PopupMenu();
            this.setAction(ppm);
            this.setOpenDirFolder(ppm,ssDir);
            this.setExit(ppm);




            this.trayIcon.setPopupMenu(ppm);

            this.log=new Logging(logFile);
            this.log.write("------------------------------------------------------------");
            this.log.write(Waktu.getDate()+" - "+Waktu.getTimeNow());


        } catch (AWTException e) {
            System.err.println("System tray not supported!");
        }
    }

    public static void printInfo(String text){
        log.write("info: "+text);
        trayIcon.displayMessage("Auto Absen", text, TrayIcon.MessageType.INFO );
    }

    public static void printError(String text){
        log.write("ERROR: "+text);
        trayIcon.displayMessage("Auto Absen", text, TrayIcon.MessageType.ERROR );
    }

    public static void printNone(String text){
        log.write("none: "+text);
        trayIcon.displayMessage("Auto Absen", text, TrayIcon.MessageType.NONE );
    }

    public static void printWarning(String text){
        log.write("WARNING: "+text);
        trayIcon.displayMessage("Auto Absen", text, TrayIcon.MessageType.WARNING );

    }

    private void setAction(PopupMenu ppm){
        MenuItem action = new MenuItem("Action");
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Tray.printNone("Version 1.4");
            }
        });
        ppm.add(action);
    }

    private void setOpenDirFolder(PopupMenu ppm,String dir){
        MenuItem action = new MenuItem("Screenshot dir");
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().open(new File(dir));
                } catch (IOException ex) {

                }
            }
        });
        ppm.add(action);
    }

    private void setExit(PopupMenu ppm){
        MenuItem action = new MenuItem("Exit");
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.close();
            }
        });
        ppm.add(action);
    }





}
