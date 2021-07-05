package wieloaspektowe;

public class Ciezarowy extends Samochod {
    private Double ladownosc;

    public Double getLadownosc() {
        return ladownosc;
    }

    public void setLadownosc(Double ladownosc) {
        this.ladownosc = ladownosc;
    }

    public Ciezarowy(String marka, String model, String nrRejestracyjny, Enum<samochodUzytkowanie> sposobNabycia, Double ladownosc) {
        super(marka, model, nrRejestracyjny, sposobNabycia);
        this.ladownosc = ladownosc;
    }
}
