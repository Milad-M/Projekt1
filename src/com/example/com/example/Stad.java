package com.example.com.example;

import com.example.KlubbInfo;
import com.example.Lag;
import com.example.com.example.com.example.KlubbLag;

import java.util.Scanner;

/**
 * Jag har en meny i mainklassen (den med static void main)
 * Alternativ i menyn: Visa klubbinfo,  Quit, Visa listan med lag, Lägg till ett nytt lag, Uppdatera ett befintligt lag, Ta bort ett lag, söka efter ett nytt lag.
 * När man lägger till eller uppdaterar ett lag kontrollerar programmet om laget redan finns.

 * @author  Milad Mehrbeheshti
 * @version 1.0
 * @since 2019-10-09
 */


public class Stad  {


    private static Scanner scanner = new Scanner(System.in);
    private static KlubbLag klubbLag = new KlubbLag(); // skapar ett objekt av Klubblag klassen som bara är åtkomlig i denna klassen

    public static void main(String[] args) {

        boolean quit = false;
        startLag();
        printActions();

        while (!quit) {
           System.out.println("\nVälj (6 för att visa val):");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nStänger ner..");
                    quit = true;
                    break;

                case 1:
                    klubbLag.printLag();
                    break;

                case 2:
                    addNewLag();
                    break;

                case 3:
                    updateLag();
                    break;

                case 4:
                    removeLag();
                    break;

                case 5:
                    queryLag();
                    break;

                case 6:
                    printActions();
                    break;

                case 7:
                    klubbLag.printKlubbInfo();
                    break;

            }
        }
    }


    /** Metod för användaren att lägga till nytt lag och som söker ifall laget redan finns eller inte och baserat på det matar den ut en text */
    private static void addNewLag() {
        System.out.println("Skriv in namnet på ditt lag: ");
        String namn = scanner.nextLine();
        System.out.println("Ange det smeknamn ditt lag ska få: ");
        String smekNamn = scanner.nextLine();
        System.out.println("Skriv telefonnumret till din klubb: ");
        String telefonNummer = scanner.nextLine();
        System.out.println("Skriv in din klubbs emailadress: ");
        String email = scanner.nextLine();
       // Lag newLag = new Lag(namn,lag);
        KlubbInfo newLag = KlubbInfo.createKlubbInfo(namn, smekNamn, telefonNummer, email); //Vi skapar ett objekt direkt där vi kommer åt metoden createLag i Lag klassen
        if (klubbLag.addNewLag(newLag)) {
            System.out.println("Nytt lag tillagd: Namn: " + namn + ", Smeknamn: " + smekNamn);
        }else{
            System.out.println("Kan inte lägga till, " + namn + " finns redan.");
        }
    }

    /** En metod som gör att användaren kan uppdatera ett befintligt lag */
    private static void updateLag() {
        System.out.println("Skriv in namnet på laget som skall uppdateras: ");
        String namn = scanner.nextLine();
        Lag existingKlubbInfoRecord = klubbLag.queryLag(namn);
        if(existingKlubbInfoRecord == null) {
            System.out.println("Kan inte hitta laget.");
            return;
        }

        System.out.print("Skriv in det nya namnet för laget: ");
        String newName = scanner.nextLine();
        System.out.println("Skriv in nytt smeknamn för laget");
        String newNick = scanner.nextLine();
        System.out.println("Skriv telefonnumret till din klubb: ");
        String newTelefonNummer = scanner.nextLine();
        System.out.println("Skriv in din klubbs emailadress: ");
        String newEmail = scanner.nextLine();
        KlubbInfo newKlubbInfo = KlubbInfo.createKlubbInfo(newName, newNick, newTelefonNummer, newEmail);
        if(klubbLag.updateLag((KlubbInfo)existingKlubbInfoRecord, newKlubbInfo)) {
            System.out.println("Laget är uppdaterat!");
        }else {
            System.out.println("Gick inte att uppdatera.");
        }
    }

    /** Metod för användaren så man kan radera ett lag */
    private static void removeLag() {
        System.out.println("Skriv in namnet på laget som ska raderas: ");
        String namn = scanner.nextLine();
        Lag existingKlubbInfoRecord = klubbLag.queryLag(namn);
        if (existingKlubbInfoRecord == null) {
            System.out.println("Kan inte hitta laget.");
            return;
        }

        if (klubbLag.removeLag((KlubbInfo)existingKlubbInfoRecord)) {
            System.out.println("Laget har raderats!");
        }else {
            System.out.println("Kan inte radera laget.");
        }
    }

    /** Metod som gör att användaren kan söka efter laget vars namn man skrivit in */
    private static void queryLag() {
        System.out.println("Skriv in namnet på laget: ");
        String namn = scanner.nextLine();
        Lag existingLagRecord = klubbLag.queryLag(namn);
        if (existingLagRecord == null) {
            System.out.println("Kan inte hitta laget.");
            return;
        }

        System.out.println("Namn: " + existingLagRecord.getNamn() + " smeknamnet är " + existingLagRecord.getSmekNamn());
    }

    /*private static void KlubbInfo() {
        System.out.println(KlubbInfo);
    }*/

    private static void startLag()
    { System.out.println("Startar laget..."); }

    /** Skriver ut val listan */
    private static void printActions(){
        System.out.println("\nVälj: \n");
        System.out.println("0  - Stäng av\n" +
                "1  - Visa alla lag\n" +
                "2  - Lägg till nytt lag\n" +
                "3  - Uppdatera ett inlagt lag\n" +
                "4  - Ta bort ett inlagt lag\n" +
                "5  - Söka efter ett inlagt lag\n" +
                "6  - Visa en lista över alla val.\n" +
                "7  - Visa klubbinfo\n");

    }

    }

