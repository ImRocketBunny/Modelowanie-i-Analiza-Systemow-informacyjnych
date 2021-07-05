package klasaAbstrakcyjna;

public class PlytaGlowna extends PodzespolKomputerowy{

    private String chipset;
    private String socketProcesora;
    private Integer iloscWejscPci;
    private Integer iloscWejscUSB;
    private String  rodzajSlotowPamieci;


    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getSocketProcesora() {
        return socketProcesora;
    }

    public void setSocketProcesora(String socketProcesora) {
        this.socketProcesora = socketProcesora;
    }

    public Integer getIloscWejscPci() {
        return iloscWejscPci;
    }

    public void setIloscWejscPci(Integer iloscWejscPci) {
        this.iloscWejscPci = iloscWejscPci;
    }

    public Integer getIloscWejscUSB() {
        return iloscWejscUSB;
    }

    public void setIloscWejscUSB(Integer iloscWejscUSB) {
        this.iloscWejscUSB = iloscWejscUSB;
    }

    public String getRodzajSlotowPamieci() {
        return rodzajSlotowPamieci;
    }

    public void setRodzajSlotowPamieci(String rodzajSlotowPamieci) {
        this.rodzajSlotowPamieci = rodzajSlotowPamieci;
    }

    public PlytaGlowna(String numerSeryjnyProducenta, String nazwaProducenta, String nazwaModelu, String kodProducenta, String chipset, String socketProcesora, Integer iloscWejscPci, Integer iloscWejscUSB, String rodzajSlotowPamieci) {
        super(numerSeryjnyProducenta, nazwaProducenta, nazwaModelu, kodProducenta);
        this.chipset = chipset;
        this.socketProcesora = socketProcesora;
        this.iloscWejscPci = iloscWejscPci;
        this.iloscWejscUSB = iloscWejscUSB;
        this.rodzajSlotowPamieci = rodzajSlotowPamieci;
    }

    @Override
    public String getPamiec() {
        return getRodzajSlotowPamieci();
    }
}
