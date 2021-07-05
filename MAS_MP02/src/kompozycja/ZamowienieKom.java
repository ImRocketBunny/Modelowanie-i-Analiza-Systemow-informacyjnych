package kompozycja;

import zwykła.PodzesolKomputerowy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ZamowienieKom {
    private String numer;
    private LocalDate data;
    private String status;

    private List<Opinia> opinie = new ArrayList<>();

    public ZamowienieKom(String numer, LocalDate data, String status){
        this.numer=numer;
        this.data=data;
        this.status=status;
    }

    public void addOpinia(Opinia newOpinia) {

        if(!opinie.contains(newOpinia)) {
            opinie.add(newOpinia);
        }
    }

    public void removeOpinia(Opinia removeOpinia){
        if(opinie.contains(removeOpinia)) {
            opinie.remove(removeOpinia);
            removeOpinia.removeZamowienie();
        }
    }


    @Override
    public String toString(){
        String str = "";
        for (Opinia pk: opinie
        ) {
            str+=pk.getData()+", "+ pk.getTresc()+", "+pk.getOcena()+"\n";
        }
        return "Zamowienie: "+this.numer+" "+this.data.toString()+" "+this.status+"\n Uwagi:\n"+str;

    }
}
