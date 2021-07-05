package wielodziedziczenie;

public class Drukarka extends UrządzenieElektryczne{
    private String typWydruku;
    private String szybkoscDruku;

    public String getTypWydruku() {
        return typWydruku;
    }

    public void setTypWydruku(String typWydruku) {
        this.typWydruku = typWydruku;
    }

    public String getSzybkoscDruku() {
        return szybkoscDruku;
    }

    public void setSzybkoscDruku(String szybkoscDruku) {
        this.szybkoscDruku = szybkoscDruku;
    }

    public Drukarka(Integer minVoltage, Integer maxVoltage, String typZlaczaZasilajacego, String typWydruku, String szybkoscDruku) {
        super(minVoltage, maxVoltage, typZlaczaZasilajacego);
        this.typWydruku = typWydruku;
        this.szybkoscDruku = szybkoscDruku;
    }
}
