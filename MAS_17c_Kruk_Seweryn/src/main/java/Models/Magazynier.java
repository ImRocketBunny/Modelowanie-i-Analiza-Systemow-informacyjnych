package Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
public class Magazynier extends Pracownik{
    @OneToMany
    private List<Zamowienie> zamowienia;


    private Integer stawkaZaGodzine = 8;
    private final static Integer maxPremia = 5;



    public Magazynier(){

    }




    private Magazynier(Double pensja, String plec, LocalDate now) throws Exception {
        super(pensja,plec,now);
    }


    @OneToMany
    public List<Zamowienie> getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(List<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }
    @Basic
    public Integer getStawkaZaGodzine() {
        return stawkaZaGodzine;
    }

    public void setStawkaZaGodzine(Integer stawkaZaGodzine) {
        this.stawkaZaGodzine = stawkaZaGodzine;
    }

    public static Integer getMaxPremia() {
        return maxPremia;
    }


    public void dodajZamowienie(Zamowienie zamowienie) throws Exception{
        if(!zamowienia.contains(zamowienie)){
            zamowienia.add(zamowienie);
            zamowienie.dodajMagazyniera(this);
        }
    }

    public void usunZamowienie(Zamowienie zamowienie) throws Exception {
        if(zamowienia.contains(zamowienie)){
            zamowienia.remove(zamowienie);
            zamowienie.usunMagazyniera(this);
        }
    }
    public Double obliczWyplate(){
        return (this.getPensja()+(this.getPensja()*this.getPremia()/10))*160;
    }

    public Magazynier stworzPracownika(Osoba osoba, Double pensja, String plec) throws Exception {
        Magazynier pracownik = new Magazynier(pensja,plec,LocalDate.now());
        osoba.dodajPracownika(pracownik);
        pracownik.setOsoba(osoba);
        return pracownik;
    }
    public static Magazynier stworzPracownika(String pesel, String imie, String nazwisko, String adresZamieszkania, String adresEmail, LocalDate dataUrodzenia, Double pensja, String plec) throws Exception {
        Osoba osoba = new Osoba(pesel,imie,nazwisko,adresZamieszkania,adresEmail,dataUrodzenia);
        Magazynier pracownik = new Magazynier(pensja,plec,LocalDate.now());
        osoba.dodajPracownika(pracownik);
        pracownik.setOsoba(osoba);
        return  pracownik;
    }
    @Override
    public void usunOsobe(Osoba osoba) {
        if(this.getOsoba()==osoba){
            this.setOsoba(null);
            osoba.usunPracownika(this);
        }
    }
}
