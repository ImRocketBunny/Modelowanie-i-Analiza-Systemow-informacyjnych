package subset;

import java.util.List;

public class GrupaOpercyjna {
    private Integer numer;
    private String nazwa;
    private List<Zolnierz> czlonkowie;
    private Zolnierz dowodca;

    public Integer getNumer() {
        return numer;
    }

    public void setNumer(Integer numer) {
        this.numer = numer;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<Zolnierz> getCzlonkowie() {
        return czlonkowie;
    }

    public void setCzlonkowie(List<Zolnierz> czlonkowie) {
        this.czlonkowie = czlonkowie;
    }

    public Zolnierz getDowodca() {
        return dowodca;
    }

    public void setDowodca(Zolnierz dowodca) throws Exception {
        if(dowodca==null){
            throw new Exception("Zolnierz nie istnieje");
        }
        if(!czlonkowie.contains(dowodca)){
            throw new Exception("Dowodca musi nalezec do grupy");
        }
        this.dowodca=dowodca;
    }

    public void addZolnierz(Zolnierz z) throws Exception {
        if(this.czlonkowie.contains(z)) {
            throw new Exception("Zolnierz juz nalezy do grupy");
        }
        if(z==null){
            throw new Exception("Zolnierz nie istnieje");
        }
        this.czlonkowie.add(z);

    }

    public GrupaOpercyjna(Integer numer, String nazwa) {
        this.numer = numer;
        this.nazwa = nazwa;
    }
}
