package com.example.pank_java.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Pank {
    //List kus on kõik kontod
    private List<Kasutaja> kasutajaList;

    //Konstruktor
    public Pank(List<Konto> kontodeList) {
        this.kasutajaList = new ArrayList<>();
    }

    public Kasutaja lisaKasutaja(String nimi, String parool1, String parool2) {
        if(!nimi.isEmpty()) {
            if(parool1.equals(parool2)) {
                Kasutaja kasutaja = new Kasutaja(nimi, parool1);
                kasutajaList.add(kasutaja);
                return kasutaja;
            }
        }
        return null;
    }
    /**
     * Meetod logib kasutajasse sisse.
     * @param nimi konto nimi
     * @param parool konto parool
     * @return tagastab konto, kuhu sisse logiti
     */
    public Kasutaja logiSisse(String nimi, String parool) {

        for(Kasutaja kasutaja: kasutajaList) {
            if(nimi.equalsIgnoreCase(kasutaja.getKasutajaNimi())) {
                if (parool.equals(kasutaja.getParool())) {
                    System.out.println("Edukalt sisse logitud");
                    return kasutaja;
                } else {
                    System.out.println("Vale parool");
                    return null;
                }
            }
        }

        System.out.println("Sellist kontot ei leitud");
        return null;
    }


    /**
     * Meetod kuvab ekraanile kõik hetkel tehtud kontod.
     */

    public void kuvaKontod(){
        //SEE IF STATEMENT EI TÖÖTA????
        if (kasutajaList.isEmpty()) {
            System.out.println("Hetkel pole veel ühtegi kontot loodud");
        }
        else {
            System.out.println("Hetkel loodud kontod on:");
            for(Kasutaja kasutaja: kasutajaList){
                System.out.println(kasutaja);
            }
        }
    }

    public List<Kasutaja> getKasutajaList(){
        return kasutajaList;
    }

    public String unustasinParooli(){
        return "Konto.getParool();";
    }


}
