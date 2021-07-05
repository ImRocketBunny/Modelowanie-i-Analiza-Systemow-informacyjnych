package klasaAbstrakcyjna;

public class KartaGraficzna extends PodzespolKomputerowy{
    private String nazwaProducentaRdzenia;
    private Integer iloscPamieci;
    private String typPamieci;

    public String getNazwaProducentaRdzenia() {
        return nazwaProducentaRdzenia;
    }

    public void setNazwaProducentaRdzenia(String nazwaProducentaRdzenia) {
        this.nazwaProducentaRdzenia = nazwaProducentaRdzenia;
    }

    public Integer getIloscPamieci() {
        return iloscPamieci;
    }

    public void setIloscPamieci(Integer iloscPamieci) {
        this.iloscPamieci = iloscPamieci;
    }

    public void setTypPamieci(String typPamieci) {
        this.typPamieci = typPamieci;
    }

    public String getTypPamieci() {
        return typPamieci;
    }

    public KartaGraficzna(String numerSeryjnyProducenta, String nazwaProducenta, String nazwaModelu, String kodProducenta, String nazwaProducentaRdzenia, Integer iloscPamieci, String typPamieci) {
        super(numerSeryjnyProducenta, nazwaProducenta, nazwaModelu, kodProducenta);
        this.nazwaProducentaRdzenia = nazwaProducentaRdzenia;
        this.iloscPamieci = iloscPamieci;
        this.typPamieci = typPamieci;
    }

    @Override
    public String getPamiec() {
        return getTypPamieci();
    }
}
