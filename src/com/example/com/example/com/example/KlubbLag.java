package com.example.com.example.com.example;

import com.example.KlubbInfo;
import com.example.Lag;
import com.example.com.example.Stad;

import java.util.ArrayList;

/**
 *  I den här klassen har jag hand om min Arraylist för "Lag"
 *  Programmet hanterar lag för ett klubblag
 *  Man kan visa klubbinfo, spara, visa, uppdatera, och ta bort ett lags namn och smeknamn.
 *  Det finns en egen klass för lag "Lag.java" (namn och smeknamn).
 *  Den här klassen har hand om all funktionalitet ovan.
  */

public class KlubbLag {
    private String lagNamn;

    private ArrayList<KlubbInfo> mittLag;

    /**Konstruktor */
    public KlubbLag() {
        this.mittLag = new ArrayList<KlubbInfo>();
    }

    /** Metod som lägger till nytt lag */
    public boolean addNewLag(KlubbInfo klubbInfo) {
        if (findLag(klubbInfo.getNamn()) >= 0) {
            System.out.println("Laget är redan sparad.");
            return false;
        }

        /** lägger till klubbinfo till ett lag */
        mittLag.add(klubbInfo);
        return true;

    }

 /** Uppdaterar ett lag */
    public boolean updateLag(KlubbInfo oldKlubbInfo, KlubbInfo newKlubbInfo) {
        int foundPosition = findLag(oldKlubbInfo);
        if (foundPosition < 0) {
            System.out.println(oldKlubbInfo.getNamn() + ", gick inte att hitta.");
            return false;
        }

        this.mittLag.set(foundPosition, newKlubbInfo);
        System.out.println(oldKlubbInfo.getNamn() + ", har uppdaterats med " + newKlubbInfo.getNamn());
        return true;
    }

/** Raderar ett lag */
    public boolean removeLag(KlubbInfo klubbInfo) {
        int foundPosition = findLag(klubbInfo);
        if (foundPosition < 0) {
            System.out.println(klubbInfo.getNamn() + ", gick inte att hitta.");
            return false;
        }
        this.mittLag.remove(foundPosition);
        System.out.println(klubbInfo.getNamn() + ", har tagits bort.");
        return true;
    }

/** Söker efter ett lag och matar ut text om laget hittats */
    private int findLag(KlubbInfo klubbInfo) {
        return this.mittLag.indexOf(klubbInfo);
    }

    /**Overload av metoden findlag dvs man använder samma metod med olika parametrar */
    private int findLag(String lagNamn) {
        for (int i = 0; i < this.mittLag.size(); i++) {
            Lag lag = this.mittLag.get(i);
            if (lag.getNamn().equals(lagNamn)) {
                return i;
            }
        }

        return -1;
    }


    public String queryLag(KlubbInfo klubbInfo) {
        if (findLag(klubbInfo) >= 0) {
            return klubbInfo.getNamn();
        }
        return null;
    }

    public KlubbInfo queryLag(String namn) { // Vi returnerar Lag (ett objekt))
        int position = findLag(namn);
        if (position >= 0) {
            return this.mittLag.get(position);
        }

        return null;
    }

    public void printLag() {
        System.out.println("Lag-listan");
        for (int i = 0; i < this.mittLag.size(); i++) {
            System.out.println((i + 1) + "." +
                    this.mittLag.get(i).getNamn() + " -> " +
                    this.mittLag.get(i).getSmekNamn());
        }
    }

    public void printKlubbInfo() {
        System.out.println("Visar info:");
        for (int i = 0; i < this.mittLag.size(); i++) {
            System.out.println((i + 1) + "." + " Namn: " +
                    this.mittLag.get(i).getNamn() + ", " + "Smeknamn: " +
                    this.mittLag.get(i).getSmekNamn() + " " + "Telefon: " +
                    this.mittLag.get(i).getTelefonNummer() + " " + "Email: " +
                    this.mittLag.get(i).getEmail());
        }

    }
}



