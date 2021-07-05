package atrybut;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Klient {
    private String imie;
    private String  nazwisko;
    private String email;
    private LocalDate dataUrodzenia;
    private String adres;

    private List<Pytanie> pytania;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }



    public Klient(String imie, String nazwisko, String email, LocalDate dataUrodzenia,String adres){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.email= email;
        this.dataUrodzenia = dataUrodzenia;
        this.adres=adres;
        this.pytania= new ArrayList<>();
    }


    public void addPytanie(Pytanie newPytanie) {
        if(!pytania.contains(newPytanie)) {
            pytania.add(newPytanie);
            newPytanie.setKlient(this);
        }
    }

    public void removePytanie(Pytanie removePytanie){
        pytania.remove(removePytanie);
        removePytanie.getObslugaKlienta().removePytanie(removePytanie);
        removePytanie.setKlient(null);
        removePytanie.setObslugaKlienta(null);
    }

    public String toString(){
        String pytaniastr = "";

        for (Pytanie pyt:pytania
             ) {
            pytaniastr+=pyt.toString()+"\n";
        }
        return "Klient: "+this.getImie()+"\n"+pytaniastr;
    }





}
