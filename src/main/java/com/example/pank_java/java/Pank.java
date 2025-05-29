package com.example.pank_java.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pank {
    private List<Kasutaja> kasutajaList = new ArrayList<>();
    private Kasutaja praeguneKasutaja;

    public Pank(List<Kasutaja> kasutajaList) {
        this.kasutajaList = kasutajaList;
    }

    public Pank() { }

    public Kasutaja lisaKasutaja(String nimi, String parool1, String parool2, int vanus) {
        if (nimi == null || nimi.isBlank()) return null;
        if (!parool1.equals(parool2))             return null;
        Kasutaja u = new Kasutaja(nimi, parool1, vanus);
        kasutajaList.add(u);
        return u;
    }

    // kasutaja lisamise meetod failist lugedes
    public void lisaKasutaja(Kasutaja kasutaja) {
        kasutajaList.add(kasutaja);
    }

    public Kasutaja logiSisse(String nimi, String parool) {
        for (Kasutaja k : kasutajaList) {
            if (k.getKasutajaNimi().equals(nimi)
                    && k.getParool().equals(parool)) {
                praeguneKasutaja = k;
                return k;
            }
        }
        return null;
    }

    public Kasutaja getPraeguneKasutaja() {
        return praeguneKasutaja;
    }

    /**
     * Loo uus konto seesolevale kasutajale.
     * @param algSumma  esialgne saldo kontole
     */
    public Konto looKonto(double algSumma) {
        if (praeguneKasutaja == null) {
            throw new IllegalStateException("Pole ühtegi sisse logitud kasutajat");
        }

        // Kasutaja.lisaKonto sisestab õige Konto alamklassi ja tagastab terve nimekirja
        List<Konto> kontod = praeguneKasutaja.lisaKonto(
                praeguneKasutaja.getKasutajaNimi(),
                praeguneKasutaja.getParool()
        );
        Konto uus = kontod.get(kontod.size() - 1);
        if (algSumma > 0) {
            uus.sisestaKontole(algSumma);
        } else {
            uus.sisestaKontole(0);
        }

        return uus;
    }

    //loo konto meetod failist sisselugemisel
    public Konto looKonto(Kasutaja praegune, String kontoNr ,double algSumma) {
        if (praegune == null) {
            throw new IllegalStateException("Pole ühtegi sisse logitud kasutajat");
        }

        // Kasutaja.lisaKonto sisestab õige Konto alamklassi ja tagastab terve nimekirja
        List<Konto> kontod = praegune.lisaKonto(
                praegune.getKasutajaNimi(),
                kontoNr,
                praegune.getParool()
        );
        Konto uus = kontod.get(kontod.size() - 1);
        if (algSumma > 0) {
            uus.sisestaKontole(algSumma);
        }
        return uus;
    }

    public List<Kasutaja> getKasutajaList() {
        return kasutajaList;
    }

}
