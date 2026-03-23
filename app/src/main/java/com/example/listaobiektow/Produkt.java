package com.example.listaobiektow;

public class Produkt {
    private String nazwa;
    private double cena;
    private boolean czyKupione;
    public Produkt(String nazwa, double cena){
        this.nazwa = nazwa;
        this.cena = cena;
        czyKupione = false;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", czyKupione=" + czyKupione +
                '}';
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public boolean isCzyKupione() {
        return czyKupione;
    }

    public void setCzyKupione(boolean czyKupione) {
        this.czyKupione = czyKupione;
    }
}