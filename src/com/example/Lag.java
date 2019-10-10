package com.example;

public class Lag {
    private String namn;
    private  String smekNamn;

    public Lag (String namn,String smekNamn) {
        this.namn = namn;
        this.smekNamn = smekNamn;
    }
    public String getNamn(){
        return namn;
    }
    public String getSmekNamn(){
        return smekNamn;
    }
    public static Lag createLag(String namn, String smekNamn){
        return new Lag(namn, smekNamn);
    }
}
