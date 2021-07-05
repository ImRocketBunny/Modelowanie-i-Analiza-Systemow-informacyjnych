package bag;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Danie {
    private String nazwa;
    private String[] skladniki;
    private List<Zamowienie> zamowienia;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String[] getSkladniki() {
        return skladniki;
    }

    public void setSkladniki(String[] skladniki) {
        this.skladniki = skladniki;
    }

    public List<Zamowienie> getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(List<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }

    public Danie(String nazwa, String[] skladniki) {
        this.nazwa = nazwa;
        this.skladniki = skladniki;
        this.zamowienia=new ArrayList<>();
    }

    public void addZamowienie(Zamowienie zamowienie) throws Exception {
        if(!zamowienia.contains(zamowienie)) {
            zamowienia.add(zamowienie);
            zamowienie.setDanie(this);
        }

    }
    public void removeZamowienie(Zamowienie zamowienie) throws Exception {
        zamowienia.remove(zamowienie);
        zamowienie.getKlient().removeZamowienie(zamowienie);
        zamowienie.setKlient(null);
        zamowienie.setDanie(null);
    }

    public String toString(){
        String skaldniki="";
        for (String str : this.skladniki
             ) {
            skaldniki+=str+", ";
        }

        return this.getNazwa()+" "+skaldniki;
    }
}
