package com.example.pank_java.java;

public class PensionaariKonto extends Konto {

    private int vanus;

    public PensionaariKonto(String kontoNumber,int vanus, String kontoOmanik, String parool, double summaKontol) {
        super(kontoNumber, kontoOmanik, parool, summaKontol);
        this.vanus = vanus;
    }

    @Override
    public String toString() {
        return "Pensionäri " + super.toString();
    }
}
