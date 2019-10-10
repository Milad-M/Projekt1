package com.example;

public class KlubbInfo extends Lag {

    private String telefonNummer;
    private String email;

    public KlubbInfo(String namn, String smekNamn, String telefonNummer, String email) {
        super(namn, smekNamn);
        this.telefonNummer = telefonNummer;
        this.email = email;
    }

    public String getTelefonNummer() {
        return telefonNummer;
    }

    public String getEmail() {
        return email;
    }

    public static KlubbInfo createKlubbInfo(String namn, String smekNamn, String telefonNummer, String email) { return new KlubbInfo(namn, smekNamn, telefonNummer, email);}



}




