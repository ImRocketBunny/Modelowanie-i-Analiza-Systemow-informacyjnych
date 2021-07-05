package xor;

public class Kupno {
   private Samochod samochod;
   private Double cena;

    public Samochod getSamochod() {
        return samochod;
    }

    public void setSamochod(Samochod samochod) {
        this.samochod = samochod;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Kupno(Samochod samochod, Double cena) {
        this.samochod = samochod;
        this.cena = cena;
    }
}
