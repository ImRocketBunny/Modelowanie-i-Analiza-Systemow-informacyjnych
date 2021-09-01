package Models;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class KartaGraficzna extends PodzespolKomputerowy{
    private String producentChipsetu;
    private String rodzajChipsetu;
    private Integer taktowanieRdzenia;
    private Integer iloscPamieci;
    private String rodzajPamieci;
    private Integer dlugoscKarty;

    @Basic
    public String getProducentChipsetu() {
        return producentChipsetu;
    }

    public void setProducentChipsetu(String producentChipsetu) {
        this.producentChipsetu = producentChipsetu;
    }
    @Basic
    public String getRodzajChipsetu() {
        return rodzajChipsetu;
    }

    public void setRodzajChipsetu(String rodzajChipsetu) {
        this.rodzajChipsetu = rodzajChipsetu;
    }
    @Basic
    public Integer getTaktowanieRdzenia() {
        return taktowanieRdzenia;
    }

    public void setTaktowanieRdzenia(Integer taktowanieRdzenia) {
        this.taktowanieRdzenia = taktowanieRdzenia;
    }
    @Basic
    public Integer getIloscPamieci() {
        return iloscPamieci;
    }

    public void setIloscPamieci(Integer iloscPamieci) {
        this.iloscPamieci = iloscPamieci;
    }
    @Basic
    public String getRodzajPamieci() {
        return rodzajPamieci;
    }

    public void setRodzajPamieci(String rodzajPamieci) {
        this.rodzajPamieci = rodzajPamieci;
    }
    @Basic
    public Integer getDlugoscKarty() {
        return dlugoscKarty;
    }

    public void setDlugoscKarty(Integer dlugoscKarty) {
        this.dlugoscKarty = dlugoscKarty;
    }

    public KartaGraficzna() {

    }


    public KartaGraficzna(String producent, String kodProducenta, String ean, String nazwa, String typGwarancji, Integer dlugoscGwarancji, Double cena, String producentChipsetu, String rodzajChipsetu, Integer taktowanieRdzenia, Integer iloscPamieci, String rodzajPamieci, Integer dlugoscKarty) {
        super(producent, kodProducenta, ean, nazwa, typGwarancji, dlugoscGwarancji, cena);
        this.producentChipsetu = producentChipsetu;
        this.rodzajChipsetu = rodzajChipsetu;
        this.taktowanieRdzenia = taktowanieRdzenia;
        this.iloscPamieci = iloscPamieci;
        this.rodzajPamieci = rodzajPamieci;
        this.dlugoscKarty = dlugoscKarty;
    }




    @Override
    public String toString() {
        return super.toString()+
                "Producent chipsetu: " + producentChipsetu + '\n' +
                "Rodzaj chipsetu: " + rodzajChipsetu+ '\n' +
                "Taktowanie Rdzenia: " + taktowanieRdzenia + '\n' +
                "Ilosc pamieci: " + iloscPamieci + '\n' +
                "Rodzaj pamieci: " + rodzajPamieci + '\n' +
                "Dlugosc karty: " + dlugoscKarty;
    }

    @Override
    public void dodajPytanie(Pytanie pytanie) throws Exception {
        if(!getPytania().contains(pytanie)){
            getPytania().add(pytanie);
            pytanie.dodajPodzespol(this);
        }
    }
    @Override
    public void usunPytanie(Pytanie pytanie) throws Exception{
        if(getPytania().contains(pytanie)){
            getPytania().remove(pytanie);
            pytanie.usunPodzespol(this);
        }
    }

    @Override
    public void dodajPodzespolWzamowieniu(PodzespolWzamowieniu podzespolWzamowieniu) throws Exception {
        if(!getPodzespolyWzamowieniach().contains(podzespolWzamowieniu)){
            getPodzespolyWzamowieniach().add(podzespolWzamowieniu);
            podzespolWzamowieniu.dodajPodzespol(this);
        }
    }

    @Override
    public void usunPodzespolWzamowieniu(PodzespolWzamowieniu podzespolWzamowieniu) {
        if(getPodzespolyWzamowieniach().contains(podzespolWzamowieniu)){
            getPodzespolyWzamowieniach().remove(podzespolWzamowieniu);
            podzespolWzamowieniu.usunPodzespol(this);
        }
    }
}
