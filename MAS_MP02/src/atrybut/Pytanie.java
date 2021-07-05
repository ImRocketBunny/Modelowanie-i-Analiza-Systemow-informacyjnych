package atrybut;

import java.time.LocalDate;

public class Pytanie {
    private LocalDate data;
    private String tresc;

    private Klient klient;
    private ObslugaKlienta obslugaKlienta;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public ObslugaKlienta getObslugaKlienta() {
        return obslugaKlienta;
    }

    public void setObslugaKlienta(ObslugaKlienta obslugaKlienta) {
        this.obslugaKlienta = obslugaKlienta;
    }

    public Pytanie(LocalDate data, String tresc, ObslugaKlienta ok, Klient kl){
        this.data=data;
        this.tresc=tresc;
        this.klient=kl;
        this.obslugaKlienta=ok;

        ok.addPytanie(this);
        kl.addPytanie(this);
    }

    public String toString(){
        return this.data+", "+this.tresc+"\n"+this.getKlient().getImie() +"\n"+ " " +this.getObslugaKlienta().getImie();
    }



}
