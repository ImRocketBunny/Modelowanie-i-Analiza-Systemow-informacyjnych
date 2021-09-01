package Models;

import javax.persistence.*;
import java.util.List;
@Entity
public class PodzespolWzamowieniu {
    @Id
    @GeneratedValue
    private Long id;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private Integer ilosc;

    @ManyToOne
    private PodzespolKomputerowy podzespolKomputerowy;
    @ManyToOne
    private Zamowienie zamowienie;

    @Basic
    public Integer getIlosc() {
        return ilosc;
    }

    public void setIlosc(Integer ilosc) {
        this.ilosc = ilosc;
    }
    @Transient
    public Double getCena() {
        return this.podzespolKomputerowy.getCena()*getIlosc();
    }




    @ManyToOne
    public PodzespolKomputerowy getPodzespolKomputerowy() {
        return podzespolKomputerowy;
    }

    public void setPodzespolKomputerowy(PodzespolKomputerowy podzespolKomputerowy) throws Exception {
        if(podzespolKomputerowy==null){
            throw new Exception("Bledny podzespol");
        }
        this.podzespolKomputerowy = podzespolKomputerowy;
    }
    @ManyToOne
    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) throws Exception {
        if(zamowienie==null){
            throw new Exception("Bledne zaqmowienie");
        }
        this.zamowienie = zamowienie;
    }


    public PodzespolWzamowieniu() {

    }


    public PodzespolWzamowieniu(PodzespolKomputerowy podzespolKomputerowy, Zamowienie zamowienie, Integer ilosc) throws Exception {
        setPodzespolKomputerowy(podzespolKomputerowy);
        setZamowienie(zamowienie);
        setIlosc(ilosc);

        podzespolKomputerowy.dodajPodzespolWzamowieniu(this);
        zamowienie.dodajPodzespolWZamowieniu(this);
    }



    public void dodajZamowienie(Zamowienie zamowienie) throws Exception {
        setZamowienie(zamowienie);
        zamowienie.dodajPodzespolWZamowieniu(this);

    }

    public void usunZamowienie(Zamowienie zamowienie) {
        if(this.zamowienie==zamowienie){
            this.zamowienie=null;
            zamowienie.usunPodzesolWZamowieniu(this);
        }

    }

    public void dodajPodzespol(PodzespolKomputerowy podzespolKomputerowy) throws Exception {
        setPodzespolKomputerowy(podzespolKomputerowy);
        podzespolKomputerowy.dodajPodzespolWzamowieniu(this);
    }


    public void usunPodzespol(PodzespolKomputerowy podzespolKomputerowy) {
        if(this.podzespolKomputerowy==podzespolKomputerowy){
           this.podzespolKomputerowy=null;
           podzespolKomputerowy.usunPodzespolWzamowieniu(this);
        }
    }
}
