package Models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class KlientPrywatny extends Klient{
    @OneToOne
    private Osoba osoba=null;
    public KlientPrywatny(){

    }



    private KlientPrywatny(String adresZamieszkania, String telefonKontaktowy) {
        super(adresZamieszkania, telefonKontaktowy);
    }
    @OneToOne
    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

    @Override
    public void dodajPytanie(Pytanie pytanie) throws Exception {
        if(!getPytania().contains(pytanie)){
            getPytania().add(pytanie);
        }
    }

    @Override
    public void usunPytanie(Pytanie pytanie) throws Exception {
        if(getPytania().contains(pytanie)){
            getPytania().remove(pytanie);
            pytanie.usunKlienta(this);
        }
    }

    @Override
    public void dodajZamowienie(Zamowienie zamowienie) throws Exception {
        if(!getZamowienia().contains(zamowienie)){
            getZamowienia().add(zamowienie);
            zamowienie.dodajKlienta(this);
        }
    }

    @Override
    public void usunZamowienie(Zamowienie zamowienie) throws Exception {
        if(getZamowienia().contains(zamowienie)){
            getZamowienia().remove(zamowienie);
            zamowienie.usunKlienta(this);
        }
    }



    public static KlientPrywatny stworzKlientaPrywatnego(Osoba osoba, String adresZamieszkania, String telefonKontaktowy) throws Exception {
        KlientPrywatny klient = new KlientPrywatny(adresZamieszkania,telefonKontaktowy);
        osoba.dodajKlienta(klient);
        klient.setOsoba(osoba);
        return klient;

    }

    public static KlientPrywatny stworzKlientaPrywatnego(String pesel, String imie, String nazwisko, String adresZamieszkaniaOsoba, String adresEmail, LocalDate dataUrodzenia, String adresZamieszkaniaKliennt, String telefonKontaktowy) throws Exception {
        Osoba osoba = new Osoba(pesel,imie,nazwisko,adresZamieszkaniaOsoba,adresEmail,dataUrodzenia);
        KlientPrywatny klient = new KlientPrywatny(adresZamieszkaniaKliennt,telefonKontaktowy);
        osoba.dodajKlienta(klient);
        klient.setOsoba(osoba);
        return klient;

    }

    public void usunOsobe(Osoba osoba){
        if(this.osoba==osoba){
            this.osoba=null;
            osoba.usunKlienta(this);
        }
    }
    public String gettyp(){
        return "Klient Prywatny";
    }

    @Override
    public String toString() {
        return "KlientPrywatny{" +
                "osoba=" + osoba +
                '}';
    }
}
