package klasaAbstrakcyjna;

import java.util.List;

public class Porcesor extends PodzespolKomputerowy{
    private Integer iloscRdzeni;
    private Integer iloscWatkow;
    private String rodzajObslugiwanejPamieci;
    private List<String> trybyPracyPamieci;
    private Integer iloscCache;


    public Integer getIloscRdzeni() {
        return iloscRdzeni;
    }

    public void setIloscRdzeni(Integer iloscRdzeni) {
        this.iloscRdzeni = iloscRdzeni;
    }

    public Integer getIloscWatkow() {
        return iloscWatkow;
    }

    public void setIloscWatkow(Integer iloscWatkow) {
        this.iloscWatkow = iloscWatkow;
    }

    public String getRodzajObslugiwanejPamieci() {
        return rodzajObslugiwanejPamieci;
    }

    public void setRodzajObslugiwanejPamieci(String rodzajObslugiwanejPamieci) {
        this.rodzajObslugiwanejPamieci = rodzajObslugiwanejPamieci;
    }

    public List<String> getTrybyPracyPamieci() {
        return trybyPracyPamieci;
    }

    public void setTrybyPracyPamieci(List<String> trybyPracyPamieci) {
        this.trybyPracyPamieci = trybyPracyPamieci;
    }

    public Integer getIloscCache() {
        return iloscCache;
    }

    public void setIloscCache(Integer iloscCache) {
        this.iloscCache = iloscCache;
    }

    public Porcesor(String numerSeryjnyProducenta, String nazwaProducenta, String nazwaModelu, String kodProducenta, Integer iloscRdzeni, Integer iloscWatkow, String rodzajObslugiwanejPamieci, List<String> trybyPracyPamieci, Integer iloscCache) {
        super(numerSeryjnyProducenta, nazwaProducenta, nazwaModelu, kodProducenta);
        this.iloscRdzeni = iloscRdzeni;
        this.iloscWatkow = iloscWatkow;
        this.rodzajObslugiwanejPamieci = rodzajObslugiwanejPamieci;
        this.trybyPracyPamieci = trybyPracyPamieci;
        this.iloscCache = iloscCache;
    }

    @Override
    public String getPamiec() {
        return getRodzajObslugiwanejPamieci();
    }//nazewnictwo
}
