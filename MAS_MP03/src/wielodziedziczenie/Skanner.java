package wielodziedziczenie;

public class Skanner extends UrządzenieElektryczne{
    private String dpi;
    private  String formatSkanowania;

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getFormatSkanowania() {
        return formatSkanowania;
    }

    public void setFormatSkanowania(String formatSkanowania) {
        this.formatSkanowania = formatSkanowania;
    }

    public Skanner(Integer minVoltage, Integer maxVoltage, String typZlaczaZasilajacego, String dpi, String formatSkanowania) {
        super(minVoltage, maxVoltage, typZlaczaZasilajacego);
        this.dpi = dpi;
        this.formatSkanowania = formatSkanowania;
    }
}
