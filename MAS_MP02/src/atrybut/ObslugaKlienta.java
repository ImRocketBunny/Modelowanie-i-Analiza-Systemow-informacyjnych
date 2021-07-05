package atrybut;

import zwykła.PodzesolKomputerowy;

import java.util.ArrayList;
import java.util.List;

public class ObslugaKlienta {
    private String imie;
    private String  nazwisko;
    private String email;
    private String dzial;

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

    public String getDzial() {
        return dzial;
    }

    public void setDzial(String dzial) {
        this.dzial = dzial;
    }


    public ObslugaKlienta(String imie, String nazwisko, String email, String dzial){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.email=email;
        this.dzial=dzial;
        this.pytania=new ArrayList<>();
    }

    public void addPytanie(Pytanie newPytanie) {
        if(!pytania.contains(newPytanie)) {
            pytania.add(newPytanie);
            newPytanie.setObslugaKlienta(this);
        }
    }

    public void removePytanie(Pytanie removePytanie){
        pytania.remove(removePytanie);
        removePytanie.getKlient().removePytanie(removePytanie);
        removePytanie.setKlient(null);
        removePytanie.setObslugaKlienta(null);
    }
    public String toString(){
        String pytaniastr = "";

        for (Pytanie pyt:pytania
        ) {
            pytaniastr+=pyt.toString()+"\n";
        }
       return "Procownik obslugi: "+this.getImie()+"\n"+pytaniastr;
    }

}
