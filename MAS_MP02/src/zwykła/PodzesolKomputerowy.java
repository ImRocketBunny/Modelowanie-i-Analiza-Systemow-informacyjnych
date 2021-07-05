package zwykła;

import java.util.ArrayList;
import java.util.List;

public class PodzesolKomputerowy {
    private String numerSeryjnyProducenta;
    private String nazwaProducenta;

    private List<Zamowienie> zamowienia = new ArrayList<>();

    public String getNumerSeryjnyProducenta() {
        return numerSeryjnyProducenta;
    }

    public void setNumerSeryjnyProducenta(String numerSeryjnyProducenta) {
        this.numerSeryjnyProducenta = numerSeryjnyProducenta;
    }

    public String getNazwaProducenta() {
        return nazwaProducenta;
    }

    public void setNazwaProducenta(String nazwaProducenta) {
        this.nazwaProducenta = nazwaProducenta;
    }

    public PodzesolKomputerowy(String numerSeryjnyProducenta,String nazwaProducenta){
        this.numerSeryjnyProducenta=numerSeryjnyProducenta;
        this.nazwaProducenta=nazwaProducenta;
    }
    public void addZamowienie(Zamowienie zamowienie) {

        if(!zamowienia.contains(zamowienia)) {
            zamowienia.add(zamowienie);

            zamowienie.addPodzesolKomputerowy(this);
        }
    }

    public void removeZamowienie(Zamowienie zamowienieToRemove) {
        if(zamowienia.contains(zamowienieToRemove)) {
            zamowienia.remove(zamowienieToRemove);

            zamowienieToRemove.removePodzesolKomputerowy(this);
        }
    }
    @Override
    public String toString(){
        String str = "";
        for (Zamowienie zam: zamowienia
             ) {
            str+=zam.getNumer()+", "+ zam.getData().toString()+", "+zam.getStatus()+"\n";
        }
        return "PodzesolKomputerowy: "+this.numerSeryjnyProducenta+", Producent: "+this.nazwaProducenta+"\n"+str;

    }
}
