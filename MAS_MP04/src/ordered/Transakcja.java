package ordered;

public class Transakcja {
    private String id;
    private String kontoDocelowe;
    private String kwota;
    private String tytul;


    public Transakcja(String id, String kontoDocelowe, String kwota, String tytul) {
        this.id = id;
        this.kontoDocelowe = kontoDocelowe;
        this.kwota = kwota;
        this.tytul = tytul;
    }
    public String toString(){
        return this.id+" : "+this.kontoDocelowe+" : "+this.kwota+" : "+this.tytul;
    }
}
