package com.example.pank_java.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Pank {
    //List kus on kõik kontod
    private List<Konto> kontodeList;

    //Konstruktor
    public Pank(List<Konto> kontodeList) {
        this.kontodeList = new ArrayList<>();
    }

    /**
     * Meetod logib kontosse sisse.
     * @param nimi konto nimi
     * @param parool konto parool
     * @return tagastab konto, kuhu sisse logiti
     */
    public Konto logiSisse(String nimi, String parool) {

        for(Konto konto: kontodeList) {
            if(nimi.equalsIgnoreCase(konto.getKontoOmanik())) {
                if (parool.equals(konto.getParool())) {
                    System.out.println("Edukalt sisse logitud");
                    return konto;
                } else {
                    System.out.println("Vale parool");
                    return null;
                }
            }
        }

        System.out.println("Sellist kontot ei leitud");
        return null;
    }

    //Lisa Konto meetod
    public List<Konto> lisaKonto(String omanikuNimi, String parool, int vanus) {

        // Siis on mul on vaja randomly genereerida konto number
        int miinimum = 10000000;
        int max = 99999999;
        Random random = new Random();
        int kontoNumber = random.nextInt((max - miinimum) + 1) + miinimum;

        //Kui vanus väiksem, kui 18 loome noorukikonto, kui vanus alla 65 loome tava konto, muidu loome pensionäri konto
        if (vanus < 18) {
            Noorukikonto uusKonto = new Noorukikonto(kontoNumber, vanus, omanikuNimi, parool, 0.0, null);
            kontodeList.add(uusKonto);
        } else if(vanus <= 65) {
            Konto uusKonto = new Konto(kontoNumber, omanikuNimi, parool, 0.0, null);
            kontodeList.add(uusKonto);
        } else {
            PensionaariKonto uusKonto = new PensionaariKonto(kontoNumber, vanus, omanikuNimi, parool, 0.0, null);
            kontodeList.add(uusKonto);
        }

        return kontodeList;
    }

    /**
     * Meetod kuvab ekraanile kõik hetkel tehtud kontod.
     */

    public void kuvaKontod(){
        //SEE IF STATEMENT EI TÖÖTA????
        if (kontodeList.isEmpty()) {
            System.out.println("Hetkel pole veel ühtegi kontot loodud");
        }
        else {
            System.out.println("Hetkel loodud kontod on:");
            for(Konto konto: kontodeList){
                System.out.println(konto);
            }
        }
    }

    public List<Konto> getKontod(){
        return kontodeList;
    }

    /**
     * meetodiga saab lisada raha mingile kindlale kontole pangas.
     * @param summa lisatav summa
     * @param kontoNumber kontonumber, kuhu summa lisatakse
     */
    public void lisaRahaKontole(double summa, int kontoNumber) {
        boolean kasLeitiKonto = false;
        for(Konto vaadeldav : kontodeList){
            if(vaadeldav.getKontoNumber() == kontoNumber) {
                kasLeitiKonto = true;
                vaadeldav.sisestaKontole(summa);
            }
        }

        if(!kasLeitiKonto) {
            System.out.println("Kontot sisestatud kontonumbriga ei leitud");
        }

    }

    public String unustasinParooli(){
        return "Konto.getParool();";
    }


}
