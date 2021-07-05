package ordered;

import java.util.ArrayList;
import java.util.List;

public class KontoBankowe {
    private String numer;
    private Osoba wlasciciel;
    private List<Transakcja> historiaTransakcji; //transakcie uporzadkowane wzgledem momentu dodania

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public Osoba getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(Osoba wlasciciel) throws Exception {
        if(wlasciciel==null){
            throw new Exception("Osoba nie moze byc nullem");
        }
        this.wlasciciel = wlasciciel;
    }

    public KontoBankowe(String numer, Osoba wlasciciel) throws Exception {
        this.numer = numer;
        setWlasciciel(wlasciciel);
        this.historiaTransakcji=new ArrayList<>();
    }

    public void makeTransfer(Transakcja tr){
        if(!historiaTransakcji.contains(tr))
            historiaTransakcji.add(tr);
    }

    public void showHistory(){
        for (Transakcja tr:historiaTransakcji
             ) {
            System.out.println(tr);
        }
    }
}
