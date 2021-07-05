package bag;

import java.time.LocalDate;

public class Zamowienie {
    private LocalDate data;

    private Klient Klient;
    private Danie danie;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Klient getKlient() {
        return Klient;
    }

    public void setKlient(Klient klient) throws Exception {
        if(klient==null){
            throw new Exception("Bledny Kleint");
        }
        Klient = klient;
    }

    public Danie getDanie() {

        return danie;
    }

    public void setDanie(Danie danie) throws Exception {
        if(danie==null){
            throw new Exception("Blednye danie");
        }
        this.danie = danie;
    }

    public Zamowienie(LocalDate data, Klient klient, Danie danie) throws Exception {
        this.data = data;
        this.setDanie(danie);
        this.setKlient(klient);
    }

    public String toString(){
        return this.data+" "+this.danie.getNazwa();
    }
}
