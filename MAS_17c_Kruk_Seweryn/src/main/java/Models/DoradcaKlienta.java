package Models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
public class DoradcaKlienta extends Pracownik{
    private Integer stawkaZaGodzine = 12;
    private final static Integer maxPremia = 10;
    @OneToMany
    private List<Pytanie> pytania = new ArrayList();

    public DoradcaKlienta() {

    }


    public Integer getStawkaZaGodzine() {
        return stawkaZaGodzine;
    }

    public void setStawkaZaGodzine(Integer stawkaZaGodzine) {
        this.stawkaZaGodzine = stawkaZaGodzine;
    }

    public static Integer getMaxPremia() {
        return maxPremia;
    }
    @OneToMany
    public List<Pytanie> getPytania() {
        return pytania;
    }

    public void setPytania(List<Pytanie> pytania) {
        this.pytania = pytania;
    }


    private DoradcaKlienta(Double pensja, String plec,LocalDate now) throws Exception {
        super(pensja, plec,now);
    }

    public void dodajPytanie(Pytanie pytanie) {
        if(!pytania.contains(pytanie)){
            pytania.add(pytanie);
        }
    }

    public void usunPytanie(Pytanie pytanie){
        if(pytania.contains(pytanie)){
            pytania.remove(pytanie);
            pytanie.usunDoradce(this);
        }
    }
    public Double obliczWyplate(){
        return (this.getPensja()+(this.getPensja()*this.getPremia()/10))*160;
    }

    public static DoradcaKlienta stworzPracownika(Osoba osoba, Double pensja, String plec) throws Exception {
        DoradcaKlienta pracownik = new DoradcaKlienta(pensja,plec,LocalDate.now());
        osoba.dodajPracownika(pracownik);
        pracownik.setOsoba(osoba);
        return  pracownik;
    }
    public static DoradcaKlienta stworzPracownika(String pesel, String imie, String nazwisko, String adresZamieszkania, String adresEmail, LocalDate dataUrodzenia, Double pensja, String plec) throws Exception {
        Osoba osoba = new Osoba(pesel,imie,nazwisko,adresZamieszkania,adresEmail,dataUrodzenia);
        DoradcaKlienta pracownik = new DoradcaKlienta(pensja,plec,LocalDate.now());
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
