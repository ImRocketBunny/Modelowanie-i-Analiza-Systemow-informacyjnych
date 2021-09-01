package Models;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class KlientFirma extends Klient{
    private String nazwa;
    private String nip;


    @Basic
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    @Basic
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String gettyp(){
        return "Klient Firma";
    }

    @Override
    public String toString() {
        return "KlientFirma{" +
                "nazwa='" + nazwa + '\'' +
                ", nip='" + nip + '\'' +
                '}';
    }

    public KlientFirma(String adresZamieszkania, String telefonKontaktowy, String nazwa, String nip) {
        super(adresZamieszkania, telefonKontaktowy);
        this.nazwa = nazwa;
        this.nip = nip;
    }

    public KlientFirma() {

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


}
