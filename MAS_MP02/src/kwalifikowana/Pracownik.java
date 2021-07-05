package kwalifikowana;

import zwykła.Zamowienie;

import java.util.ArrayList;
import java.util.List;

public class Pracownik {
    private String imie;
    private String naziwsko;
    private String email;
    private String pesel;

    private List<Sklep> sklepy = new ArrayList<>();

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNaziwsko() {
        return naziwsko;
    }

    public void setNaziwsko(String naziwsko) {
        this.naziwsko = naziwsko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Pracownik(String imie, String naziwsko, String email, String pesel) {
        this.imie = imie;
        this.naziwsko = naziwsko;
        this.email = email;
        this.pesel = pesel;
    }
    public void addSklep(Sklep skl) {

        if(!sklepy.contains(skl)) {
            sklepy.add(skl);

            skl.addPracownikQ(this);

        }
    }
    public void removeSklep(Sklep skl){
        if(sklepy.contains(skl)){
            sklepy.remove(skl);
            skl.removePrawcownikQ(this);
        }
    }
    public String toString(){
        String listString = "";
        for (Sklep skl:sklepy
             ) {
            listString+=skl.getNazwa()+", "+ skl.getAdres()+"\n";
        }
        return this.getImie()+", "+this.getPesel()+"\n"+listString;
    }



}
