package com.example.pank_java.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kasutaja {

    private String kasutajaNimi;
    private String parool;
    private int vanus;
    private List<Konto> kontodeList;

    public Kasutaja(String kasutajaNimi, String parool, int vanus) {
        this.kasutajaNimi = kasutajaNimi;
        this.parool = parool;
        this.vanus = vanus;
        this.kontodeList = new ArrayList<>();
    }

    public String getKasutajaNimi() {
        return kasutajaNimi;
    }

    public String getParool() {
        return parool;
    }

    // lisaKonto meetod
    public List<Konto> lisaKonto(String omanikuNimi, String parool) {
        if(kontodeList.size() >= 5) {
            return kontodeList;
        }
        // Siis on mul on vaja randomly genereerida konto number
        long miinimum = 1000000000;
        long max = 9999999999L;
        Random random = new Random();
        String kontoNumber = "EE" + 21 + 6969 +  String.valueOf(random.nextLong((max - miinimum) + 1) + miinimum);

        //Kui vanus väiksem, kui 18 loome noorukikonto, kui vanus alla 65 loome tava konto, muidu loome pensionäri konto
        if (vanus < 18) {
            Noorukikonto uusKonto = new Noorukikonto(kontoNumber, vanus, omanikuNimi, parool, 0.0);
            kontodeList.add(uusKonto);
        } else if(vanus <= 65) {
            Konto uusKonto = new Konto(kontoNumber, omanikuNimi, parool, 0.0);
            kontodeList.add(uusKonto);
        } else {
            PensionaariKonto uusKonto = new PensionaariKonto(kontoNumber, vanus, omanikuNimi, parool, 0.0);
            kontodeList.add(uusKonto);
        }

        return kontodeList;
    }

    //lisa konto meetod failist sisse lugedes.
    public List<Konto> lisaKonto(String omanikuNimi,String kontoNumber ,String parool) {
        if(kontodeList.size() >= 5) {
            return kontodeList;
        }
        //Kui vanus väiksem, kui 18 loome noorukikonto, kui vanus alla 65 loome tava konto, muidu loome pensionäri konto
        if (vanus < 18) {
            Noorukikonto uusKonto = new Noorukikonto(kontoNumber, vanus, omanikuNimi, parool, 0.0);
            kontodeList.add(uusKonto);
        } else if(vanus <= 65) {
            Konto uusKonto = new Konto(kontoNumber, omanikuNimi, parool, 0.0);
            kontodeList.add(uusKonto);
        } else {
            PensionaariKonto uusKonto = new PensionaariKonto(kontoNumber, vanus, omanikuNimi, parool, 0.0);
            kontodeList.add(uusKonto);
        }

        return kontodeList;
    }

    public List<Konto> getKontoList() {
        return kontodeList;
    }
    public Integer getVanus() {
        return vanus;
    }

    @Override
    public String toString() {
        return "Kasutaja: " + kasutajaNimi + "Parool: " + parool + "Kontod: \n " + kontodeList;
    }
}
