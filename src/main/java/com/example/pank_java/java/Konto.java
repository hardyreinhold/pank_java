package com.example.pank_java.java;

public class Konto {

    private String kontoNumber;
    private String kontoOmanik;
    private String parool;
    private double summaKontol;
    private Pank pank;

    public Konto(String kontoNumber, String kontoOmanik, String parool, double summaKontol) {
        this.kontoNumber = kontoNumber;
        this.kontoOmanik = kontoOmanik;
        this.parool = parool;
        this.summaKontol = summaKontol;
    }

    public void sisestaKontole(double kontoleSisestada) {
        summaKontol += kontoleSisestada;
    }

    /**
     * meetodiga saab kontolt lahutada summa
     * @param summa lahutatav summa
     */

    public void lahutaKontolt(double summa) {
        if(summa > summaKontol) {
            throw new RahaPolePiisavalt("Kontol pole piisavalt raha!");
        };
        summaKontol -= summa;
    }

    public void setPank(Pank pank) {
        this.pank = pank;
    }

    //GET MEETODID

    public String getKontoNumber() {
        return kontoNumber;
    }

    public String getKontoOmanik() {
        return kontoOmanik;
    }

    public String getParool() {
        return parool;
    }

    public Pank getPank() {
        return pank;
    }

    public double getSummaKontol() {
        return summaKontol;
    }

    @Override
    public String toString() {
        return "kontoNumber=" + kontoNumber + ", summaKontol=" + summaKontol;
    }
}
