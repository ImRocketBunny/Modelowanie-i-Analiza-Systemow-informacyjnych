package Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
public class SpecjalistaDsReklamacji extends Pracownik{


    @Id
    @GeneratedValue
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany
    private List<Reklamacja> reklamacje;

    private Integer stawkaZaGodzine = 18;
    private final static Integer maxPremia = 15;


    @OneToMany
    public List<Reklamacja> getReklamacje() {
        return reklamacje;
    }

    public void setReklamacje(List<Reklamacja> reklamacje) {
        this.reklamacje = reklamacje;
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


    public SpecjalistaDsReklamacji() {

    }

    private SpecjalistaDsReklamacji(Double pensja, String plec,LocalDate dataZatrudnienia) throws Exception {
        super(pensja, plec,dataZatrudnienia);
    }


    public void dodajReklamacje(Reklamacja reklamacja) throws Exception {
        if(!reklamacje.contains(reklamacja)){
            reklamacje.add(reklamacja);
            reklamacja.dodajSpecjalisteDsReklamacji(this);
        }
    }
    public void usunReklamacje(Reklamacja reklamacja){
        if(reklamacje.contains(reklamacja)){
            reklamacje.remove(reklamacja);
            reklamacja.usunSpecjalisteDsReklamacji(this);
        }
    }

    public Double obliczWyplate(){
        return (this.getPensja()+(this.getPensja()*this.getPremia()/10))*160;
    }

    public static SpecjalistaDsReklamacji stworzPracownika(Osoba osoba, Double pensja, String plec) throws Exception {
        SpecjalistaDsReklamacji pracownik = new SpecjalistaDsReklamacji(pensja,plec,LocalDate.now());
        osoba.dodajPracownika(pracownik);
        pracownik.setOsoba(osoba);
        return  pracownik;
    }
    public static SpecjalistaDsReklamacji stworzPracownika(String pesel, String imie, String nazwisko, String adresZamieszkania, String adresEmail, LocalDate dataUrodzenia, Double pensja, String plec) throws Exception {
        Osoba osoba = new Osoba(pesel,imie,nazwisko,adresZamieszkania,adresEmail,dataUrodzenia);
        SpecjalistaDsReklamacji pracownik = new SpecjalistaDsReklamacji(pensja,plec,LocalDate.now());
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

