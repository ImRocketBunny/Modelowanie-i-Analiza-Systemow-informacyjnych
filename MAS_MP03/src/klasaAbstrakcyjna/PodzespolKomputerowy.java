package klasaAbstrakcyjna;

public abstract class PodzespolKomputerowy {
    private String numerSeryjnyProducenta;
    private String nazwaProducenta;
    private String nazwaModelu;
    private String kodProducenta;

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

    public String getNazwaModelu() {
        return nazwaModelu;
    }

    public void setNazwaModelu(String nazwaModelu) {
        this.nazwaModelu = nazwaModelu;
    }

    public String getKodProducenta() {
        return kodProducenta;
    }

    public void setKodProducenta(String kodProducenta) {
        this.kodProducenta = kodProducenta;
    }

    public PodzespolKomputerowy(String numerSeryjnyProducenta, String nazwaProducenta, String nazwaModelu, String kodProducenta) {
        this.numerSeryjnyProducenta = numerSeryjnyProducenta;
        this.nazwaProducenta = nazwaProducenta;
        this.nazwaModelu = nazwaModelu;
        this.kodProducenta = kodProducenta;
    }

    public abstract String getPamiec();
}
