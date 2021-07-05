package bag;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Klient {
    private String pesel;
    private String nazwisko;
    private String imie;
    private List<Zamowienie> zamowienia;

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public List<Zamowienie> getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(List<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }

    public Klient(String pesel, String nazwisko, String imie) {
        this.pesel = pesel;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.zamowienia=new ArrayList<>();

    }
    public void addZamowienie(Zamowienie zamowienie) throws Exception {
        if(!zamowienia.contains(zamowienie)) {
            zamowienia.add(zamowienie);
            zamowienie.setKlient(this);
        }
    }

    public void removeZamowienie(Zamowienie zamowienie) throws Exception {
        zamowienia.remove(zamowienie);
        zamowienie.getDanie().removeZamowienie(zamowienie);
        zamowienie.setKlient(null);
        zamowienie.setDanie(null);
    }

    public String toString(){
        return this.imie+" "+this.nazwisko+" "+this.pesel+"\n"+getZamowienia().toString();
    }
}
