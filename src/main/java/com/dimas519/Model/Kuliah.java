package com.dimas519.Model;



public class Kuliah {
    private int hari=-1;
    private String mata_Kuliah;
    private Long jam;
    private Boolean isLecture;

    public Kuliah(int hari, String mata_Kuliah, Long jam, Boolean isLecture) {
        this.hari = hari;
        this.mata_Kuliah = mata_Kuliah;
        this.jam = jam;
        this.isLecture = isLecture;
    }

    public int getHari() {
        return hari;
    }

    public String getMata_Kuliah() {
        return mata_Kuliah;
    }

    public Long getJam() {
        return jam;
    }

    public Boolean getisLecture() {
        return isLecture;
    }
}
