package wieloaspektowe;

import java.util.Optional;


public abstract class Samochod {

    public enum samochodUzytkowanie {WLASNOSC,LEASING};
    private String marka;
    private String model;
    private String nrRejestracyjny;
    private Enum<samochodUzytkowanie> sposobNabycia;
    private Optional<Double> rataLeasigowa = Optional.empty();
    private Optional<Double> cenaZakupu = Optional.empty();

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNrRejestracyjny() {
        return nrRejestracyjny;
    }

    public void setNrRejestracyjny(String nrRejestracyjny) {
        this.nrRejestracyjny = nrRejestracyjny;
    }

    public Enum<samochodUzytkowanie> getSposobNabycia() {
        return sposobNabycia;
    }

    public void setSposobNabycia(Enum<samochodUzytkowanie> sposobNabycia) {
        this.sposobNabycia = sposobNabycia;
    }

    public Optional<Double> getRataLeasigowa() throws Exception {
        if(this.getSposobNabycia()==(samochodUzytkowanie.LEASING))
            return rataLeasigowa;

        throw new Exception("To nie jest auto na leasing");

    }

    public void setRataLeasigowa(Optional<Double> rataLeasigowa) throws Exception {
        if (this.getSposobNabycia()==(samochodUzytkowanie.LEASING)) {
            this.rataLeasigowa = rataLeasigowa;
            return;
        }


        throw new Exception("To nie jest auto na leasing");
    }

    public Optional<Double> getCenaZakupu() throws Exception {
        if(this.getSposobNabycia()==(samochodUzytkowanie.WLASNOSC))
            return cenaZakupu;

        throw new Exception("To nie jest auto do kupienia");
    }

    public void setCenaZakupu(Optional<Double> cenaZakupu) throws Exception {
        if (this.getSposobNabycia()==samochodUzytkowanie.WLASNOSC){
            this.cenaZakupu = cenaZakupu;
            return;
        }

        throw new Exception("To nie jest auto do kupienia");
    }

    public Samochod(String marka, String model, String nrRejestracyjny, Enum<samochodUzytkowanie> sposobNabycia) {
        this.marka = marka;
        this.model = model;
        this.nrRejestracyjny = nrRejestracyjny;
        this.sposobNabycia = sposobNabycia;
    }
}
