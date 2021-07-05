package xor;

public class Leasing {
    private Samochod samochod;
    private Double rata;

    public Samochod getSamochod() {
        return samochod;
    }

    public void setSamochod(Samochod samochod) {
        this.samochod = samochod;
    }

    public Double getRata() {
        return rata;
    }

    public void setRata(Double rata) {
        this.rata = rata;
    }

    public Leasing(Samochod samochod, Double rata) {
        this.samochod = samochod;
        this.rata = rata;
    }
}
