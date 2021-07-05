package wielodziedziczenie;

public class UrzadzenieWielofunkcyjne extends Skanner implements IDrukarka{
    private Drukarka drukarka;


    @Override
    public String getTypWydruku() {
        return drukarka.getTypWydruku();
    }

    @Override
    public void setTypWydruku(String typWydruku) {
        drukarka.setTypWydruku(typWydruku);
    }

    @Override
    public String getSzybkoscDruku() {
        return drukarka.getSzybkoscDruku();
    }

    @Override
    public void setSzybkoscDruku(String szybkoscDruku) {
        drukarka.setSzybkoscDruku(szybkoscDruku);
    }

    public UrzadzenieWielofunkcyjne(Integer minVoltage, Integer maxVoltage, String typZlaczaZasilajacego, String dpi, String formatSkanowania, String typWydruku, String szybkoscWydruku) {
        super(minVoltage, maxVoltage, typZlaczaZasilajacego, dpi, formatSkanowania);
        this.drukarka=new Drukarka(null,null,null,typWydruku,szybkoscWydruku);
    }
}
