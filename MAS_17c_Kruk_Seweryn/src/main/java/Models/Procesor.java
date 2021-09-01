package Models;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class Procesor extends PodzespolKomputerowy{
    private String mikroarchitektura;
    private Integer tdp;
    private String linia;
    private String typGniazda;
    private Integer liczbaRdzeni;
    private Integer liczbaWatkow;

    @Basic
    public String getMikroarchitektura() {
        return mikroarchitektura;
    }

    public void setMikroarchitektura(String mikroarchitektura) {
        this.mikroarchitektura = mikroarchitektura;
    }
    @Basic
    public Integer getTdp() {
        return tdp;
    }

    public void setTdp(Integer tdp) {
        this.tdp = tdp;
    }
    @Basic
    public String getLinia() {
        return linia;
    }

    public void setLinia(String linia) {
        this.linia = linia;
    }
    @Basic
    public String getTypGniazda() {
        return typGniazda;
    }

    public void setTypGniazda(String typGniazda) {
        this.typGniazda = typGniazda;
    }
    @Basic
    public Integer getLiczbaRdzeni() {
        return liczbaRdzeni;
    }

    public void setLiczbaRdzeni(Integer liczbaRdzeni) {
        this.liczbaRdzeni = liczbaRdzeni;
    }
    @Basic
    public Integer getLiczbaWatkow() {
        return liczbaWatkow;
    }

    public void setLiczbaWatkow(Integer liczbaWatkow) {
        this.liczbaWatkow = liczbaWatkow;
    }

    public Procesor() {

    }

    public Procesor(String producent, String kodProducenta, String ean, String nazwa, String typGwarancji, Integer dlugoscGwarancji, Double cena, String mikroarchitektura, Integer tdp, String linia, String typGniazda, Integer liczbaRdzeni, Integer liczbaWatkow) {
        super(producent, kodProducenta, ean, nazwa, typGwarancji, dlugoscGwarancji, cena);
        this.mikroarchitektura = mikroarchitektura;
        this.tdp = tdp;
        this.linia = linia;
        this.typGniazda = typGniazda;
        this.liczbaRdzeni = liczbaRdzeni;
        this.liczbaWatkow = liczbaWatkow;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Mikroarchitektura" + mikroarchitektura + '\n' +
                "TDP: " + tdp + '\n' +
                "Linia: " + linia + '\n' +
                "Typ ganiazda: " + typGniazda + '\n' +
                "Liczba rdzeni: " + liczbaRdzeni + '\n' +
                "Liczba watkow: " + liczbaWatkow;
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
