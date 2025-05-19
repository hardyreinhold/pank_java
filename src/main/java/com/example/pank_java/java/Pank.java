package com.example.pank_java.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pank {
    private final List<Kasutaja> kasutajaList = new ArrayList<>();
    private Kasutaja praeguneKasutaja;

    public Pank() { }

    public Kasutaja lisaKasutaja(String nimi, String parool1, String parool2) {
        if (nimi == null || nimi.isBlank()) return null;
        if (!parool1.equals(parool2))             return null;
        Kasutaja u = new Kasutaja(nimi, parool1);
        kasutajaList.add(u);
        return u;
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
     * @param vanus     konto omaniku vanus (konto tüüp)
     * @param algSumma  esialgne saldo kontole
     */
    public Konto looKonto(int vanus, double algSumma) {
        if (praeguneKasutaja == null) {
            throw new IllegalStateException("Pole ühtegi sisse logitud kasutajat");
        }

        // Kasutaja.lisaKonto sisestab õige Konto alamklassi ja tagastab terve nimekirja
        List<Konto> kontod = praeguneKasutaja.lisaKonto(
                praeguneKasutaja.getKasutajaNimi(),
                praeguneKasutaja.getParool(),
                vanus
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

    public String unustasinParooli() {
        return "Palun võta ühendust toega.";
    }
}
