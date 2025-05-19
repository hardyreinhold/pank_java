package com.example.pank_java.java;

public class Konto {

    private int kontoNumber;
    private String kontoOmanik;
    private String parool;
    private double summaKontol;
    private Pank pank;

    public Konto(int kontoNumber, String kontoOmanik, String parool, double summaKontol, Pank pank) {
        this.kontoNumber = kontoNumber;
        this.kontoOmanik = kontoOmanik;
        this.parool = parool;
        this.summaKontol = summaKontol;
        this.pank = pank;
    }

    public void võttaVälja(double väljaVõetavSumma) {
        if (väljaVõetavSumma > summaKontol) {
            System.out.println("Kontol pole piisavalt raha! Praegune saldo: " + summaKontol + "\n");
        }
        summaKontol -= väljaVõetavSumma;
        System.out.println("Kontole on alles jäänud: " + summaKontol + "\n");
    }

    public void sisestaKontole(double kontoleSisestada) {
        summaKontol += kontoleSisestada;
    }

    /**
     * meetod kannab raha sellelt kontolt teisele
     * @param summa kantav summa
     * @param kontoNumber kontoNr, kuhu summa kantakse
     */

    public void kannaKontole(double summa, int kontoNumber) {
        if(summa > summaKontol) {
            System.out.println("Kontol pole piisavalt raha");
            return;
        };

        pank.lisaRahaKontole(summa, kontoNumber);

        summaKontol -= summa;
        System.out.println("Raha edukalt kantud.");
        System.out.println("Teil on nüüd kontol: " + summaKontol);
        System.out.println();
        System.out.println();
    }

    /**
     * meetodiga saab kontolt lahutada summa
     * @param summa lahutatav summa
     */

    public void lahutaKontolt(double summa) {
        summaKontol -= summa;
    }

    public void setPank(Pank pank) {
        this.pank = pank;
    }

    //GET MEETODID

    public int getKontoNumber() {
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
        return "Konto {" +
                "kontoNumber=" + kontoNumber +
                ", kontoOmanik='" + kontoOmanik + '\'' +
                ", summaKontol=" + summaKontol +
                '}';
    }
}
