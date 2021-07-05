package zwykła;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Zamowienie {
    private String numer;
    private LocalDate data;
    private String status;

    private List<PodzesolKomputerowy> podzesolyKomputerowe = new ArrayList<>();

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStstus(String status) {
        this.status = status;
    }



    public Zamowienie(String numer, LocalDate data, String status){
        this.numer=numer;
        this.data=data;
        this.status=status;
    }

    public void addPodzesolKomputerowy(PodzesolKomputerowy newPodzespolKomputerowy) {

        if(!podzesolyKomputerowe.contains(newPodzespolKomputerowy)) {
            podzesolyKomputerowe.add(newPodzespolKomputerowy);

            newPodzespolKomputerowy.addZamowienie(this);
        }
    }

    public void removePodzesolKomputerowy(PodzesolKomputerowy podzesolKomputerowyToRemove) {
        if(podzesolyKomputerowe.contains(podzesolKomputerowyToRemove)) {
            podzesolyKomputerowe.remove(podzesolKomputerowyToRemove);

            podzesolKomputerowyToRemove.removeZamowienie(this);
        }
    }

    @Override
    public String toString(){
        String str = "";
        for (PodzesolKomputerowy pk: podzesolyKomputerowe
        ) {
            str+=pk.getNumerSeryjnyProducenta()+", "+ pk.getNazwaProducenta()+"\n";
        }
        return "Zamowienie: "+this.numer+", Data: "+this.data.toString()+", Status"+this.status+"\n"+str;

    }


}
