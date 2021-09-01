package Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public abstract class PodzespolKomputerowy {
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    private String producent;
    private String kodProducenta;
    private String ean;
    private String nazwa;
    private String typGwarancji;
    private Integer dlugoscGwarancji;
    private Double cena;
    @OneToMany
    private List<PodzespolWzamowieniu> podzespolyWzamowieniach = new ArrayList<>();
    @OneToMany
    private List<Pytanie> pytania = new ArrayList<>();

    @Basic
    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }
    @Basic
    public String getKodProducenta() {
        return kodProducenta;
    }

    public void setKodProducenta(String kodProducenta) {
        this.kodProducenta = kodProducenta;
    }
    @Basic
    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }
    @Basic
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    @Basic
    public String getTypGwarancji() {
        return typGwarancji;
    }

    public void setTypGwarancji(String typGwarancji) {
        this.typGwarancji = typGwarancji;
    }
    @Basic
    public Integer getDlugoscGwarancji() {
        return dlugoscGwarancji;
    }

    public void setDlugoscGwarancji(Integer dlugoscGwarancji) {
        this.dlugoscGwarancji = dlugoscGwarancji;
    }
    @Basic
    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    @OneToMany
    public List<PodzespolWzamowieniu> getPodzespolyWzamowieniach() {
        return podzespolyWzamowieniach;
    }

    public void setPodzespolyWzamowieniach(List<PodzespolWzamowieniu> podzespolyWzamowieniach) {
        this.podzespolyWzamowieniach = podzespolyWzamowieniach;
    }

    @OneToMany
    public List<Pytanie> getPytania() {
        return pytania;
    }

    public void setPytania(List<Pytanie> pytania) {
        this.pytania = pytania;
    }

    public PodzespolKomputerowy() {

    }

    public PodzespolKomputerowy(String producent, String kodProducenta, String ean, String nazwa, String typGwarancji, Integer dlugoscGwarancji, Double cena) {
        this.producent = producent;
        this.kodProducenta = kodProducenta;
        this.ean = ean;
        this.nazwa = nazwa;
        this.typGwarancji = typGwarancji;
        this.dlugoscGwarancji = dlugoscGwarancji;
        this.cena = cena;
    }



    @Override
    public String toString() {
        return "Producent: " +producent+"\n"+
                "Kod Producenta: " + kodProducenta +"\n"+
                "EAN: " + ean+"\n"+
                "Nazwa: " +  nazwa +"\n"+
                "Typ gwarancji: " + typGwarancji +"\n"+
                "Dlugosc Gwarancji: " + dlugoscGwarancji +" miesiace \n";

    }

    public abstract void dodajPytanie(Pytanie pytanie) throws Exception;
    public abstract void usunPytanie(Pytanie pytanie) throws Exception;


    public abstract void dodajPodzespolWzamowieniu(PodzespolWzamowieniu podzespolWzamowieniu) throws Exception;
    public abstract void usunPodzespolWzamowieniu(PodzespolWzamowieniu podzespolWzamowieniu);



}
