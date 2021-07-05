package kwalifikowana;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Sklep {
    private String nazwa;
    private String adres;

    private Map<String, Pracownik> pracownikQ = new HashMap<>();

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }



    public Sklep(String nazwa, String adres){
        this.nazwa=nazwa;
        this.adres=adres;
    }


    public void addPracownikQ(Pracownik prac){

        if(!pracownikQ.containsKey(prac.getPesel())){
            pracownikQ.put(prac.getPesel(),prac);
            prac.addSklep(this);
        }

    }

    public Pracownik findPracownikQualif(String pesel) throws Exception {

        if(!pracownikQ.containsKey(pesel)) {
            throw new Exception("nie ma procownika o podanym numerze presel " + pesel);
        }

        return pracownikQ.get(pesel);
    }
    public void removePrawcownikQ(Pracownik prac){
        if(pracownikQ.containsKey(prac.getPesel())){
            pracownikQ.remove(prac.getPesel(),prac);
            prac.removeSklep(this);
        }
    }
    public String toString(){
        String mapString = "";
        for (String pesel:pracownikQ.keySet()
        ) {
            mapString+=pracownikQ.get(pesel).getPesel()+" "+pracownikQ.get(pesel).getImie()+"\n";
        }
        return this.nazwa+ "\n"+mapString;
    }

}
