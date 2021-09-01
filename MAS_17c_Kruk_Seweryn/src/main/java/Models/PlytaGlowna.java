package Models;

import javax.persistence.*;

@Entity
public class PlytaGlowna extends PodzespolKomputerowy{
    public enum standardPlyty{EATX,ATX,mATX,mini_ATX}

    private Enum standardPlyty;
    private String chipsetPlyty;
    private String gniazdoProcesora;
    private String standardPamieci;
    private Integer iloscSlotowPamieci;



    @Enumerated
    public Enum getStandardPlyty() {
        return standardPlyty;
    }

    public void setStandardPlyty(Enum standardPlyty) {
        this.standardPlyty = standardPlyty;
    }
    @Basic
    public String getChipsetPlyty() {
        return chipsetPlyty;
    }

    public void setChipsetPlyty(String chipsetPlyty) {
        this.chipsetPlyty = chipsetPlyty;
    }
    @Basic
    public String getGniazdoProcesora() {
        return gniazdoProcesora;
    }

    public void setGniazdoProcesora(String gniazdoProcesora) {
        this.gniazdoProcesora = gniazdoProcesora;
    }
    @Basic
    public String getStandardPamieci() {
        return standardPamieci;
    }

    public void setStandardPamieci(String standardPamieci) {
        this.standardPamieci = standardPamieci;
    }
    @Basic
    public Integer getIloscSlotowPamieci() {
        return iloscSlotowPamieci;
    }

    public void setIloscSlotowPamieci(Integer iloscSlotowPamieci) {
        this.iloscSlotowPamieci = iloscSlotowPamieci;
    }

    public PlytaGlowna() {

    }

    public PlytaGlowna(String producent, String kodProducenta, String ean, String nazwa, String typGwarancji, Integer dlugoscGwarancji, Double cena, Enum standardPlyty, String chipsetPlyty, String gniazdoProcesora, String standardPamieci, Integer iloscSlotowPamieci) {
        super(producent, kodProducenta, ean, nazwa, typGwarancji, dlugoscGwarancji, cena);
        this.standardPlyty = standardPlyty;
        this.chipsetPlyty = chipsetPlyty;
        this.gniazdoProcesora = gniazdoProcesora;
        this.standardPamieci = standardPamieci;
        this.iloscSlotowPamieci = iloscSlotowPamieci;
    }


    @Override
    public String toString() {
        return super.toString()+
                "Standard plyty: " + standardPlyty +'\n'+
                "Chipset plyty: " + chipsetPlyty +'\n'+
                "Gniazdo procesora: " + gniazdoProcesora +'\n'+
                "Standard pamieci: " + standardPamieci +'\n'+
                "Ilosc slotow pamieci: " + iloscSlotowPamieci;
    }

    @Override
    public void dodajPytanie(Pytanie pytanie) throws Exception {
        if(!getPytania().contains(pytanie)){
            getPytania().add(pytanie);
            pytanie.dodajPodzespol(this);
        }
    }
    @Override
    public void usunPytanie(Pytanie pytanie) throws Exception{
        if(getPytania().contains(pytanie)){
            getPytania().remove(pytanie);
            pytanie.usunPodzespol(this);
        }
    }

    @Override
    public void dodajPodzespolWzamowieniu(PodzespolWzamowieniu podzespolWzamowieniu) throws Exception {
        if(!getPodzespolyWzamowieniach().contains(podzespolWzamowieniu)){
            getPodzespolyWzamowieniach().add(podzespolWzamowieniu);
            podzespolWzamowieniu.dodajPodzespol(this);
        }
    }

    @Override
    public void usunPodzespolWzamowieniu(PodzespolWzamowieniu podzespolWzamowieniu) {
        if(getPodzespolyWzamowieniach().contains(podzespolWzamowieniu)){
            getPodzespolyWzamowieniach().remove(podzespolWzamowieniu);
            podzespolWzamowieniu.usunPodzespol(this);
        }
    }
}
