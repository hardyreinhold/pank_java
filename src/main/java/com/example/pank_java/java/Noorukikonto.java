package com.example.pank_java.java;

public class Noorukikonto extends Konto{

    private int vanus;

    public Noorukikonto(String kontoNumber,int vanus, String kontoOmanik, String parool, double summaKontol) {
        super(kontoNumber, kontoOmanik, parool, summaKontol);
        this.vanus = vanus;
    }


    @Override
    public String toString() {
        return "Nooruki " + super.toString();
    }

}
