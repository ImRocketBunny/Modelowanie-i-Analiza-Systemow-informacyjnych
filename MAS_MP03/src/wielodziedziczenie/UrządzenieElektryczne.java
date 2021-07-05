package wielodziedziczenie;

public abstract class UrządzenieElektryczne {
    private Integer minVoltage;
    private Integer maxVoltage;
    private String typZlaczaZasilajacego;

    public Integer getMinVoltage() {
        return minVoltage;
    }

    public void setMinVoltage(Integer minVoltage) {
        this.minVoltage = minVoltage;
    }

    public Integer getMaxVoltage() {
        return maxVoltage;
    }

    public void setMaxVoltage(Integer maxVoltage) {
        this.maxVoltage = maxVoltage;
    }

    public String getTypZlaczaZasilajacego() {
        return typZlaczaZasilajacego;
    }

    public void setTypZlaczaZasilajacego(String typZlaczaZasilajacego) {
        this.typZlaczaZasilajacego = typZlaczaZasilajacego;
    }

    public UrządzenieElektryczne(Integer minVoltage, Integer maxVoltage, String typZlaczaZasilajacego) {
        this.minVoltage = minVoltage;
        this.maxVoltage = maxVoltage;
        this.typZlaczaZasilajacego = typZlaczaZasilajacego;
    }
}
