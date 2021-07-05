package wieloaspektowe;

public class Osobowy extends Samochod{
    private Integer liczbaMiejsc;

    public Integer getLiczbaMiejsc() {
        return liczbaMiejsc;
    }

    public void setLiczbaMiejsc(Integer liczbaMiejsc) {
        this.liczbaMiejsc = liczbaMiejsc;
    }

    public Osobowy(String marka, String model, String nrRejestracyjny, Enum<samochodUzytkowanie> sposobNabycia, Integer liczbaMiejsc) {
        super(marka, model, nrRejestracyjny, sposobNabycia);
        this.liczbaMiejsc = liczbaMiejsc;
    }
}
