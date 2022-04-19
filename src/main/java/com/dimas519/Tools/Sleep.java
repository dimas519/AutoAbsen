package com.dimas519.Tools;

public class Sleep {
    public static void Sleep(Long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            System.out.println("fail sleep");
        }
    }
}
